package com.ContactService;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;

public class TaskTest {
	
	// Tests that our task constructor is working correctly 
	@Test
	@DisplayName("Tests that the class Task can take the appropriate information")
	void testSuccessfulCreation() throws Exception {
			
		Task task = new Task("1", "fix", "Fix this task thing so it works");
		assertThat(task)
			.hasFieldOrPropertyWithValue("id", "1")
			.hasFieldOrPropertyWithValue("name", "fix")
			.hasFieldOrPropertyWithValue("description", "Fix this task thing so it works");
	}
	
	//tests that our setter are working in general
	@Test
	@DisplayName("Tests that the setters work appropriately")
	void testSuccessfulSetters() throws Exception {
			
		Task task = new Task("1", "fix", "Fix this task thing so it works");
		task.setName("fix");
		task.setDescription("Fix this task thing so it works");
		assertThat(task)
				.hasFieldOrPropertyWithValue("name", "fix")
				.hasFieldOrPropertyWithValue("description", "Fix this task thing so it works");			
			
		}
	
	// tests all the parameters set out for our task class requirements
	//CsvSource sets parameters and runs them through Parameter test
	@CsvSource({
		"' ', fix, Fix this task thing so it works", // Blank id
		",fix, Fix this task thing so it works", // null id
		"14756879094, fix, Fix this task thing so it works", // id too long
		"1, ' ', Fix this task thing so it works", // blank name
		"1,, Fix this task thing so it works", // null name
		"1, frrwegorweogrgfhgirehd, Fix this task thing so it works", // name too long
		"1, fix, ' '", // blank description
		"1, fix,", // null description
		"1, fix, Fix this task thing so it worksthdnfkghoglthwkajdhghghjej", // description too long		
	})
	@ParameterizedTest
	@DisplayName("Shows if a test parameter has failed")	
	void testFailedCreation(String id, String name, String description) {
			
		assertThatThrownBy(() -> new Task(id, name, description))
			.isNotNull();
		}
	
	//tests setter for name
	@CsvSource({
		",", // name null
		"' ',", // blank name
		"threhdgfhyttheidhsgttuy,", // name too long
	})
	@ParameterizedTest
	void testSettingName(String name) throws Exception {
			
		Task task = new Task("1", "fix", "Fix this task thing so it works");
		assertThatThrownBy(() -> task.setName(name))
			.isNotNull();
	}
		
	//tests setters for description
	@CsvSource({
		",", // description null
		"' ',", // blank description
		"threhdgfhytthryeutriehsncvhgutoyluyteasdfghjkluodjfk,", // description too long
	})
	@ParameterizedTest
	void testSettingDescription(String description) throws Exception {
			
		Task task = new Task("1", "fix", "Fix this task thing so it works");
		assertThatThrownBy(() -> task.setDescription(description))
			.isNotNull();
	}

}
