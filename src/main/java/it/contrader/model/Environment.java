package it.contrader.model;

public class Environment {
	// FIELDS
	private int id_env;
	private String name;
	private String description;
	
	// Foreign key
	private String packetKey;
	private String categoryKey;
	
	public Environment(int id_env, String name, String description, String packetKey, String categoryKey) {
		super();
		this.id_env = id_env;
		this.name = name;
		this.description = description;
		this.packetKey = packetKey;
		this.categoryKey = categoryKey;
	}

	public Environment(String name, String description, String packetKey, String categoryKey) {
		super();
		this.name = name;
		this.description = description;
		this.packetKey = packetKey;
		this.categoryKey = categoryKey;
	}

	public Environment() {
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

	public String getPacketKey() {
		return packetKey;
	}
	
	public void setCategoryKey(String categoryKey) {
		this.categoryKey = categoryKey;
	}
	
	public String getCategoryKey() {
		return categoryKey;
	}
	
	@Override
	public String toString() {
		return "Packet [id_env=" + id_env + ", name=" + name + ", description=" + description + ", packetKey=" + packetKey
				+ ", categoryKey=" + categoryKey + ", getId_env()=" + getId_env() + ", getName()=" + getName() + ", getDescription()="
				+ getDescription() + ", getpacketKey()=" + getPacketKey() + ", getCategoryKey()=" + getCategoryKey() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Environment other = (Environment) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id_env != other.id_env)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (packetKey == null) {
			if (other.packetKey != null)
				return false;
		} else if (!packetKey.equals(other.packetKey))
			return false;
		if (categoryKey == null) {
			if (other.categoryKey != null)
				return false;
		} else if (!categoryKey.equals(other.categoryKey))
			return false;
		return true;
	}

	
}