package it.contrader.dto;

public class EnvironmentDTO {
	
	private int id_env;
	private String name;
	private String description;
	
	// Construtors definition, empty constructor, with ID constructr and without ID constructor
	
	public EnvironmentDTO () {
		 
	}
	
	public EnvironmentDTO (String name, String description) {
		this.name = name;
		this.description = description;
		
	}
	
	public EnvironmentDTO (int id_env, String name, String description) {
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
}