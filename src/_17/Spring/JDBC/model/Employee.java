package _17.Spring.JDBC.model;

public class Employee {

	private String name , surname;
	private int id,experience;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String surname, int experience) {
		super();
		this.name = name;
		this.surname = surname;
		this.experience = experience;
	}

	public Employee(int id, String name, String surname, int experience) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.experience = experience;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "ID : " + getId()  +
				"\n Name : " + getName() +
				"\n Surname : " + getSurname() +
				"\nExperience : " + getExperience() + " year.";
	}
	
	
	
	
}
