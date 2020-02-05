package it.contrader.model;


public class Packet {

	// Fields
	private int id_pack;

	private String name;
	
	private String description;

	// Constructors
	public Packet() {
		
	}

	public Packet (String newName, String newDescription) {
		this.name = newName;
	}

	public Packet (int newId, String newName, String newDescription) {
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

	//Trasforma un pacchetto in una stringa
	@Override
	public String toString() {
		return Integer.toString( this.getId_pack() ) + "\t" +
				this.getName() + "\t\t" +
				this.getDescription();
	}

	//TODO: equals
}
