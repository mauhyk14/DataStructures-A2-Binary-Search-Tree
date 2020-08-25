package Database;

/**
 * Class to represent a single linked-list of Database.Game objects.
 * Created for Data Structures, SP2 2017
 * @author James Baumeister
 * @version 1.0
 */
public class GameList {

    public Game head;
    
    // point the current object head as 
    // the pass in head.
	public GameList(Game head) {
		
		this.head = head;
    }

    // 3.1.4
	public String toString() {
    	
		// point the temp as the head
    	Game temp = this.head;
    	
    	// if temp is bull, return the
    	// "Empty game list" string.
    	if(temp == null) {
    		
    		return "Empty game list";
    	}
    	
    	
    	// declare an empty string
    	String resultString = "";
    	
    	// as long as the temp has an object
    	// we want to call the toString methods
    	// to build the final string.
    	while(temp != null) {
    		
    		resultString += temp.toString();
    		   		
    		// if the game has a next game object,
    		// we start a new line in. Otherwise, we
    		// ignore.
    		if(temp.getNext() != null) {
    			resultString += "\n";
    		}
    		
    		
    		// update the temp object
    		temp = temp.getNext();
    	}
    	   	
		return resultString;
    }

	
	/*// teacher's code, not sure the purpose???
	 * 
	 * public void getGame(Game object) { 
	 *  	 
	 * }
	 */
	 
		
	// 3.1.1
	public void addGame(Game game) {

		try {
			
			// if the pass in game is null,
			// throw illegal exception.
			if (game == null) {

				throw new IllegalArgumentException();
			}
			

			// create a temp variable and points
			// to the current game list head.
			Game temp = this.head;

			// condition 1: if the head is not null,
			// it means that this is not the first game
			// node on the game list.
			if (temp != null) {

				while (temp.getNext() != null) {

					temp = temp.getNext();
				}

				// the game setNext method from the game class
				// will check the uniqueness of the game.
				// if the game is duplicated, the method will
				// do nothing.			
				temp.setNext(game);
			}

			// condition 2: this is the first game in the list,
			// point the game list head to this game object.
			else {

				this.head = game;
			}

		}

		catch (IllegalArgumentException e) {
			throw e;
		}
					
	}
	
	
	
	// 3.1.2
	public Game getGame(String name) {

		try {
			
			// if the pass in name is null,
			// throw illegal exception.
			if (name == null) {

				throw new IllegalArgumentException();
			}

			// declare the return game as null first
			Game returnGame = null;

			// create a variable temp and points
			// to head first.
			Game temp = this.head;

			// we loop through the single link list,
			// as soon as we find the game object,
			// we return it.
			while (temp != null) {

				if (temp.getName().equals(name)) {

					returnGame = temp;

					return returnGame;
				}

				temp = temp.getNext();
			}

			// if we didn't find the matching 
			// game object, we return null.
			return returnGame;

		}
		
		// Illegal exception throw if the pass in name 
		// is null
		catch (IllegalArgumentException e) {

			throw e;
		}

	}
	
	
	
		
	// 3.1.3		
	public void removeGame(Game game) {

		try {

			if (game == null) {

				throw new IllegalArgumentException();
			}
			
			// call this object's remove game by name method.
			this.removeGame(game.getName());
		}

		catch (IllegalArgumentException e) {
			throw e;

		}

	}

	
	
	// 3.1.3	
	public void removeGame(Object name) {

		try {

			// the exception only occurs when the name is
			// null.
			if (name == null) {

				throw new IllegalArgumentException();
			}

			// point the currentPointer to the head,
			// temp variable equals null.
			// for the delete method, the program has 2 pointers,
			// 1 is currentPointer; 2 is temp. 
			Game currentPointer = this.head;
			Game temp = null;

			// convert the pass in game object name into a String
			String Stringname = name.toString();

			// condition 1: the first link list node matches the pass in name
			if (currentPointer != null && currentPointer.getName().toString().equals(Stringname)) {

				this.head = currentPointer.getNext();

				return;
			}

			// condition 2: the pass in name matches the game object somewhere in the link
			// list.
			while (currentPointer != null && !currentPointer.getName().toString().equals(Stringname)) {

				temp = currentPointer;

				currentPointer = currentPointer.getNext();
			}

			// at this point, after traversing the single link list,
			// we couldn't find a match, we exit the method.
			if (currentPointer == null) {
				return;
			}

			// once we find the match, we update the set next method through the game
			// object. The temp pointer variable points to the next object of the 
			// currentPointer variable.
			temp.setNext(currentPointer.getNext());

		}

		catch (IllegalArgumentException e) {

			throw e;
		}

	}
	
	
	
	
}
