package model.beans;

import java.io.Serializable;

public class Purchaser implements Serializable {
	
	private static final long serialVersionUID = 551123064919897L;
	
	private int id;
	private String firstName;
	private String lastName;
	private String adress;
	private int zipCode;
	private String city;
	private int phoneNumber;
	private String email;
	
	
	public Purchaser(){
		
	}

	public Purchaser(String firstName, String lastName, String adress,
			int zipCode, String city, int phoneNumber,String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.zipCode = zipCode;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public Purchaser(int id,String firstName, String lastName, String adress,
			int zipCode, String city, int phoneNumber,String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.zipCode = zipCode;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public int getZipCode() {
		return zipCode;
	}


	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
