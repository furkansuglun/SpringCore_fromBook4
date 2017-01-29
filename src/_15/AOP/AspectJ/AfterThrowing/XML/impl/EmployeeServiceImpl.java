package _15.AOP.AspectJ.AfterThrowing.XML.impl;

import _15.AOP.AspectJ.AfterThrowing.XML.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService  {

	private String name , surname;
	private int experience;
	//---------------------
	
	@Override
	public void checkNameSurname() {
		System.out.println("IEmployeeService#checkNameSurname");
		if(name.length() < 2 || surname.length() < 2) {
			throw new IllegalArgumentException();
		}
	}

	/*@Override
	public S sayHi(String message) {
		System.out.println("IEmployeeService#sayHi");
		System.out.println("Message is : " + message);
	}*/
	@Override
	public String sayHi(String message) {
		System.out.println("IEmployeeService#sayHi");
		System.out.println("Message is : " + message);
		return message;
	}

	@Override
	public void getEmployeeInfo() {
		System.out.println("IEmployeeService#getEmployeeInfo");
		System.out.println("FullName : " + name + " " + surname);
		System.out.println("Experience : " + experience);
	}
	
	//------------------------------
	
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

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	
	
	

}
