package it.contrader.dto;

public class OsTypeDTO {

	private int id;
	private String name;
	private String comm;
	
	public OsTypeDTO () { }

	public OsTypeDTO(int id, String name, String comm) {
		this.id = id;
		this.name = name;
		this.comm = comm;
	}

	public OsTypeDTO(String name, String comm) {
		this.name = name;
		this.comm = comm;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCommand() {
		return this.comm;
	}

	public void setCommand(String comm) {
		this.comm = comm;
	}

	@Override
	public String toString() {
		return "OsTypeDTO [id=" + id + ", name=" + name + ", comm=" + comm + "]";
	}	
	
}
