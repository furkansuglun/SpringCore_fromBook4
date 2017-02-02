package _18.Spring.JDBC.RowMapper.dao;

import java.util.List;

import _18.Spring.JDBC.RowMapper.model.Employee;

public interface EmployeeDAO {

	public void addEmployee(Employee employee);
	
	public Employee searchId(int id);
	public Employee searchName(String name);
	public Employee searchSurname(String surname);
	public Employee searchExperience(int experience);
	
	public List<Employee> searchAll();
	public String getDataById(int id);
	
}
