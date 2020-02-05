package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Environment;
import it.contrader.model.User;

// Private query that cannot modified out from this class

public class EnvironmentDAO {
	private final String QUERY_ALL = "SELECT * FROM environment";
	private final String QUERY_READ = "SELECT * FROM environment WHERE id_env=?";
	private final String QUERY_CREATE = "INSERT INTO environment (name, description) VALUES (?,?)";
	private final String QUERY_UPDATE = "UPDATE environment SET name=?, description=? WHERE id_env=?";
	private final String QUERY_DELETE = "DELETE FROM environment WHERE id_env=?";
	
	public EnvironmentDAO (){
		
	}
	
	public List<Environment> getAll (){
		List<Environment> envList = new ArrayList();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Environment environment;
			while (resultSet.next()) {
				int id_env = resultSet.getInt("id_env");
				String name = resultSet.getString("name");
				String description = resultSet.getString("descripton");
				environment = new Environment (name, description);
				environment.setId_env(id_env);
				envList.add(environment);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return envList;
	}
	
	public boolean insert (Environment envToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, envToInsert.getName());
			preparedStatement.setString(2, envToInsert.getDescription());			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public Environment read (int id_env) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id_env);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, description;
			name = resultSet.getString("name");
			description = resultSet.getString("description");
			Environment environment = new Environment (name, description);
			return environment;
		}
		catch (SQLException e) {
			return null;
		}
	}
	
	public boolean update(Environment envToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		if (envToUpdate.getId_env() == 0)
			return false;

		Environment envRead = read(envToUpdate.getId_env());
		if (!envRead.equals(envToUpdate)) {
			try {
				if (envToUpdate.getName() == null || envToUpdate.getName().equals("")) {
					envToUpdate.setName(envRead.getName());
				}

				if (envToUpdate.getDescription() == null || envToUpdate.getDescription().equals("")) {
					envToUpdate.setDescription(envRead.getDescription());
				}
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, envToUpdate.getName());
				preparedStatement.setString(2, envToUpdate.getDescription());				preparedStatement.setInt(4, envToUpdate.getId_env());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}
		return false;
	}
	
	public boolean delete(int id_env) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id_env);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} 
		catch (SQLException e) {
		}
		return false;
	}
}