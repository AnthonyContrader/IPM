package it.contrader.model;

public class OsType {
	
	private int id_ostype;
	private String name;
	private String command;
	
	public OsType() { }
	
	public OsType(String name, String command) {
		super();
		this.name = name;
		this.command = command;
	}

	public OsType(int id, String name, String command) {
		super();
		this.id_ostype = id;
		this.name = name;
		this.command = command;
	}

	public int getId() {
		return id_ostype;
	}

	public void setId(int id) {
		this.id_ostype = id;
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
		return "OsType [id=" + id_ostype + ", name=" + name + ", command=" + command + "]";
	}
	
	/**public boolean equals (Object obj) { }
	*
}
