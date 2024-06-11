package net.hr.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.hr.registration.model.Employee;

public class EmployeeDao {
	private static String jdbcURL="jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
	private static String jdbcUsername="root";
	private static String jdbcPassword="root";
	private static String jdbcDriver="com.mysql.cj.jdbc.Driver";

	private static String INSERT_EMPL_SQL = "insert into employee (firstName,lastName,username,password,address,contact)values(?,?,?,?,?,?);";
	private static String SELECT_USERS_BY_ID = "select id,first_name,address from employee where id=?";
	private static String SELECT_ALL_USERS = "select * from employee";
	private static String DELETE_USER_SQL = "delete from employee where id=?";
	private static String UPDATE_USER_SQL = "update employee set firstname=?,lastname=?,address=? where id=?";
	
	public EmployeeDao() {

	}
	protected static Connection getConnection() {
		Connection connection=null;
		
		try {
			Class.forName(jdbcDriver);
			connection=DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			System.out.println(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
		
		
	}
	
	
	public void insertEmployee(Employee employee) {
		Connection connection=getConnection();
		PreparedStatement psmt;
		try {
			psmt = connection.prepareStatement(INSERT_EMPL_SQL);
			
			psmt.setString(1, employee.getFirstName());
			psmt.setString(2, employee.getLastName());
			psmt.setString(3, employee.getUsername());
			psmt.setString(4, employee.getPassword());
			psmt.setString(5, employee.getAddress());
			psmt.setString(6, employee.getContact());
			System.out.println(psmt);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public Employee selectEmployee(int id) {
		Employee employee=null;
		
		
		try {
			Connection connection=getConnection();
			PreparedStatement psmt=connection.prepareStatement(SELECT_USERS_BY_ID);
			psmt.setInt(1, id);
			ResultSet rs=psmt.executeQuery();
			
			while(rs.next()) {
				String firstname = rs.getString("firstName");
				String lastname = rs.getString("lastName");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String address = rs.getString("address");
				String contact = rs.getString("contact");
				
				employee=new Employee(id,firstname,lastname,username,password,address,contact);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}
	
	
	
	
/*	public int registerEmployee(Employee employee) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "insert into employee (id,first_name,last_name,username,password,address,contact)values(?,?,?,?,?,?,?);";

		int result = 0;
		Class.forName("com.mysql.jdbc.Driver");

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useSSL=false",
					"root", "root");

			// step 2 create a statement using connection object
			PreparedStatement psmt = connection.prepareStatement(INSERT_USERS_SQL);
			psmt.setInt(1, 1);
			psmt.setString(2, employee.getFirstName());
			psmt.setString(3, employee.getLastName());
			psmt.setString(4, employee.getUsername());
			psmt.setString(5, employee.getPassword());
			psmt.setString(6, employee.getAddress());
			psmt.setString(7, employee.getContact());

			System.out.println(psmt);

			// Step3 Execute the query
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
*/
	public static  List<Employee> selectAllUser() {
		List<Employee> employee = new ArrayList<>();

		try {
			Connection connection =getConnection();
			PreparedStatement psmt = connection.prepareStatement(SELECT_ALL_USERS);

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String firstname = rs.getString("firstName");
				String lastname = rs.getString("lastName");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String address = rs.getString("address");
				String contact = rs.getString("contact");

				employee.add(new Employee(id,firstname,lastname,username,password,address,contact));
				// Employee(id,firstname,lastname,username,password,address,contact));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;

	}
	
	public boolean updateEmployee(Employee employee) {
		boolean rowUpdated = false ;
		
		try {
			Connection connection=getConnection();
			PreparedStatement psmt=connection.prepareStatement(UPDATE_USER_SQL);
			System.out.println("Updated Statement "+psmt);
			psmt.setString(1, employee.getFirstName());
			psmt.setString(2, employee.getLastName());
			psmt.setString(3, employee.getAddress());
			psmt.setInt(4, employee.getId());
			
			rowUpdated =psmt.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowUpdated;
		
	}
	
	public boolean deleteEmployee(int id) {
		boolean rowDeleted = false;
		
		try {
			Connection connection=getConnection();
			PreparedStatement psmt=connection.prepareStatement(DELETE_USER_SQL);
			psmt.setInt(1, id);
			rowDeleted=psmt.executeUpdate() >0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowDeleted;
		
	}

	

}
