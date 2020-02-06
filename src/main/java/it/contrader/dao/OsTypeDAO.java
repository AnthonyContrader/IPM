package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.OsType;


public class OsTypeDAO {
	private final String QUERY_ALL = "SELECT * FROM ostype";
	private final String QUERY_CREATE = "INSERT INTO ostype (id_ostype, name, command) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM ostype WHERE id_ostype=?";
	private final String QUERY_UPDATE = "UPDATE ostype SET id_ostype =?, name=?, command=?";
	private final String QUERY_DELETE = "DELETE FROM ostype WHERE id_type=?";
	
	public OsTypeDAO () {
		
	}
	
	public List <OsType> getAll() {
		List<OsType> osTypesList = new ArrayList<>(); 
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			OsType osType;
			while (resultSet.next()) {
				int id_ostype = resultSet.getInt("id_ostype");
				String name = resultSet.getString("name");
				String command = resultSet.getString("command");
				osType = new OsType(id_ostype, name, command);
				osType.setId(id_ostype);
				osTypesList.add(osType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return osTypesList;
	}

	public boolean insert (OsType osTypeToInsert) {
		Connection connection = ConnectionSingleton.getInstance();

		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, osTypeToInsert.getName());
			preparedStatement.setString(2, osTypeToInsert.getCommand());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	
	public OsType read (int id_ostype) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id_ostype);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, command;
			
			name = resultSet.getString("name");
			command = resultSet.getString("command");
			
			OsType osType = new OsType(name, command);
			osType.setId(resultSet.getInt("id"));
			
			return osType;
		
		}catch (SQLException e) {
			return null;
		}
	}
	
	public boolean update(OsType osTypeToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (osTypeToUpdate.getId() == 0)
			return false;

		OsType osTypeRead = read(osTypeToUpdate.getId());
		if (!osTypeRead.equals(osTypeToUpdate)) {
			try {
				if (osTypeToUpdate.getName() == null||osTypeToUpdate.getName().equals("")) {
					osTypeToUpdate.setName(osTypeRead.getName());
				}
				if (osTypeToUpdate.getCommand()==null||osTypeToUpdate.getCommand().equals("")) {
					osTypeToUpdate.setCommand(osTypeRead.getCommand());
				}
				
				PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, osTypeToUpdate.getId());
				preparedStatement.setString(2, osTypeToUpdate.getName());
				preparedStatement.setString(3, osTypeToUpdate.getCommand());;
				int a = preparedStatement.executeUpdate();
				if (a>0)
					return true;
				else
					return false;
			} catch (SQLException e) {
				return false;
			}
		}
		return false;
	}
	

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
	
}


