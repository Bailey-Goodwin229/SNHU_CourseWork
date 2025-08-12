package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;//imports iterator for use

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	
	/*
	 * Holds the next player id
	 */
	private static long nextPlayerId = 1;
	
	/*
	 * Holds the next team id
	 */
	private static long nextTeamId = 1;
		
	//create a new private variable to hold the game
	private static GameService service = null;
	
	//default constructor for the game
	private GameService() {}
	
	//looks for instance of saved game
	public static GameService getInstance() {
		
		//checks to see if game service exists
		if(service == null) {
			//creates new instance of memory if it doesn't exist
			service = new GameService();
			System.out.println("New game service created.");
		}
		else {
			//game service exists, lets users know
			System.out.println("Game service already instantiated");
		}
		
		//returns one game service
		return service;
	}
	
	
	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		//calls iterator
		Iterator<Game> gamesIterator = games.iterator();
		
		//iterates over all games
		while(gamesIterator.hasNext()) {
			
			//sets variable to next spot in list
			Game gameInstance = gamesIterator.next();
			
			//checks to see if game exists and pulls instance if it exists
			if(gameInstance.getName().equalsIgnoreCase(name)) {
				
				return gameInstance;
				
			}	
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// instance iterator
		Iterator<Game> gamesIterator = games.iterator();
		
		//iterates over games list
		while(gamesIterator.hasNext()) {
			
			//sets local game variable to next item
			Game gameInstance = gamesIterator.next();
			
			//checks to see if game id exists and if it does returns id
			if(gameInstance.getId() == id) {
				
				return gameInstance;
				
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		//Instance iterator
		Iterator<Game> gamesIterator = games.iterator();
		
		//runs through list of games
		while(gamesIterator.hasNext()) {
			
			//sets it to local variable and next item on the list
			Game gameInstance = gamesIterator.next();
			
			//checks if game exists, if it does it returns the game
			if(gameInstance.getName().equalsIgnoreCase(name)) {
				
				game = gameInstance;
				
			}
		}
		

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	/*
	 * returns the player who's turn it is next
	 */
	public long getNextPlayerId() {
		
		return nextPlayerId;
		
	}
	
	/*
	 * returns next team who is next
	 */
	public long getNextTeamId() {
		
		return nextTeamId;
		
	}
}
