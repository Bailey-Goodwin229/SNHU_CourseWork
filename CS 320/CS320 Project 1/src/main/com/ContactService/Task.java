package com.ContactService;

public class Task {

	// Declare variables
	private String id;
	private String name;
	private String description;
	
	// Creates constructor for Task
	public Task(String id, String name, String description) throws Exception {
		
		super();
		
		// parameters for id
		if ((id == null) || (id.trim().length() < 1) || (id.length() > 10)) {
					
			throw new Exception("Invalid ID!");
					
		}
				
		this.id = id;
				
		// uses setters to call each variable with proper parameters
		// done to look cleaner
		setName(name);
		setDescription(description);
		
	}
	
	
	
	// getters and setters
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) throws Exception {
		
		if ((name == null) || (name.trim().length() < 1) || (name.length() > 20)) {
			
			throw new Exception("Invalid name!");
			
		}
		
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) throws Exception {
		
		if ((description == null) || (description.trim().length() < 1) || (description.length() > 50)) {
			
			throw new Exception("Invalid description!");
			
		}
	
		this.description = description;
	}
		
}
