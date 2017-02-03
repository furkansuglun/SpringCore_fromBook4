package _20.Spring.JDBC.CRUD.dao;

import java.util.List;

import _20.Spring.JDBC.CRUD.model.Employee;

public interface EmployeeDAO {

	//her metottan iki tane var . 1 olanlar normal JDBC 2 olanlar Spring JDBCTemplate
	
	public void createEmployee1(Employee employee);
	public void createEmployee2(Employee employee);
	
	public Employee readEmployee1(int id);
	public Employee readEmployee2(int id);
	
	public void updateEmployee1(Employee employee , int id);
	public void updateEmployee2(Employee employee , int id);
	
	public void deleteEmployee1(int id);
	public void deleteEmployee2(int id);
	
	public List<Employee> listAllEmployees1();
	public List<Employee> listAllEmployees2();
	
}
