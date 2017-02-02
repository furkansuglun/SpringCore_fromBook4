package _17.Spring.JDBC.dao;

import _17.Spring.JDBC.model.Employee;

public interface EmployeeDAO {

	public void addEmployee(Employee employee);
	
	public Employee searchId(int id);
	public Employee searchName(String name);
	public Employee searchSurname(String surname);
	public Employee searchExperience(int experience);
	
}
