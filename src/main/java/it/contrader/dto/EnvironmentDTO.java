package it.contrader.dto;

public class EnvironmentDTO {

	private int id_env;
	private String name;
	private String description;
	
	public EnvironmentDTO(int id_env, String name, String description) {
		this.id_env = id_env;
		this.name = name;
		this.description = description;
	}
	
	public EnvironmentDTO() {

	}
	
	public EnvironmentDTO(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id_env;
	}

	public void setId(int id_env) {
		this.id_env = id_env;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return id_env + "/t" + name + "/t/t" + description;
	}
	
	
}