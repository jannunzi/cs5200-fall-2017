package lecture.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/lectures";
	  static final String USERNAME = "cs5200";
	  static final String PASSWORD = "cs5200";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	      Class.forName("com.mysql.jdbc.Driver");
	      Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	      String sql = "SELECT * FROM developer WHERE username=?";
//	      Statement statement = connection.createStatement();
	      PreparedStatement statement = connection.prepareStatement(sql);
	      statement.setString(1, "alice");
	      ResultSet rs = statement.executeQuery();
	      while(rs.next()) {
	    	  	int id = rs.getInt("id");
	    	  	String username = rs.getString("username");
	    	  	String password = rs.getString("password");
	    	  	String first = rs.getString("firstName");
	    	  	String last = rs.getString("lastName");
	    	  	System.out.println(id + "\t" + username + "\t" + first);
	      }
	      rs.close();
	      statement.close();
	      connection.close();
	}
}
