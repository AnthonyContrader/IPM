package it.contrader.model;

public class Packet {
	// FIELDS
	private int id_pack;
	private String name;
	private String description;
	
	// Foreign key
	private String osKey;
	
	public Packet(int id_pack, String name, String description, String osKey) {
		super();
		this.id_pack = id_pack;
		this.name = name;
		this.description = description;
		this.osKey = osKey;
	}

	public Packet(String name, String description, String osKey) {
		super();
		this.name = name;
		this.description = description;
		this.osKey = osKey;
	}

	public Packet() {
		super();
	}

	public int getId_pack() {
		return id_pack;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getOsKey() {
		return osKey;
	}

	public void setId_pack(int id_pack) {
		this.id_pack = id_pack;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setOsKey(String osKey) {
		this.osKey = osKey;
	}

	@Override
	public String toString() {
		return "Packet [id_pack=" + id_pack + ", name=" + name + ", description=" + description + ", osKey=" + osKey
				+ ", getId_pack()=" + getId_pack() + ", getName()=" + getName() + ", getDescription()="
				+ getDescription() + ", getOsKey()=" + getOsKey() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id_pack;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((osKey == null) ? 0 : osKey.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Packet other = (Packet) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id_pack != other.id_pack)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (osKey == null) {
			if (other.osKey != null)
				return false;
		} else if (!osKey.equals(other.osKey))
			return false;
		return true;
	}

	
}