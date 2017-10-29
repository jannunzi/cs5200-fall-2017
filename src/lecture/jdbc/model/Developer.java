package lecture.jdbc.model;

import java.util.ArrayList;

public class Developer {
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private ArrayList<Website> websites;
	public Developer(String username, String password, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Developer() {
		super();
	}
	public Developer(int id, String username, String password, String firstName, String lastName,
			ArrayList<Website> websites) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.websites = websites;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public ArrayList<Website> getWebsites() {
		return websites;
	}
	public void setWebsites(ArrayList<Website> websites) {
		this.websites = websites;
	}
}
