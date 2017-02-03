package _19.Spring.JDBC.BatchUpdate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import _19.Spring.JDBC.BatchUpdate.model.Employee;



public class EmployeeDAOImpl implements EmployeeDAO{

	
	private JdbcTemplate jdbcTemplate; //ileti�im kuramam�z� sa�lar.
	private Connection con = null;
	private String sql = null;
	private DataSource dataSource;
	//--------------------------------
	//dataSource u bean olarak kullanabilmek i�in set metodunu olusturduk.
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
		
		//queryForObject => arama i�lemi i�in kullan�lan metod
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

	@Override
	public void dataEntryBatch1(final List<Employee> employees) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		sql = "insert into employee(name, surname, experience) values (?,?,?)";
		jdbcTemplate.batchUpdate(sql,new BatchPreparedStatementSetter() {
			
			@Override                                   // * @param i index of the statement we're issuing in the batch, starting from 0
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				
				Employee employee = employees.get(i);
				ps.setString(1, employee.getName());
				ps.setString(2, employee.getSurname());
				ps.setInt(3, employee.getExperience());
				
			}
			
			@Override
			public int getBatchSize() {
				
				return employees.size();
			}
		});
	}

	@Override
	public void dataEntryBatch2(final String sql) {
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.batchUpdate(new String[] {sql});
		
	}

}
