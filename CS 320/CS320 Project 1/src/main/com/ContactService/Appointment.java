package com.ContactService;

import java.util.Date;

public class Appointment {
	
	// Declare variables
	private String appointmentId;
	private Date date;
	private String description;
		
	// Creates constructor for appointment
	public Appointment(String appointmentId, Date date, String description) throws Exception {
			
		super();
			
		// parameters for appointmentId
		if ((appointmentId == null) || (appointmentId.trim().length() < 1) || (appointmentId.length() > 10)) {
						
			throw new Exception("Invalid ID!");
						
		}
					
		this.appointmentId = appointmentId;
					
		// uses setters to call each variable with proper parameters
		// done to look cleaner
		setDate(date);
		setDescription(description);
			
	}
		
		
		
	// getters and setters
	public String getAppointmentId() {
		return appointmentId;
	}
		
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) throws Exception {
			
		if((date == null) || (date.before(new Date()))) {	
			throw new IllegalArgumentException("Invalid date!");
		}
			
		this.date = date;
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