package it.contrader.model;

public class OsType {

	private int id;
	private String name;
	private String comm;
	
	public OsType() {}

	public OsType(String name, String comm) {
		this.name = name;
		this.comm = comm;
	}

	public OsType(int id, String name, String comm) {
		this.id = id;
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
		return "OsType [id=" + id + ", name=" + name + ", comm=" + comm + "]";
	}
	
	public boolean equals (Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OsType other = (OsType) obj;
		if (id!=other.id)
			return false;
		if (name==null) {
			if(other.name != null)
			return false;
		} else if (!name.equals(other.name))
			return false;
		if (comm==null) {
			if(other.comm != null) 
			return false;
		} else if(!comm.equals(other.comm))
			return false;
		return true;	
	}
}
