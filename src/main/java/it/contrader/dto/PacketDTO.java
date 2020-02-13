package it.contrader.dto;

public class PacketDTO {
	// FIELDS
	private int id_pack;
	private String name;
	private String description;
	
	// Foreign key
	private String osKey;
	
	// Empty constructor
	public PacketDTO() {}
	
	

	public PacketDTO(int id_pack, String name, String description, String osKey) {
		super();
		this.id_pack = id_pack;
		this.name = name;
		this.description = description;
		this.osKey = osKey;
	}



	public PacketDTO(String name, String description, String osKey) {
		super();
		this.name = name;
		this.description = description;
		this.osKey = osKey;
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
		return "PacketDTO [id_pack=" + id_pack + ", name=" + name + ", description=" + description + ", osKey=" + osKey
				+ "]";
	}
	
	// Half constructor
	
	
}