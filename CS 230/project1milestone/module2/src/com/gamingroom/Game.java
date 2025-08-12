package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	
	//private list of teams
	private List<Team> teams = new ArrayList<Team>();
	
	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		super(id, name);
	}
	
	/*
	 * uses iterator pattern to find if team exists, if not it adds a new team
	 */
	public Team addTeam(String name) {
		
		//sets team variable to null
		Team team = null;
		
		//Introduces iterator to go through list
		Iterator<Team> teamsIterator = teams.iterator();
		
		//Iterates through list to check if team exists, if not it adds a new team
		while(teamsIterator.hasNext()) {
			
			//sets a variable to next on the list
			Team teamInstance = teamsIterator.next();
			
			if(teamInstance.getName().equalsIgnoreCase(name)) {
				
				team = teamInstance;
				
			}
			
			else {
				
				teams.add(team);
				
			}
		}
		
		return team;
	}
	

	@Override
	public String toString() {
		
		return "Game [id=" + super.getId() + ", name=" + super.getName() + "]";
	}

}
