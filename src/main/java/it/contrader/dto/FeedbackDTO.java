package it.contrader.dto;

public class FeedbackDTO
{
	/* VARIABLES DECLARATION */
	private int id;
	private int vote;
	private String review;
	
	/* CONSTRUCTORS */
	public FeedbackDTO () 
	{
		
	}
	
	public FeedbackDTO (int vote, String review) 
	{
		this.vote = vote;
		this.review = review;
	}
	
	public FeedbackDTO (int id, int vote, String review) 
	{
		this.id = id;
		this.vote = vote;
		this.review = review;
	}
	
	/* GETTER AND SETTER METHODS */
	public int getId () 
	{
		return this.id;
	}
	
	public void setId (int id) 
	{
		this.id = id;
	}
	
	public int getVote () 
	{
		return this.vote;
	}
	
	public void setVote (int vote) 
	{
		this.vote = vote;
	}
	
	public String getReview () 
	{
		return this.review;
	}
	
	public void setReview (String review) 
	{
		this.review = review;
	}
	
	@Override
	public String toString () 
	{
		return id + "\t" + vote + "\t\t" + review;
	}
}
