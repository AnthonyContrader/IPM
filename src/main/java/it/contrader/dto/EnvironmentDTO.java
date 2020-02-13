package it.contrader.dto;

public class EnvironmentDTO {
	// FIELDS
	private int id_env;
	private String name;
	private String description;
	
	// Foreign key
	private String packetKey;
	
	public EnvironmentDTO(int id_env, String name, String description, String packetKey) {
		super();
		this.id_env = id_env;
		this.name = name;
		this.description = description;
		this.packetKey = packetKey;
	}

	public EnvironmentDTO(String name, String description, String packetKey) {
		super();
		this.name = name;
		this.description = description;
		this.packetKey = packetKey;
	}

	public EnvironmentDTO() {
		super();
	}

	public int getId_env() {
		return id_env;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getPacketKey() {
		return packetKey;
	}

	public void setId_env(int id_env) {
		this.id_env = id_env;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPacketKey(String packetKey) {
		this.packetKey = packetKey;
	}

	@Override
	public String toString() {
		return "Packet [id_env=" + id_env + ", name=" + name + ", description=" + description + ", packetKey=" + packetKey
				+ ", getId_env()=" + getId_env() + ", getName()=" + getName() + ", getDescription()="
				+ getDescription() + ", getpacketKey()=" + getPacketKey() + ", toString()=" + super.toString() + "]";
	}

	
}