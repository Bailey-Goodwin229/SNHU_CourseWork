package com.ContactService;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;

public class ContactTest {
	
	// Tests that our contact constructor is working correctly 
	@Test
	@DisplayName("Tests that the class Contact can take the appropriate information")
	void testSuccessfulCreation() throws Exception {
		
		Contact contact = new Contact("1", "Joe", "Shmoe", "2335687566", "47 Lollipop Lane");
		assertThat(contact)
			.hasFieldOrPropertyWithValue("id", "1")
			.hasFieldOrPropertyWithValue("firstName", "Joe")
			.hasFieldOrPropertyWithValue("lastName", "Shmoe")
			.hasFieldOrPropertyWithValue("phoneNumber", "2335687566")
			.hasFieldOrPropertyWithValue("address", "47 Lollipop Lane");
	}
	
	//tests that our setter are working in general
	@Test
	@DisplayName("Tests that the setters work appropriately")
	void testSuccessfulSetters() throws Exception {
		
		Contact contact = new Contact("1", "Joe", "Shmoe", "2335687566", "47 Lollipop Lane");
		contact.setFirstName("Kayla");
		contact.setAddress("36 Eaton Ave");
		contact.setLastName("Goodwin");
		contact.setPhoneNumber("9873321550");
		assertThat(contact)
			.hasFieldOrPropertyWithValue("firstName", "Kayla")
			.hasFieldOrPropertyWithValue("lastName", "Goodwin")
			.hasFieldOrPropertyWithValue("phoneNumber", "9873321550")
			.hasFieldOrPropertyWithValue("address", "36 Eaton Ave");
		
		
	}
	
	// tests all the parameters set out for our contact class requirements
	//CsvSource sets parameters and runs them through Parameter test
	@CsvSource({
		"' ', Joe, Shmoe, 2335687566, 47 Lollipop Lane", // Blank id
		", Joe, Shmoe, 2335687566, 47 Lollipop Lane", // null id
		"14756879094, Joe, Shmoe, 2335687566, 47 Lollipop Lane", // id too long
		"1, ' ', Shmoe, 2335687566, 47 Lollipop Lane", // blank first name
		"1,, Shmoe, 2335687566, 47 Lollipop Lane", // null first name
		"1, Joetgethgfd, Shmoe, 2335687566, 47 Lollipop Lane", // first name too long
		"1, Joe, ' ', 2335687566, 47 Lollipop Lane", // blank last name
		"1, Joe,, 2335687566, 47 Lollipop Lane", // null last name
		"1, Joe, Shmoehjuiop, 2335687566, 47 Lollipop Lane", // last name too long
		"1, Joe, Shmoe, ' ', 47 Lollipop Lane", // blank phone number
		"1, Joe, Shmoe,, 47 Lollipop Lane", // null phone number
		"1, Joe, Shmoe, 233568756623344, 47 Lollipop Lane", // phone number too long
		"1, Joe, Shmoe, 23356, 47 Lollipop Lane", // phone number too short
		"1, Joe, Shmoe, 2335687566, 47 Lollipop Lane thgeyutioh theandthe", // address too long
		"1, Joe, Shmoe, 2335687566,", // null address
	})
	@ParameterizedTest
	@DisplayName("Shows if a test parameter has failed")	
	void testFailedCreation(String id, String firstName, String lastName, String phoneNumber, String address) {
		
		assertThatThrownBy(() -> new Contact(id, firstName, lastName, phoneNumber, address))
			.isNotNull();
	}
	
	//tests setter for first name
	@CsvSource({
		",", // first name null
		"' ',", // blank first name
		"threhdgfhyt,", // first name too long
	})
	@ParameterizedTest
	void testSettingFirstName(String firstName) throws Exception {
		
		Contact contact = new Contact("1", "Joe", "Shmoe", "2335687566", "47 Lollipop Lane");
		assertThatThrownBy(() -> contact.setFirstName(firstName))
			.isNotNull();
	}
	
	//tests setters for last name
	@CsvSource({
		",", // last name null
		"' ',", // blank last name
		"threhdgfhyt,", // last name too long
	})
	@ParameterizedTest
	void testSettingLastName(String lastName) throws Exception {
		
		Contact contact = new Contact("1", "Joe", "Shmoe", "2335687566", "47 Lollipop Lane");
		assertThatThrownBy(() -> contact.setLastName(lastName))
			.isNotNull();
	}
	
		//tests setters for phone number
		@CsvSource({
			",", // phone number null
			"' ',", // blank phone number
			"127364578954,", // phone number too long
			"2545,", // phone number too short
		})
		@ParameterizedTest
		void testSettingPhoneNumber(String phoneNumber) throws Exception {
			
			Contact contact = new Contact("1", "Joe", "Shmoe", "2335687566", "47 Lollipop Lane");
			assertThatThrownBy(() -> contact.setPhoneNumber(phoneNumber))
				.isNotNull();
		}
		
		//tests setters for address
		@CsvSource({
			",", // address null
			"threhdgfhyreoguhrepoguheorguheogut,", // address too long
		})
		@ParameterizedTest
		void testSettingAddress(String address) throws Exception {
			
			Contact contact = new Contact("1", "Joe", "Shmoe", "2335687566", "47 Lollipop Lane");
			assertThatThrownBy(() -> contact.setAddress(address))
				.isNotNull();
		}


}
