package it.contrader.model;

public class Environment {
	
	private int id_env;
	private String name;
	private String description;
	
	// Construtors definition, empty constructor, with ID constructr and without ID constructor
	
	public Environment () {
		 
	}
	
	public Environment (String name, String description) {
		this.name = name;
		this.description = description;
		
	}
	
	public Environment (int id_env, String name, String description) {
		this.id_env = id_env;
		this.name = name;
		this.description = description;	
	}
	
	// Setter and getter method definition
	
	public int getId_env () {
		return this.id_env;
	}
	
	public void setId_env (int id_env) {
		this.id_env = id_env;
	}
	
	public String getName () {
		return this.name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getDescription () {
		return this.description;
	}
	
	public void setDescription (String description) {
		this.description = description;
	}
	
	// Metod to transform in String all the values
	
	@Override
	public String toString() {
		return id_env + "/t" + name + "/t/t" + description;
	}
	
	
	// Compare method between various objects
	
	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Environment other = (Environment) obj;
		if (id_env != other.id_env)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}*/
	
}