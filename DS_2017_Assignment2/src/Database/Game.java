package Database;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Class to represent a PlayStation game.
 * Created for Data Structures, SP2 2017
 * @author James Baumeister
 * @version 1.0
 */
public class Game {
	
	// declare the instance variables
	// for the game class.
	private String name;
	private Calendar released;
	private Game next;
	private int totalTrophies;

    public Game() {}
    
    public Game(String name, Calendar released, int totalTrophies) {
    	
    	this.name = name;
    	this.released = released;
    	this.totalTrophies = totalTrophies;
    }

    public String toString() {
    	
    	// declare a simple date format object
    	SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
    	
    	// convert the released date from calendar object to a date object
    	Date gameDateobject = this.released.getTime();
    	
    	// convert the date object to a specific format
    	String printDate = formatter.format(gameDateobject);
    	
    	// build and return the final string
    	String finalOutput = "\"" + this.name + "\"" + ", released on: " + printDate;
    	
		return finalOutput;
    }
       
	@Override
    public boolean equals(Object o) {
		
		return true;
    }

	public Object getReleased() {
		// TODO Auto-generated method stub
		return this.released;
	}

	public Object getTotalTrophies() {
		// TODO Auto-generated method stub
		return this.totalTrophies;
	}

	public Object getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public void setNext(Game g2) {
		
		// if the pass in object is null,
		// set the next as null.
		if (g2 == null) {

			this.next = null;
		}

		// if the pass in game object is the same
		// name as the current object, we exit the
		// method and do nothing.
		else if (this.name.equalsIgnoreCase(g2.name.toString())) {

			return;
		}

		// else we set the pass in parameter as
		// the next game object.
		else {

			this.next = g2;
		}
						
	}

	public Game getNext() {
		return this.next;
	}
					
}
