package com.ContactService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppointmentService {
		
	//set up singleton pattern so there is only one instance
	private static AppointmentService INSTANCE;

	// creates map
	Map<String, Appointment> database = new ConcurrentHashMap<>();
			
	//calls instance
	private AppointmentService() {}
			
	// checks to see if there is an instance, if not if creates a new one
	public static synchronized AppointmentService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AppointmentService();
		}
		return INSTANCE;
	}
			
	// returns a read only copy of the database
	public Map<String, Appointment> getappointment() {
				 
		return Map.copyOf(database);
			      
	}
				
	// create class to add appointment
	public boolean addAppointment(Appointment appointment) {
		return database.putIfAbsent(appointment.getAppointmentId(), appointment) == null;
	}
				
	// creates class for deleting appointment
	public boolean deleteAppointment(String appointmentId) {
		return database.remove(appointmentId) != null;
	}

}
