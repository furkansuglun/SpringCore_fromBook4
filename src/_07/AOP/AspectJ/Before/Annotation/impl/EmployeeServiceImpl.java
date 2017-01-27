package _07.AOP.AspectJ.Before.Annotation.impl;

import _07.AOP.AspectJ.Before.Annotation.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {

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

	@Override
	public void sayHi(String message) {
		System.out.println("IEmployeeService#sayHi");
		System.out.println("Message is : " + message);
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
