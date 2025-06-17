package prg;

import java.io.Serializable;

public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	
	public Student (int id, String name){
		this.setId(id);
		this.setName(name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append("ID   : " + getId());
		out.append("\nName : " + getName());
		return out.toString();
	}
	
	
}
