package it.contrader.model;

public class Packet {
	// FIELDS
	private int id_pack;
	private String name;
	private String description;
	
	// Empty constructor
	public Packet() {}
	
	// Half constructor
	public Packet(String newName, String newDescription) {
		this.name = newName;
		this.description = newDescription;
	}
	
	// Full constructor
	public Packet(int newId, String newName, String newDescription) {
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
	
	// equals override
	@Override
	public boolean equals(Object obj) {
		if ( this == obj )
			return true;
		
		if ( this.getClass() != obj.getClass() || obj == null)
			return false;
		
		Packet otherPacket = (Packet) obj;
		
		if ( this.getId_pack() != otherPacket.getId_pack() )
			return false;
		
		if ( this.getName() == null || otherPacket.getName() == null )
				return false;
		
		if ( this.getDescription() == null || otherPacket.getDescription() == null)
				return false;
		
		if ( !this.getName().equals( otherPacket.getName() ) )
				return false;
		
		if ( !this.getDescription().equals( otherPacket.getDescription() ) )
			return false;
		
		return true;
	}
}