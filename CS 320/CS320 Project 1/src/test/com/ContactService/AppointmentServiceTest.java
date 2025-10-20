package com.ContactService;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class AppointmentServiceTest {
	
	//clear out map before each test
	@BeforeEach
	void init() {
		AppointmentService.getInstance().database.clear();
	}
		
	//tests that the instance is the same when called
	@Test
	void returnsSameInstance() {
		AppointmentService firstInstance = AppointmentService.getInstance();
		AppointmentService secondInstance = AppointmentService.getInstance();
		assertSame(firstInstance, secondInstance, "Should always return the same instance");
	}
	
	// create test for adding appointments
	@Test
	void testAddAppointment() throws Exception  {
				
		//process for setting date
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 20);
		c.set(Calendar.YEAR, 2025);
			  	
		Date goodDate = c.getTime();
						
		Appointment appointment = new Appointment("1", goodDate, "Testing the appointment description");
		assertThat(AppointmentService.getInstance().addAppointment(appointment)).isTrue();
		assertThat(AppointmentService.getInstance().database)
			.containsEntry("1", appointment);
	}
			
	// creates test for deleting appointment information 
	@Test
	void testDeleteAppointment() throws Exception {
				
		//process for setting date
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 20);
		c.set(Calendar.YEAR, 2025);
		  	
		Date goodDate = c.getTime();
					
		Appointment appointment = new Appointment("1", goodDate, "Testing the appointment description");
		assertThat(appointment);
		assertThat(AppointmentService.getInstance().addAppointment(appointment)).isTrue();
		assertThat(AppointmentService.getInstance().deleteAppointment("1")).isTrue();
		assertThat(AppointmentService.getInstance().database)
			.doesNotContainEntry("1", appointment);
				
	}
	
	//tests the copy of the read only map
	@Test
	void testReturnsReadOnlyCopy() throws Exception {
			
		//process for setting date
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 20);
		c.set(Calendar.YEAR, 2025);
				  	
		Date goodDate = c.getTime();
			
		//process for setting new date
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.MONTH, 12);
		c2.set(Calendar.DATE, 25);
		c2.set(Calendar.YEAR, 2025);
			
		Date goodDate2 = c2.getTime();
							
		Appointment appointment = new Appointment("1", goodDate, "Testing the appointment description");
		assertThat(AppointmentService.getInstance().addAppointment(appointment)).isTrue();
	    Map<String, Appointment> appointments = AppointmentService.getInstance().getappointment();
	        
	    // Attempt to modify the returned map
	    assertThrows(UnsupportedOperationException.class, () -> {
	        appointments.put("appointment 2", new Appointment("2", goodDate2, "fun new appointment"));
	    });
	}
}
