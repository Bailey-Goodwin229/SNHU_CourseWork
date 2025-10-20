package com.ContactService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContactService {
	
	//set up singleton pattern so there is only one instance
	private static ContactService INSTANCE;

	// creates map
	Map<String, Contact> database = new ConcurrentHashMap<>();
	
	//calls instance
	private ContactService() {}
	
	// checks to see if there is an instance, if not if creates a new one
	public static synchronized ContactService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ContactService();
		}
		return INSTANCE;
	}
	
	// returns a read only copy of the database
	public Map<String, Contact> getContacts() {
		 
	    return Map.copyOf(database);
	      
	}
		
	// create class to add contact
	public boolean addContact(Contact contact) {
		return database.putIfAbsent(contact.getId(), contact) == null;
	}
		
	// creates class for deleting contact
	public boolean deleteContact(String id) {
		return database.remove(id) != null;
	}
		
	// creates class for updating contacts
	public boolean updateContact(String id, Contact updated) throws Exception {
			Contact existing = database.get(id);
			
			if (existing == null) return false;
			
			existing.setFirstName(updated.getFirstName());
			existing.setLastName(updated.getLastName());
			existing.setPhoneNumber(updated.getPhoneNumber());
			existing.setAddress(updated.getAddress());
			
			return true;
	}
	
}
