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
	
	public boolean equals (Object obj) { 
		if (this==obj)
			return true;
		if(obj==null)
			return false;
		if (getClass()!=obj.getClass())
			return false;
		OsType osType = (OsType) obj;
		
		if (id_ostype != osType.id_ostype) 
			return false;
			
			if (name == null) {
				if (osType.name != null)
					return false;
			} else if (!name.equals(osType.name))
				return false;
			
		
		if (command == null) {
			if (osType.command != null) {
				return false;
			}else if (!command.equals(osType.command)) {
				return false;
			}
		}
		return true;	
	}
	
}
