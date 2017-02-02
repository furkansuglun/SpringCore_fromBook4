package _18.Spring.JDBC.RowMapper.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import _18.Spring.JDBC.RowMapper.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{

	
	private JdbcTemplate jdbcTemplate; //iletiþim kuramamýzý saðlar.
	private Connection con = null;
	private String sql = null;
	private DataSource dataSource;
	//--------------------------------
	//dataSource u bean olarak kullanabilmek için set metodunu olusturduk.
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	//---------------------------------
	
	@Override
	public void addEmployee(Employee employee) {
		
		sql = "insert into employee(name,surname,experience) values (?,?,?)";
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(sql , new Object[]{
				employee.getName(),
				employee.getSurname(),
				employee.getExperience()
		});
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Employee searchId(int id) {
		
		sql = "select * from employee where id = ?";
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		//queryForObject => arama iþlemi için kullanýlan metod
		Employee employee = (Employee) jdbcTemplate.queryForObject(sql,
				new Object[] {id}, new BeanPropertyRowMapper(Employee.class));
		
		return employee;
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Employee searchName(String name) {
		sql = "select * from employee where name = ?";
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		Employee employee = (Employee) jdbcTemplate.queryForObject(sql,
				new Object[] {name}, new BeanPropertyRowMapper(Employee.class));
		
		return employee;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Employee searchSurname(String surname) {

		sql = "select * from employee where surname = ?";
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		Employee employee = (Employee) jdbcTemplate.queryForObject(sql,
				new Object[] {surname}, new BeanPropertyRowMapper(Employee.class));
		
		return employee;
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Employee searchExperience(int experience) {

		sql = "select * from employee where experience = ?";
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		Employee employee = (Employee) jdbcTemplate.queryForObject(sql,
				new Object[] {experience}, new BeanPropertyRowMapper(Employee.class));
		
		return employee;
		
	}

	@SuppressWarnings("rawtypes") 
	@Override
	public List<Employee> searchAll() {
		
		sql = "select * from employee";
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		List<Employee> employees = new ArrayList<Employee>();
		
		List<Map<String , Object>> rows = jdbcTemplate.queryForList(sql);
		
		for(Map row : rows) {
			Employee employee = new Employee();
			employee.setId(Integer.parseInt(String.valueOf(row.get("id"))));
			employee.setName((String) row.get("name") );
			employee.setSurname((String) row.get("surname"));
			employee.setExperience(Integer.parseInt(String.valueOf(row.get("experience"))));
			
			employees.add(employee);
		}
		
		return employees;
	}

	@Override
	public String getDataById(int id) {
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		sql = "select name from employee where id = ?";
		
		String result = (String) jdbcTemplate.queryForObject(sql, new Object[] {id} , String.class);
		
		return result;
	}

}
