package _19.Spring.JDBC.BatchUpdate.dao;

import java.util.List;

import _19.Spring.JDBC.BatchUpdate.model.Employee;


public interface EmployeeDAO {

	public void addEmployee(Employee employee);
	
	public Employee searchId(int id);
	public Employee searchName(String name);
	public Employee searchSurname(String surname);
	public Employee searchExperience(int experience);
	
	public List<Employee> searchAll();
	public String getDataById(int id);
	
	public void dataEntryBatch1(final List<Employee> employees);
	public void dataEntryBatch2(final String sql);
}
