package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Category;

public class CategoryDAO implements DAO<Category>
{
	/* QUERIES DECLARATION */
	private final String QUERY_ALL = "SELECT * FROM category";
	private final String QUERY_CREATE = "INSERT INTO category (name) values (?)";
	private final String QUERY_READ = "SELECT * FROM category WHERE id_cat = ?";
	private final String QUERY_UPDATE = "UPDATE category SET name = ? WHERE id_cat = ?";
	private final String QUERY_DELETE = "DELETE FROM category WHERE id_cat = ?";
	
	/* CONSTRUCTOR */
	public CategoryDAO ()
	{
		
	}
	
	/* CONNECTION TO DATABASE */
	public List<Category> getAll ()
	{
		List<Category> categoriesList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		
		try 
		{
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Category category;
			
			while (resultSet.next()) 
			{
				int id_cat = resultSet.getInt("id_cat");
				String name = resultSet.getString("name");
				category = new Category(name);
				category.setIdCat(id_cat);
				categoriesList.add(category);
			}
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return categoriesList;
		
	}
	
	/* METHOD TO INSERTION */
	public boolean insert(Category categoryToInsert)
	{
		Connection connection = ConnectionSingleton.getInstance();
		
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, categoryToInsert.getName());
			preparedStatement.execute();
			return true;
		}
		
		catch (SQLException e) 
		{
			return false;
		}
	}
	
	/* METHOD TO READ */
	public Category read (int id_cat) 
	{
		Connection connection = ConnectionSingleton.getInstance();
		
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id_cat);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name;
			
			name = resultSet.getString("name");
			Category category = new Category(name);
			category.setIdCat(resultSet.getInt("id_cat"));
			
			return category;
		}
		
		catch (SQLException e)
		{
			return null;
		}
	}
	
	/* METHOD TO UPDATE */
	public boolean update (Category categoryToUpdate) 
	{
		Connection connection = ConnectionSingleton.getInstance();
		
		if (categoryToUpdate.getIdCat() == 0)
			return false;
		
		Category categoryRead = read(categoryToUpdate.getIdCat());
		
		if (!categoryRead.equals(categoryToUpdate)) 
		{
			try 
			{
				if (categoryToUpdate.getName() == null || categoryToUpdate.getName().equals(""))
					categoryToUpdate.setName(categoryRead.getName());
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, categoryToUpdate.getName());
				preparedStatement.setInt(2, categoryToUpdate.getIdCat());
				int a = preparedStatement.executeUpdate();
				
				if (a > 0)
					return true;
				else
					return false;
			}
			
			catch (SQLException e)
			{
				return false;
			}
		}
		
		return false;
	}
	
	/* METHOD TO DELETE */
	public boolean delete (int id_cat)
	{
		Connection connection = ConnectionSingleton.getInstance();
		
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id_cat);
			
			int n = preparedStatement.executeUpdate();
			
			if (n != 0)
				return true;
		}
		
		catch (SQLException e) 
		{
		}
		
		return false;
	}
	
}