package com.ContactService;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class ContactServiceTest {
	
	//clear out map before each test
	@BeforeEach
	void init() {
		ContactService.getInstance().database.clear();
	}
	
	//tests that the instance is the same when called
	@Test
	void returnsSameInstance() {
		
	ContactService firstInstance = ContactService.getInstance();
	ContactService secondInstance = ContactService.getInstance();
	assertSame(firstInstance, secondInstance, "Should always return the same instance");
	
	}
	
	// create test for adding contacts
	@Test
	void testAddContact() throws Exception  {
		
		Contact contact = new Contact("1", "Joe", "Shmoe", "2335687566", "47 Lollipop Lane");
		assertThat(ContactService.getInstance().addContact(contact)).isTrue();
		assertThat(ContactService.getInstance().database)
			.containsEntry("1", contact);
	}
	
	// creates test for deleting contact information 
	@Test
	void testDeleteContact() throws Exception {
		
		Contact contact = new Contact("1", "Joe", "Shmoe", "2335687566", "47 Lollipop Lane");
		assertThat(ContactService.getInstance().addContact(contact)).isTrue();
		assertThat(ContactService.getInstance().deleteContact("1")).isTrue();
		assertThat(ContactService.getInstance().database)
			.doesNotContainEntry("1", contact);
		
	}
	
	// creates test for update method
	@Test
	void testUpdate() throws Exception {
		
		Contact contact = new Contact("1", "Joe", "Shmoe", "2335687566", "47 Lollipop Lane");
		assertThat(ContactService.getInstance().addContact(contact)).isTrue();
		
		Contact updated = new Contact("987", "Kayla", "Sleepy", "3451209782", "1234 Wannabe Lane");
		assertThat(ContactService.getInstance().updateContact("1", updated)).isTrue();
		assertThat(ContactService.getInstance().database)
			.extracting("1")
			.hasFieldOrPropertyWithValue("firstName", "Kayla")
			.hasFieldOrPropertyWithValue("lastName", "Sleepy")
			.hasFieldOrPropertyWithValue("phoneNumber", "3451209782")
			.hasFieldOrPropertyWithValue("address", "1234 Wannabe Lane");
	}
	
	//tests the copy of the read only map
	@Test
	void testReturnsReadOnlyCopy() throws Exception {
			
		Contact contact = new Contact("1", "Joe", "Shmoe", "2335687566", "47 Lollipop Lane");
		assertThat(ContactService.getInstance().addContact(contact)).isTrue();
	    Map<String, Contact> contacts = ContactService.getInstance().getContacts();
	    
	    // Attempt to modify the returned map
        assertThrows(UnsupportedOperationException.class, () -> {
           contacts.put("Contact 2", new Contact( "987", "Kayla", "Sleepy", "3451209782", "1234 Wannabe Lane"));
        });

	}

}
