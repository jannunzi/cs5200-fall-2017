package lecture.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lecture.jdbc.model.Website;

public class WebsiteDao extends BaseDao {
	
	final String CREATE_WEBSITE = "INSERT INTO Website (name, description) VALUES (?, ?)";
	final String FIND_ALL_WEBSITES = "SELECT * FROM Website";
	final String FIND_WEBSITE_ID = "SELECT * FROM Website WHERE id=?";
	final String UPDATE_WEBSITE = "UPDATE Website SET name=?, description=? WHERE id=?";
	final String DELETE_WEBSITE = "DELETE FROM Website WHERE id=?";
	
	public Website findWebsiteById(int websiteId) {
		ArrayList<Website> websites = new ArrayList<Website>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(FIND_WEBSITE_ID);
			statement.setInt(1, websiteId);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String description = result.getString("description");
				Website website = new Website(id, name, description);
				websites.add(website);
			}
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return websites.get(0);
	}
	
	public int deleteWebsite(int websiteId) {
		int result = -1;
		
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement statement = connection.prepareStatement(DELETE_WEBSITE);
			statement.setInt(1, websiteId);
			result = statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int updateWebsite(int websiteId, Website website) {
		int result = -1;
		
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(UPDATE_WEBSITE);
			statement.setString(1, website.getName());
			statement.setString(2, website.getDescription());
			statement.setInt(3, websiteId);
			result = statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<Website> findAllWebsites() {
		ArrayList<Website> websites = new ArrayList<Website>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(FIND_ALL_WEBSITES);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String description = result.getString("description");
				Website website = new Website(id, name, description);
				websites.add(website);
			}
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return websites;
	}
	
	public int createWebsite(Website website) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(CREATE_WEBSITE);
			statement.setString(1, website.getName());
			statement.setString(2, website.getDescription());
			result = statement.executeUpdate();
			statement.close();
			connection.close();
			return result;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	private static WebsiteDao instance = null; 

	private WebsiteDao() {}
	
	public static WebsiteDao getInstance() {
		if(instance == null) {
			instance = new WebsiteDao();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		WebsiteDao wdao = WebsiteDao.getInstance();
//		Website twitter = new Website("twitter", "Connecting people");
//		wdao.createWebsite(twitter);
//		Website newTwitter = new Website("Twitter", "Our source of truthiness");
//		wdao.updateWebsite(2, newTwitter);
		ArrayList<Website> websites = wdao.findAllWebsites();
		System.out.println(websites);
	}

}
