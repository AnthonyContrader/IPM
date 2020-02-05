package it.contrader.model;


public class Packet {

	// Fields
	private int id_pack;

	private String name;
	
	private String description;

	// Constructors
	public Packet() {
		
	}

	// Half constructor
	public Packet (String newName, String newDescription) {
		this.name = newName;
	}

	// Full constructor
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

	// Transforms this packet to a string
	@Override
	public String toString() {
		return Integer.toString( this.getId_pack() ) + "\t" +
				this.getName() + "\t\t" +
				this.getDescription();
	}

	// Checks if two packets are equal
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Packet other = (Packet) obj;
		if (this.getId_pack() != other.getId_pack() )
			return false;
		if (this.getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!this.getName().equals(other.getName()))
			return false;
		if (this.getDescription() == null) {
			if (other.getDescription() != null)
				return false;
		} else if (!this.getDescription().equals(other.getDescription()))
			return false;
		return true;
	}
}
