package com.ContactService;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

public class TaskServiceTest {
	
	
	//clear out map before each test
	@BeforeEach
	void init() {
		TaskService.getInstance().database.clear();
		
	}
	
	//tests that the instance is the same when called
	@Test
	 void returnsSameInstance() {
		 TaskService firstInstance = TaskService.getInstance();
	     TaskService secondInstance = TaskService.getInstance();
	     assertSame(firstInstance, secondInstance, "Should always return the same instance");
	 }
		
	// create test for adding tasks
	@Test
	void testAddTask() throws Exception  {
			
		Task task = new Task("1", "fix", "Fix this task thing so it works");
		assertThat(TaskService.getInstance().addTask(task)).isTrue();
		assertThat(TaskService.getInstance().database)
			.containsEntry("1", task);
	}
		
	// creates test for deleting task information 
	@Test
	void testDeleteTask() throws Exception {
			
		Task task = new Task("1", "fix", "Fix this task thing so it works");
		assertThat(TaskService.getInstance().addTask(task)).isTrue();
		assertThat(TaskService.getInstance().deleteTask("1")).isTrue();
		assertThat(TaskService.getInstance().database)
			.doesNotContainEntry("1", task);
			
	}
		
	// creates test for update method
	@Test
	void testUpdate() throws Exception {
			
		Task task = new Task("1", "fix", "Fix this task thing so it works");
		assertThat(TaskService.getInstance().addTask(task)).isTrue();
			
		Task updated = new Task("987", "Solve", "solve the problems being presented");
		assertThat(TaskService.getInstance().updateTask("1", updated)).isTrue();
		assertThat(TaskService.getInstance().database)
			.extracting("1")
			.hasFieldOrPropertyWithValue("name", "Solve")
			.hasFieldOrPropertyWithValue("description", "solve the problems being presented");
	}
	
	//tests the copy of the read only map
	@Test
    void testReturnsReadOnlyCopy() throws Exception {
		
		Task task = new Task("1", "fix", "Fix this task thing so it works");
		assertThat(TaskService.getInstance().addTask(task)).isTrue();
        Map<String, Task> tasks = TaskService.getInstance().getTasks();
        
        // Attempt to modify the returned map
        assertThrows(UnsupportedOperationException.class, () -> {
            tasks.put("task 2", new Task("task 2", "Find Truth", "it'll be a long road"));
        });
	}
}
