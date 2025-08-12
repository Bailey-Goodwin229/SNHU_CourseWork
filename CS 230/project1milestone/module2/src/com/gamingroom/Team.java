package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity{
		
	/*
	 * creates a list for players
	 */
	private List<Player> players = new ArrayList<Player>();
	
	/*
	 * uses iterator to find if player exists or to create a new player
	 */
	public Player addPlayer(String name) {
		
		//sets current player to null
		Player player = null;
		
		//introduces iterator to go through list
		Iterator<Player> playersIterator = players.iterator();
		
		//goes through list to see if player exists, if not adds a new one
		while(playersIterator.hasNext()) {
			
			//sets a player variable to go through list
			Player playerInstance = playersIterator.next();
			
			if(playerInstance.getName().equalsIgnoreCase(name)) {
				
				player = playerInstance;
				
			}
			
			else {
				
				players.add(player);
				
			}	
		}
		
		return player;
	}
	
	/*
	 * Constructor with an identifier and name
	 * takes from entity class
	 */
	public Team(long id, String name) {
		super(id, name);
	}

	@Override
	public String toString() {
		return "Team [id=" + super.getId() + ", name=" + super.getName() + "]";
	}
}
