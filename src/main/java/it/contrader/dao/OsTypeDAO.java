package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.OsType;
import it.contrader.utils.ConnectionSingleton;

public class OsTypeDAO implements DAO<OsType> {
	
	private final String QUERY_ALL = "SELECT * FROM ostype";
	private final String QUERY_CREATE = "INSERT INTO ostype (name, comm) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM ostype WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE ostype SET name=?, comm=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM ostype WHERE id=?";

	public OsTypeDAO() { }
	
	@Override
	public List<OsType> getAll() {
		List <OsType> osTypesList = new ArrayList<OsType>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet= statement.executeQuery(QUERY_ALL);
			OsType osType;
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String comm = resultSet.getString("comm");
				osType = new OsType(name, comm);
				osType.setId(id);
				osTypesList.add(osType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return osTypesList;
	}

	@Override
	public OsType read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet =preparedStatement.executeQuery();
			resultSet.next();
			String name, command;
			
			name=resultSet.getString("name");
			command=resultSet.getString("comm");
			OsType osType = new OsType(name, command);
			osType.setId(resultSet.getInt("id"));
			
			return osType;
		}catch (SQLException e) {
			return null;		}	
	}

	@Override
	public boolean insert(OsType osTypeToInsert) {
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

	@Override
	public boolean update(OsType osTypeToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if(osTypeToUpdate.getId()==0)
			return false;
		
		OsType osTypeRead = read(osTypeToUpdate.getId());
		if(!osTypeRead.equals(osTypeToUpdate)) {
			try {
				if (osTypeToUpdate.getName()==null || 
						osTypeToUpdate.getName().equals("")) {
					osTypeToUpdate.setName(osTypeRead.getName());
				}
				
				if (osTypeToUpdate.getCommand()==null || osTypeToUpdate.getCommand().equals("")) {
					osTypeToUpdate.setCommand(osTypeRead.getCommand());
				}
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, osTypeToUpdate.getName());
				preparedStatement.setString(2, osTypeToUpdate.getCommand());
				preparedStatement.setInt(3, osTypeToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a>0) {
					return true;
				}else {
					return false;
				}
 			} catch (SQLException e) {
 				return false;			
 			}
		}
		return false;
	}

	@Override
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
