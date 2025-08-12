package com.gamingroom;

public class Entity {
	
	//declares variables
	private long id;
	private String name;
	
	//creates default constructor
	private Entity() {
		
	}
	
	//constructors for the name and id
	public Entity(long id, String name) {
		
		this();//calls default constructor
		//gets the names from getName and getId getters
		this.id = id;
		this.name = name;
				
	}
	
	//getter for id
	public long getId(){
		
		return id;
		
	}
	
	//getter for name
	public String getName() {
		
		return name;
		
	}
	
	//creates one string for player name and id
	public String toString() {
		
		return "Entity: [id: " + id + "name: " + name + "]";
		
	}

}
