package Database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Class to represent a PlayStation user.
 * Created for Data Structures, SP2 2017
 * @author James Baumeister
 * @version 1.0
 */
public class User {
	
	// declare the required variables
    private Object username;
	private int level;
	private double key;
	private ArrayList<Trophy> trophies;
	private GameList games;
	private Calendar dob;
	private User left;
	private User right;

	public User(String username, Calendar dob, int level) {
		
		this.username = username;
		this.dob = dob;
		this.level = level;		
    }

    /**
     * DO NOT MODIFY THIS METHOD
     * This method uses the username and level to create a unique key.
     * As we don't want the username's hash to increase the level, it's first converted
     * to a floating point, then added to the level.
     * @return the unique key
     */
    public double calculateKey() {
        int hash = Math.abs(username.hashCode());
        // Calculate number of zeros we need
        int length = (int)(Math.log10(hash) + 1);
        // Make a divisor 10^x
        double divisor = Math.pow(10, length);
        // Return level.hash
        return level + hash / divisor;
    }

    public String toString() {
    	   	
    	// declare a simple date format object
    	SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
    	
    	// convert the released date from calendar object to a date object
    	Date gameDateobject = this.dob.getTime();
    	
    	// convert the date object to a specific format
    	String printDate = formatter.format(gameDateobject);
    	
    	   	   	
    	String trophieString = "";    	
    	
    	// traversing the trophies array list to build 
    	// the string.
		for(int i=0; i < trophies.size(); i++) {
		  
		trophieString += trophies.get(i).toString() + "\n"; }
		 
		
    	String finalString = "User: " + this.username + "\n" + "\n" +
    						 "Trophies: " + "\n" + trophieString + "\n" + 
    						 "Games: " + "\n" + this.games.toString() + "\n" + 
    						 "\n" + "Birth Date: " + printDate;
    	
    	
		return finalString;
	}
    
    
    // the recursive method which use to insert a node 
    // to the tree.
	public boolean addmethod(User needToaddUser) {

		// if the current object is equals to the pass in
		// object, we will jump out from this method and
		// return false. This friend object already exist
		// in our tree.
		if (this.getKey() == needToaddUser.getKey()) {

			return false;
		}

		// if the pass in object is smaller than the current(this)
		// object, first it check whether this object left is empty.
		// If it is true, we will insert this object.
		else if (needToaddUser.getKey() - this.getKey() < 0) {

			if (this.getLeft() == null) {

				this.setLeft(needToaddUser);

				return true;
			}

			// else, we move to the left node of the current object,
			// recursively call the left method, update the current
			// object.
			else {

				return this.getLeft().addmethod(needToaddUser);
			}
		}

		// the situation here is for the pass in object which is bigger
		// than the current object.
		else {

			if (this.getRight() == null) {

				this.setRight(needToaddUser);

				return true;
			}

			// again, here it just update the current object to
			// the right. so now, the current become the object
			// on the right after calling the add method.
			else {
				return this.getRight().addmethod(needToaddUser);
			}
		}
				
	}
    
       
	public Object getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	public Object getDob() {
		// TODO Auto-generated method stub
		return this.dob;
	}

	public int getLevel() {
		// TODO Auto-generated method stub
		return this.level;
	}
			
	public double getKey() {
		// TODO Auto-generated method stub
		return this.calculateKey();
	}
		
	public void setGames(GameList games) {
		// TODO Auto-generated method stub
		this.games = games;
	}

	public void setTrophies(ArrayList<Trophy> trophies) {
		// TODO Auto-generated method stub
		this.trophies = trophies;
	}

	public User getLeft() {
		return left;
	}

	public void setLeft(User left) {
		this.left = left;
	}

	public User getRight() {
		return right;
	}

	public void setRight(User right) {
		this.right = right;
	}

	public ArrayList<Trophy> getTrophies() {
		// TODO Auto-generated method stub
		return this.trophies;
	}

	public GameList getGames() {
		// TODO Auto-generated method stub
		return this.games;
	}
		
	
}
