package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Feedback;

public class FeedbackDAO implements DAO<Feedback>
{
	/* QUERIES DECLARATION */
	private final String QUERY_ALL = "SELECT * FROM feedback";
	private final String QUERY_CREATE = "INSERT INTO feedback (vote, review) VALUES (?, ?)";
	private final String QUERY_READ = "SELECT * FROM feedback WHERE id = ?";
	private final String QUERY_UPDATE = "UPDATE feedback SET vote=?, review=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM feedback WHERE id = ?";
	
	/* CONSTRUCTOR */
	public FeedbackDAO () 
	{
		
	}
	
	/* CONNECTION TO DATABASE */
	public List<Feedback> getAll ()
	{
		List<Feedback> feedbacksList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		
		try 
		{
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Feedback feedback;
			
			while (resultSet.next()) 
			{
				int id = resultSet.getInt("id");
				int vote = resultSet.getInt("vote");
				String review = resultSet.getString("review");
				
				feedback = new Feedback(vote, review);
				feedback.setId(id);
				feedbacksList.add(feedback);
			}
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return feedbacksList;
	}
	
	/* METHOD TO INSERTION */
	public boolean insert (Feedback feedbackToInsert) 
	{
		Connection connection = ConnectionSingleton.getInstance();
		
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, feedbackToInsert.getVote());
			preparedStatement.setString(2, feedbackToInsert.getReview());
			preparedStatement.execute();
			
			return true;
		}
		
		catch (SQLException e) 
		{
			return false;
		}
	}
	
	/* METHOD TO READ */
	public Feedback read (int id) 
	{
		Connection connection = ConnectionSingleton.getInstance();
		
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			int vote;
			String review;
			
			vote = resultSet.getInt("vote");
			review = resultSet.getString("review");
			
			Feedback feedback = new Feedback(vote, review);
			feedback.setId(resultSet.getInt("id"));
			
			return feedback;
		}
		
		catch (SQLException e) 
		{
			return null;
		}
	}
	
	/*METHOD TO UPDATE */
	public boolean update (Feedback feedbackToUpdate) 
	{
		Connection connection = ConnectionSingleton.getInstance();
		
		if (feedbackToUpdate.getId() == 0)
			return false;
		
		Feedback feedbackRead = read(feedbackToUpdate.getId());
		
		if (!feedbackRead.equals(feedbackToUpdate)) 
		{
			try 
			{
				if (feedbackToUpdate.getVote() == 0 || feedbackToUpdate.getVote() == 0)
					feedbackToUpdate.setVote(feedbackRead.getVote());
				
				if (feedbackToUpdate.getReview() == null || feedbackToUpdate.getReview().equals(""))
					feedbackToUpdate.setReview(feedbackRead.getReview());
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, feedbackToUpdate.getVote());
				preparedStatement.setString(2, feedbackToUpdate.getReview());
				preparedStatement.setInt(3, feedbackToUpdate.getId());
				
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
	public boolean delete (int id) 
	{
		Connection connection = ConnectionSingleton.getInstance();
		
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			
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
