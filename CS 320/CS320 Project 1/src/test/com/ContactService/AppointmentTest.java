package com.ContactService;

import static org.assertj.core.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;

public class AppointmentTest {

	// Tests that our appointment constructor is working correctly 
	@Test
	@DisplayName("Tests that the class appointment can take the appropriate information")
	void testSuccessfulCreation() throws Exception {
		
		//process for setting date
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 11);
	  	c.set(Calendar.DATE, 20);
	  	c.set(Calendar.YEAR, 2025);
	  	
	  	Date goodDate = c.getTime();
				
		Appointment appointment = new Appointment("1", goodDate, "Testing the appointment description");
		assertThat(appointment)
			.hasFieldOrPropertyWithValue("appointmentId", "1")
			.hasFieldOrPropertyWithValue("date", goodDate)
			.hasFieldOrPropertyWithValue("description", "Testing the appointment description");
	}
		
	//tests that our setter are working in general
	@Test
	@DisplayName("Tests that the setters work appropriately")
	void testSuccessfulSetters() throws Exception {
		
		//process for setting date
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 20);
		c.set(Calendar.YEAR, 2025);
			  	
		Date goodDate = c.getTime();
				
		Appointment appointment = new Appointment("1", goodDate, "Testing the appointment description");
		appointment.setDate(goodDate);
		appointment.setDescription("Testing the appointment description");
		assertThat(appointment)
				.hasFieldOrPropertyWithValue("date", goodDate)
				.hasFieldOrPropertyWithValue("description", "Testing the appointment description");			
				
	}
		
	// tests most the parameters set out for our appointment class requirements
	//CsvSource sets parameters and runs them through Parameter test
	// Tests only if the date is null, further date testing done below
	@CsvSource({
		"' ', , Testing the appointment description", // Blank id
		",, Testing the appointment description", // null id
		"14756879094,, Testing the appointment description", // id too long
		"1,, Testing the appointment description", // null date
		"1, , ' '", // blank description
		"1, ,", // null description
		"1, , Testing the appointment description so it worksthdnfkghoglthwkajdhghghjej", // description too long		
	})
	@ParameterizedTest
	@DisplayName("Shows if a test parameter has failed")	
	void testFailedCreation(String appointmentId, Date date, String description) {
				
		assertThatThrownBy(() -> new Appointment(appointmentId, date, description))
			.isNotNull();
	}
		
	//tests setter for date that is good
	@Test
    void testSetAppointmentDateWithGoodDate() throws Exception {
      
        Appointment appointment = new Appointment("1", new Date(), "Testing the appointment description");
        
        // Create a new date that is in the future
        Date goodDate = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(10));

        appointment.setDate(goodDate);

        assertThat(appointment.getDate())
                .isEqualTo(goodDate);
    }
	
	 // Tests date for bad date
	 @Test
	 void testSetAppointmentDateWithBadDate() throws Exception {
	    
	    Appointment appointment = new Appointment("1", new Date(), "Testing the appointment description");

	    // Create a date in the past
	    Date badDate = new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(10));

	    assertThatThrownBy(() -> appointment.setDate(badDate))
	    	.isInstanceOf(IllegalArgumentException.class)
	    	.hasMessage("Invalid date!");
	}
		
	//tests setters for description
	@CsvSource({
		",", // description null
		"' ',", // blank description
		"threhdgfhytthryeutriehsncvhgutoyluyteasdfghjkluodjfk,", // description too long
	})
	@ParameterizedTest
	void testSettingDescription(String description) throws Exception {
		
		//process for setting date
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 20);
		c.set(Calendar.YEAR, 2025);
					  	
		Date goodDate = c.getTime();
				
		Appointment appointment = new Appointment("1", goodDate, "Testing the appointment description");
		assertThatThrownBy(() -> appointment.setDescription(description))
			.isNotNull();
	}

}
