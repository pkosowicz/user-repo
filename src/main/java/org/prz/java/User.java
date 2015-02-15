package main.java.org.prz.java;

public class User {	
	
	private String name;
	private String surname;	
	private Integer id;	
	
	
	public User(Integer id,String name,String surname)
	{
		this.id=id;
		this.name=name;
		this.surname=surname;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
