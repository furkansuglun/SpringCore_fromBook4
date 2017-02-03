package _20.Spring.JDBC.CRUD.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import _20.Spring.JDBC.CRUD.model.Employee;




public class EmployeeDAOImpl implements EmployeeDAO{

	private DataSource dataSource;
	//-----------------------
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	//------------------------
	
	@Override
	public void createEmployee1(Employee employee) {
		
		String sql = "insert into employee (name,surname,experience) values (?,?,?)";
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try {
			con = dataSource.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getSurname());
			preparedStatement.setInt(3, employee.getExperience());
			
			int status = preparedStatement.executeUpdate();
			if(status!=0) {
				System.out.println("ID deðeri " + employee.getId() + " olan kayýt eklendi!");
			}else {
				System.err.println("ID deðeri " + employee.getId() + " olan kayýt eklenemedi!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(con!=null && preparedStatement!=null) {
				try {
					preparedStatement.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}

	@Override
	public void createEmployee2(Employee employee) {
		String sql = "insert into employee (name,surname,experience) values (?,?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] {employee.getName(),employee.getSurname(),employee.getExperience()};
		
		int status = jdbcTemplate.update(sql ,args);
		
		if(status!=0) {
			System.out.println("ID deðeri " + employee.getId() + " olan kayýt eklendi!");
		}else {
			System.err.println("ID deðeri " + employee.getId() + " olan kayýt eklenemedi!");
		}
	}

	@Override
	public Employee readEmployee1(int id) {
		String sql = "select * from employee where id = ? ";
		
		Employee employee = null;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			con = dataSource.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				employee = new Employee();
				employee.setName(resultSet.getString("name"));
				employee.setSurname(resultSet.getString("surname"));
				employee.setExperience(resultSet.getInt("experience"));
				
				System.out.println("ID : " + resultSet.getInt("id") +
						"\n Name : " + resultSet.getString("name") + 
						"\nSurname : " + resultSet.getString("surname") + 
						"\nExperience : " + resultSet.getInt("experience"));
			}else {
				System.err.println("ID deðeri " + id + " olan kayýt bulunamadý:");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(con!=null) {
				
				try {
					resultSet.close();
					preparedStatement.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		
		return employee;
	}

	@Override
	public Employee readEmployee2(int id) {
		String sql = "select * from employee where id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		try {
			//RowMapper ý tekrar kullanmak için anonymous sýnýf kullandýk.
			Employee employee = (Employee) jdbcTemplate.queryForObject(sql, new Object[] {id} , new RowMapper<Employee>() {

				@Override
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
					Employee employee = new Employee();
					employee.setId(rs.getInt("id"));
					employee.setName(rs.getString("name"));
					employee.setSurname(rs.getString("surname"));
					employee.setExperience(rs.getInt("experience"));
						
					System.out.println("ID : " + rs.getInt("id") +
							"\n Name : " + rs.getString("name") + 
							"\nSurname : " + rs.getString("surname") + 
							"\nExperience : " + rs.getInt("experience"));
					
					
					return employee;
				}
			});
		} catch(Exception e) {
			System.out.println("null\n");
			return null;
		}
		return null;
	}

	@Override
	public void updateEmployee1(Employee employee, int id) {
		String sql = "update employee set name = ? , surname = ? , experience = ? where id = ?";
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try {
			con = dataSource.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getSurname());
			preparedStatement.setInt(3, employee.getExperience());
			preparedStatement.setInt(4, id);
			
			int status = preparedStatement.executeUpdate();
			if(status!=0) {
				System.out.println("ID deðeri " + id + " olan kayýt güncellendi!");
			}else {
				System.err.println("ID deðeri " + id + " olan kayýt güncellenemedi!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(con!=null && preparedStatement!=null) {
				try {
					preparedStatement.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void updateEmployee2(Employee employee, int id) {
		String sql = "update employee set name = ? , surname = ? , experience = ? where id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object[] args = new Object[] {employee.getName() , employee.getSurname(),employee.getExperience(),id};
		
		int status = jdbcTemplate.update(sql,args);
		if(status!=0) {
			System.out.println("ID deðeri " + id + " olan kayýt güncellendi!");
		}else {
			System.err.println("ID deðeri " + id + " olan kayýt güncelslenemedi!");
		}
	}

	@Override
	public void deleteEmployee1(int id) {
		
		String sql = "delete from employee where id = ?";
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			int status = ps.executeUpdate();
			if(status!=0) {
				System.out.println("ID deðeri " + id + " olan kayýt silidi!");
			}else {
				System.err.println("ID deðeri " + id + " olan kayýt silinemedi!");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(con!=null && ps!=null) {
				try {
					ps.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void deleteEmployee2(int id) {
		
		String sql = "delete from employee where id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object[] args = new Object[] {id};
		
		int status = jdbcTemplate.update(sql,args);
		if(status!=0) {
			System.out.println("ID deðeri " + id + " olan kayýt silindi!");
		}else {
			System.err.println("ID deðeri " + id + " olan kayýt silinemedi!");
		}
		
	}

	@Override
	public List<Employee> listAllEmployees1() {
		
		String sql = "select * from employee";
		List<Employee> employees = new ArrayList<Employee>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs  =  null;
		
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setSurname(rs.getString("surname"));
				employee.setExperience(rs.getShort("experience"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(con!=null) {
				try {
					rs.close();
					ps.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		}
		
		return employees;
		
	}

	@Override
	public List<Employee> listAllEmployees2() {
		String sql = "select * from employee";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Employee> employees = new ArrayList<Employee>();
		
		List<Map<String,Object>> empLists = jdbcTemplate.queryForList(sql);
		
		for(Map<String, Object> empList : empLists) {
			Employee employee = new Employee();
			employee.setId((int) empList.get("id"));
			employee.setName((String) empList.get("name"));
			employee.setSurname((String) empList.get("surnanme"));
			employee.setExperience( (int) empList.get("experience"));
		}
	
		return employees;
		
	}

	

}
