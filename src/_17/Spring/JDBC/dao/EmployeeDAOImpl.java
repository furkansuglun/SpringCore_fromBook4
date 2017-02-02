package _17.Spring.JDBC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import _17.Spring.JDBC.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	
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
		
		Connection con = null;
		
		
		try {
			con = dataSource.getConnection();
			PreparedStatement preparedStatement;
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getSurname());
			preparedStatement.setInt(3, employee.getExperience());
			
			preparedStatement.executeUpdate(); //executeUpdate düzenleme yapamk için kullanýlýr.
			preparedStatement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}

	@Override
	public Employee searchId(int id) {
		sql = "select * from employee where id = ?";
		
		try {
			con = dataSource.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			
			Employee employee = null;
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				employee = new Employee(resultSet.getInt("id"),
										resultSet.getString("name"),
										resultSet.getString("surname"),
										resultSet.getInt("experience"));
			}
			
			resultSet.close();
			preparedStatement.close();
			
			return employee;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					
				}
			}
		}
		
		
		
	}

	@Override
	public Employee searchName(String name) {
		
		String sql = "select * from employee where name = ?";
		
		try {
			con = dataSource.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, name);
			
			Employee employee = null;
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				employee = new Employee(resultSet.getInt("id") ,
										resultSet.getString("name"),
										resultSet.getString("surname"),
										resultSet.getInt("experience"));
			}
			
			resultSet.close();
			preparedStatement.close();
			
			return employee;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					
				}
			}
		}
		
		
		
		
	}

	@Override
	public Employee searchSurname(String surname) {

		String sql = "select * from employee where surname = ?";
		
		try {
			con = dataSource.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,surname);
			
			Employee employee = null;
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				employee = new Employee(resultSet.getInt("id") ,
										resultSet.getString("name"),
										resultSet.getString("surname"),
										resultSet.getInt("experience"));
			}
			
			resultSet.close();
			preparedStatement.close();
			
			return employee;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					
				}
			}
		}
		
		
	}

	@Override
	public Employee searchExperience(int experience) {

		String sql = "select * from employee where experience = ?";
		
		try {
			con = dataSource.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, experience);
			
			Employee employee = null;
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				employee = new Employee(resultSet.getInt("id") ,
										resultSet.getString("name"),
										resultSet.getString("surname"),
										resultSet.getInt("experience"));
			}
			
			resultSet.close();
			preparedStatement.close();
			
			return employee;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					
				}
			}
		}
		
		
	}

}
