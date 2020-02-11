package it.contrader.dto;


public class PacketDTO {
	// FIELDS
	private int id_pack;
	private String name;
	private String description;
	
	// Empty constructor
	public PacketDTO() {}
	
	// Half constructor
	public PacketDTO(String newName, String newDescription) {
		this.name = newName;
		this.description = newDescription;
	}
	
	// Full constructor
	public PacketDTO(int newId, String newName, String newDescription) {
		this.id_pack = newId;
		this.name = newName;
		this.description = newDescription;
	}
	
	// Getters
	public int getId_pack() { return this.id_pack; }
	public String getName() { return this.name; }
	public String getDescription() { return this.description; }
	
	// Setters
	public void setId_pack(int newId) { this.id_pack = newId; }
	public void setName(String newName) { this.name = newName; }
	public void setDescription(String newDescription) { this.description = newDescription; }
	
	// ToString() method
	@Override
	public String toString() {
		return Integer.toString( this.id_pack ) + "\t" +
				this.name + "\t\t" +
				this.description;
	}
}
