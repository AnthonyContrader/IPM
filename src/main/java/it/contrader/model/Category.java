package it.contrader.model;

public class Category
{
	/* VARIABLES */
	private int id_cat;
	private String name;
	
	/* CONSTRUCTORS */
	public Category ()
	{
	}
	
	public Category (String name) 
	{
		this.name = name;
	}
	
	public Category (int id_cat, String name) 
	{
		this.id_cat = id_cat;
		this.name = name;
	}
	
	/* GETTER AND SETTER METHODS */
	public int getIdCat() 
	{
		return this.id_cat;
	}
	
	public void setIdCat(int id_cat) 
	{
		this.id_cat = id_cat;
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	/* TRANSFORMATION OF STRING TO OBJECT */
	public String toString() 
	{
		return id_cat + "\t" + name;
	}
	
	/* EQUALS METHOD */
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id_cat != other.id_cat)
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		return true;
	}
}