package com.ContactService;

public class Contact {
	
	//declares variables
	private String id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	// creates constructor for 
	public Contact(String id, String firstName, String lastName, String phoneNumber, String address) throws Exception {
		super();
		
		// parameters for id
		if ((id == null) || (id.trim().length() < 1) || (id.length() > 10)) {
			
			throw new Exception("Invalid ID!");
			
		}
		
		this.id = id;
		
		// uses setters to call each variable with proper parameters
		// done to look cleaner
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setAddress(address);
	}

	//getter for first name
	public String getFirstName() {
		return firstName;
	}

	// setter for first name with parameters
	public void setFirstName(String firstName) throws Exception {
		if ((firstName == null) || (firstName.trim().length() < 1) || (firstName.length() > 10)) {
			
			throw new Exception("Invalid first name!");
			
		}
		
		this.firstName = firstName;
	}

	// getter for last name
	public String getLastName() {
		return lastName;
	}

	// setter for last name with proper parameters
	public void setLastName(String lastName) throws Exception {
		if ((lastName == null) || (lastName.trim().length() < 1) || (lastName.length() > 10)) {
			
			throw new Exception("Invalid last name!");
		}
		
		this.lastName = lastName;
	}

	//getter for phone number
	public String getPhoneNumber() {
		return phoneNumber;
	}

	//setter for phone number with proper parameters
	public void setPhoneNumber(String phoneNumber) throws Exception {
		
		if ((phoneNumber == null) || (phoneNumber.length() != 10) || (phoneNumber.matches(".*\\D+.*"))) {
			
			throw new Exception("Invalid phone number!");
			
		}
		
		this.phoneNumber = phoneNumber;
	}

	// getter for address
	public String getAddress() {
		return address;
	}

	// setter for address with proper parameters
	public void setAddress(String address) throws Exception {
		
		if ((address == null) || (address.trim().length() < 1) || (address.length() > 30)) {
			
			throw new Exception("Invalid address!");
			
		}
		
		
		this.address = address;
	}

	// getter for id
	public String getId() {
		return id;
	}
	
	
	
}
