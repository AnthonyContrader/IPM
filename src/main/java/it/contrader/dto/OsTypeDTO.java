package it.contrader.dto;

public class OsTypeDTO {
	private int id_ostype;
	private String name;
	private String command;
	
	public OsTypeDTO () { }
	
	public OsTypeDTO(String name, String command) {
		super();
		this.name = name;
		this.command = command;
	}

	public OsTypeDTO(int id_ostype, String name, String command) {
		super();
		this.id_ostype = id_ostype;
		this.name = name;
		this.command = command;
	}

	public int getId_ostype() {
		return id_ostype;
	}

	public void setId_ostype(int id_ostype) {
		this.id_ostype = id_ostype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	@Override
	public String toString() {
		return "OsTypeDTO [id_ostype=" + id_ostype + ", name=" + name + ", command=" + command + "]";
	}
	
}
