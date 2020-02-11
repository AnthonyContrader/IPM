package it.contrader.dto;

public class CategoryDTO
{
	/* VARIABLE DECLARATION */
	private int id_cat;
	private String name;
	
	/* CONSTRUCTORS */
	public CategoryDTO () 
	{
		
	}
	
	public CategoryDTO (String name)
	{
		this.name = name;
	}
	
	public CategoryDTO (int id_cat, String name) 
	{
		this.id_cat = id_cat;
		this.name = name;
	}
	
	/* GETTER AND SETTER METHODS */
	public int getIdCat () 
	{
		return this.id_cat;
	}
	
	public void sedIdCat (int id_cat) 
	{
		this.id_cat = id_cat;
	}
	
	public String getName () 
	{
		return this.name;
	}
	
	public void setName (String name) 
	{
		this.name = name;
	}
	
	@Override
	public String toString () 
	{
		return id_cat + "\t" + name;
	}
}
