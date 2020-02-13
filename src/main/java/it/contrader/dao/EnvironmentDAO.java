package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Environment;

public class EnvironmentDAO implements DAO<Environment> {
	private final String QUERY_ALL = "SELECT * FROM environment";
	private final String QUERY_CREATE = "INSERT INTO environment (name, description, packetkey, categorykey) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM environment WHERE id_env=?";
	private final String QUERY_UPDATE = "UPDATE environment SET name=?, description=?, packetkey = ?, categorykey = ? WHERE id_env=?";
	private final String QUERY_DELETE = "DELETE FROM environment WHERE id_env=?";
	
	// Empty Constructor
	public EnvironmentDAO() {}
	
	public boolean insert(Environment packetToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, packetToInsert.getName() );
			preparedStatement.setString(2, packetToInsert.getDescription() );
			preparedStatement.setString(3, packetToInsert.getPacketKey() );
			preparedStatement.setString(4, packetToInsert.getCategoryKey() );
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public Environment read(int environmentId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, environmentId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			Environment readPacket = new Environment (
					resultSet.getString("name"),
					resultSet.getString("description"),
					resultSet.getString("packetkey"),
					resultSet.getString("categorykey")
					);
			
			readPacket.setId_env(
					resultSet.getInt("id_env")
					);
			
			return readPacket;
			
		} catch(SQLException e) {
			return null;
		}
	}
	
	public boolean update(Environment environmentToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if (environmentToUpdate.getId_env() == 0)
			return false;
		
		Environment environmentRead = read( environmentToUpdate.getId_env() );
		
		if ( !environmentRead.equals(environmentToUpdate) ) {
			try {
				if ( environmentToUpdate.getName() == null || environmentToUpdate.getName().equals(""))
					environmentToUpdate.setName( environmentRead.getName() );
				
				if ( environmentToUpdate.getDescription() == null || environmentToUpdate.getDescription().contentEquals(""))
					environmentToUpdate.setDescription( environmentRead.getDescription() );
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, environmentToUpdate.getName() );
				preparedStatement.setString(2, environmentToUpdate.getDescription() );
				preparedStatement.setString(3, environmentToUpdate.getPacketKey() );
				preparedStatement.setString(4, environmentToUpdate.getCategoryKey() );
				preparedStatement.setInt(5, environmentToUpdate.getId_env() );
				
				int updateResult = preparedStatement.executeUpdate();
				
				if (updateResult > 0)
					return true;
				else
					return false;
				
			} catch (SQLException e) {
				return false;
			}
		}
		
		return false;
	}
	
	public boolean delete(int environmentIdToDelete) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, environmentIdToDelete);
			int deleteResult = preparedStatement.executeUpdate();
			
			if (deleteResult != 0)
				return true;
			
		} catch (SQLException e) {
			return false;
		}
		
		return false;
	}
	
	public List<Environment> getAll() {
		Connection connection = ConnectionSingleton.getInstance();
		List<Environment> packetsList = new ArrayList<Environment>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			
			Environment environment;
			
			while ( resultSet.next() ) {
				int environmentId = resultSet.getInt("id_env");
				
				environment = new Environment (
						resultSet.getString("name"),
						resultSet.getString("description"),
						resultSet.getString("packetkey"),
						resultSet.getString("categorykey")
						);
				
				environment.setId_env(environmentId);
				
				packetsList.add(environment);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return packetsList;
	}
	
}
