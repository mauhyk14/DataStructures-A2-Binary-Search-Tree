package Database;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Class to represent a PlayStation game trophy. A trophy comes in
 * four ranks: bronze, silver, gold and platinum. The date the trophy was
 * earned and its respective game is also stored.
 * Created for Data Structures, SP2 2017
 * @author James Baumeister
 * @version 1.0
 */
public class Trophy {
	
	// declare the required variables
	private String name;
	private Rank rank;
	private Rarity rarity;
	private Calendar obtained;
	private Game game;
	
	
    public enum Rank {
		BRONZE, GOLD, SILVER, PLATINUM
	}

	public enum Rarity {
		RARE, ULTRA_RARE, UNCOMMON, COMMON, VERY_RARE
	}

	public Trophy() {}

    public Trophy(String name, Rank rank, Rarity rarity, Calendar obtained, Game game) {
    	
    	this.name = name;
    	this.rank = rank;
    	this.rarity = rarity;
    	this.obtained = obtained;
    	this.game = game;
    }

    public String toString() {
    	
    	// declare a simple date format object
    	SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
    	
    	// convert the released date from calendar object to date object
    	Date gameDateobject = this.obtained.getTime();
    	
    	// convert the date object to a specific format
    	String printDate = formatter.format(gameDateobject);
    	   	
    	String finalString = "\"" + 
    			this.name +"\", " + 
    			"rank: " + this.getRank() + 
    			", rarity: " + this.getRarity() + 
    			", obtained on: " + printDate;
    	    	
    	return finalString;
    }

	public Object getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public Object getRank() {
		// TODO Auto-generated method stub
		return this.rank;
	}

	public Object getRarity() {
		// TODO Auto-generated method stub
		return this.rarity;
	}

	public Object getObtained() {
		// TODO Auto-generated method stub
		return this.obtained;
	}

	public Object getGame() {
		// TODO Auto-generated method stub
		return this.game;
	}
}
