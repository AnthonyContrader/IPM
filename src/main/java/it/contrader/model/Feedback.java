package it.contrader.model;

public class Feedback
{
	/* VARIABLES */
	private int id;
	private int vote;
	private String review;
	
	/* CONSTRUCTORS */
	public Feedback () 
	{
		
	}
	
	public Feedback (int vote, String review) 
	{
		this.vote = vote;
		this.review = review;
	}
	
	public Feedback (int id, int vote, String review) 
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
	
	/* TRANSFORMATION OF STRING TO OBJECT */
	public String toString () 
	{
		return id + "\t" + vote + "\t\t" + review;
	}
	
	/* EQUALS METHOD */
	public boolean equals (Object obj) 
	{
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Feedback other = (Feedback) obj;
		
		if (id != other.id)
			return false;
		
		if (vote == 0) 
		{
			if (other.vote != 0)
				return false;
		}
		else if (vote != other.vote)
			return false;
		
		if (review == null) 
		{
			if (other.review != null)
				return false;
		}
		else if (!review.equals(other.review))
			return false;
		
		return true;
	}
}