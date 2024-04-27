package servlet_http;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerCrud {
		
		public Connection getConnection()throws Exception
		{
			String className="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/servletdb";
			String user="root";
			String pass="root";
			
			Class.forName(className);
			Connection connection=DriverManager.getConnection(url, user, pass);
			return connection;
		}
		public int singUp(Customer customer)throws Exception
		{
			Connection connection=getConnection();
			String sql="INSERT INTO CUSTOMER(ID,NAME,PHONE,EMAIL,PASSWORD) VALUES(?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,customer.getId());
			preparedStatement.setString(2,customer .getName());
			preparedStatement.setLong(3,customer .getPhone());
			preparedStatement.setString(4,customer.getEmail());
			preparedStatement.setString(5,customer .getPassword());
			
			int result=preparedStatement.executeUpdate();
			connection.close();
			return result;
		} 
		public String getPassword(String email)throws Exception
		{
			Connection  connection=getConnection();
			String pass="SELECT PASSWORD FROM CUSTOMER WHERE EMAIL=?";
			PreparedStatement preparedStatement=connection.prepareStatement(pass);
			preparedStatement.setString(1, email);
			ResultSet set=preparedStatement.executeQuery();
			String password=null;
			while (set.next()) {
				password=set.getString("password");
			}
			connection.close();
			return password;		
		}
	}
