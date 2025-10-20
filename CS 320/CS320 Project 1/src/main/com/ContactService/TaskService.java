package com.ContactService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskService {
	
	//set up singleton pattern so there is only one instance
	private static TaskService INSTANCE;

	// creates map
	Map<String, Task> database = new ConcurrentHashMap<>();
		
	//calls instance
	private TaskService() {}
		
	// checks to see if there is an instance, if not if creates a new one
	public static synchronized TaskService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new TaskService();
		}
		return INSTANCE;
	}
		
	// returns a read only copy of the database
	public Map<String, Task> getTasks() {
			 
		return Map.copyOf(database);
		      
	}
			
	// create class to add task
	public boolean addTask(Task task) {
		return database.putIfAbsent(task.getId(), task) == null;
	}
			
	// creates class for deleting task
	public boolean deleteTask(String id) {
		return database.remove(id) != null;
	}
			
	// creates class for updating tasks
	public boolean updateTask(String id, Task updated) throws Exception {
			Task existing = database.get(id);
				
			if (existing == null) return false;
				
			existing.setName(updated.getName());
			existing.setDescription(updated.getDescription());
				
			return true;
	}

}
