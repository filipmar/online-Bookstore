package model.beans;

import java.io.Serializable;

import model.dao.UserDAO;

public class User implements Serializable {
	
	private static final long serialVersionUID = 559223064919897L;
	
	private UserDAO daoObject = null;
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private String type;
	private String status;
	
	public User(){
		super();
	}
	
	public User(String firstName, String lastName,
			String username, String password, String email,String type,String status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.type = type;
		this.status = status;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public UserDAO getDaoObject() {
		return daoObject;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
