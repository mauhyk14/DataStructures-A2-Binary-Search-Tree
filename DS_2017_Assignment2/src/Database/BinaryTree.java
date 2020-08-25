package Database;

import java.util.ArrayList;


/**
 * Uses a binary search tree to store a database of
 * PlayStation users. Nodes are ordered by user unique key (see the
 * User class for more detail).
 * Created for Data Structures, SP2 2017
 * @author James Baumeister
 * @version 1.0
 */
public class BinaryTree {
	
	public User root;

	/**
	 * Making new friends is great. This method should add your new
	 * bestie to your database (tree). Remember that they should be
	 * added according to their key.
	 * @param friend The friend to be added
	 * @return true if successfully added, false for all error cases
	 * @throws IllegalArgumentException if friend is null
	 */
	public boolean beFriend(User friend) throws IllegalArgumentException {
		try {
			// if the pass in friend object is null,
			// the program will throw an illegal argument
			// exception.
			if (friend == null) {
				throw new IllegalArgumentException();
			}

			// At this point, if the tree is empty,
			// it will set the root as the pass in
			// user object.
			if (this.root == null) {

				this.root = friend;

				return true;
			}

			// else, it will determine the position of this
			// user object in the tree.
			else {

				return this.root.addmethod(friend);
			}

		}

		catch (IllegalArgumentException e) {
			throw e;
		}
	}

	
	/**
	 * Sometimes friendships don't work out. In those cases it's best
	 * to remove that "friend" altogether. This method should remove
	 * all trace of that "friend" in the database (tree).
	 * @param friend the "friend" to remove
	 * @return true if successfully removed, false for all error cases
	 * @throws IllegalArgumentException if "friend" is null
	 */
	public boolean deFriend(User friend) throws IllegalArgumentException {
		
		try {
			
			if(friend == null) {
				
				throw new IllegalArgumentException ();
			}
			
			
			
			return false;
		}
		
		catch (IllegalArgumentException e) {
					
			throw e;
		}
	}

	/**
	 * In your quest to be the very best you need to know how many
	 * of your friends are ranked higher than you. This method should
	 * return the number of higher ranked users that the provided reference
	 * user, or zero if there are none (woot!).
	 * @param reference The starting point in the search
	 * @return Number of higher ranked users or -1 if user not found
	 * @throws IllegalArgumentException if reference is null
	 */
	public int countBetterPlayers(User reference) throws IllegalArgumentException {

		try {

			if (reference == null) {

				throw new IllegalArgumentException();
			}

			else {

				// first, we need to find whether this user exist
				// in the tree.
				User temp = this.findFriend(this.root, reference.getUsername().toString());

				// if such user does not exist, we will return -1 
				// and end the method.
				if (temp == null) {

					return -1;
				}

				// else we will return the number of players who are better
				// than me
				else {

					// pass in the this.root, the counter and the user we want to
					// compare.
					return this.assisCountbetterPlayer(this.root, reference);
				}
			}

		}

		catch (IllegalArgumentException e) {
			throw e;
		}
	}
	
	
		
	public int assisCountbetterPlayer(User root, User reference) {

		// initialise our counter
		int counter = 0;

		// this is our base. If the root is empty,
		// we return null.
		if (root == null) {

			return 0;
		}
		
		
		else {
		
		if (root.getLevel() > reference.getLevel()) {

			counter++;
		}

		counter += this.assisCountbetterPlayer(root.getLeft(), reference);

		counter += this.assisCountbetterPlayer(root.getRight(), reference);

		return counter;
		
		}
		
	}
	
	
	
	/**
	 * Bragging rights are well earned, but it's good to be sure that you're actually
	 * better than those over whom you're lording your achievements. This method
	 * should find all those friends who have a lower level than you, or zero if
	 * there are none (you suck).
	 * @param reference The starting point in the search
	 * @return Number of lower ranked users
	 * @throws IllegalArgumentException if reference is null
	 */
	public int countWorsePlayers(User reference) throws IllegalArgumentException {

		try {

			if (reference == null) {

				throw new IllegalArgumentException();
			}

			else {

				// first, we need to find whether this user exist
				// in the tree.
				User temp = this.findFriend(this.root, reference.getUsername().toString());

				// if such user does not exist, we will return -1 and end the method.
				if (temp == null) {

					return -1;
				}

				else {

					return assistWorstplayers(this.root, reference);	

				}
			}

		}

		catch (IllegalArgumentException e) {
			throw e;
		}
				
	}
	
	
	private int assistWorstplayers(User root, User reference) {

		// initialise our counter
		int counter = 0;

		// this is our base. If the root is empty,
		// we return null.
		if (root == null) {

			return 0;
		}

		else {

			if (root.getLevel() < reference.getLevel()) {

				counter++;
			}

			counter += this.assistWorstplayers(root.getLeft(), reference);

			counter += this.assistWorstplayers(root.getRight(), reference);

			return counter;

		}

	}


	/**
	 * The best player may not necessarily be measured by who has the highest level.
	 * Platinum trophies are the holy grail, so it would be good to know who has the
	 * most. This method should return the user with the highest number of platinum trophies.
	 * @return the user with the most platinum trophies, or null if there are none
	 */
	public User mostPlatinums() {
		return null;
	}

	/**
	 * You or one of your friends bought a new game! This method should add it to their
	 * GameList.
	 * @param username The user who has bought the game
	 * @param game The game to be added
	 */
	public void addGame(String username, Game game) throws IllegalArgumentException {
		
		try {
			
			if(username == null || game == null) {
				throw new IllegalArgumentException();
			}
			
			
			else {
								
				User tempUser = this.findFriend(this.root, username);
				
				
				if(tempUser != null) {
					
					tempUser.getGames().addGame(game);
				}
								
			}
			
		}
		
		
		catch(IllegalArgumentException e) {
			
			throw e;
		}	
	}

	/**
	 * You or one of your friends achieved a new trophy! This method should add it to
	 * their trophies.
	 * @param username The user who has earned a new trophy
	 * @param trophy The trophy to be added   
	 */
	public void addTrophy(String username, Trophy trophy) throws IllegalArgumentException {
		
		try {
			
			if(username == null || trophy == null) {
				
				throw new IllegalArgumentException();
			}
			
		}
		
		catch(IllegalArgumentException e) {
			
			throw e;
		}
		
	}

	/**
	 * You or one of your friends has gained one level! This is great news, except that
	 * it may have ruined your tree structure! A node move may be in order.
	 * @param username The user whose level has increased
	 */
	public void levelUp(String username) throws IllegalArgumentException {

		try {

			if (username == null) {

				throw new IllegalArgumentException();
			}

		}

		catch (IllegalArgumentException e) {

			throw e;
		}

	}

	/**
	 * As your friends list grows, adding with regular binary tree rules will
	 * result in an unbalanced and inefficient tree. One approach to fix this
	 * is to implement an add method that uses AVL balancing. This method should
	 * work in the same way as beFriend, but maintain a balanced tree according to
	 * AVL rules.
	 * @param friend The friend to be added
	 * @return true if  successfully added, false for all error cases
	 * @throws IllegalArgumentException if friend is null
	 */
	public boolean addAVL(User friend) throws IllegalArgumentException {
		return false;
	}

	/**
	 * A nice, neat print-out of your friends would look great in the secret scrap-book
	 * that you keep hidden underneath your pillow. This method should print out the
	 * details of each user, traversing the tree in order.
	 * @return A string version of the tree
	 */
	public String toString() {
		
		String finalString = this.assistTostring(this.root);	
					
		return finalString.substring(0, finalString.length() - 1);						
	}
	
	
	
	public String assistTostring(User root) {
		
		// declare an empty string				
		String resultString = "";
		
		// traversing the tree nodes through the in order method and
		// combine the final result string. 
		if(root != null) {
												
			resultString += this.assistTostring(root.getLeft());
			
			
			resultString += root.toString() + "\n";
			
			
			resultString += this.assistTostring(root.getRight());
						
		}
				
		// return the resulting string. If it is empty,
		// it will return an empty string else, it will
		// return the combined final string to the console.						
		return resultString;				
	}
	
	
	
			
	/* my custom method to find a user in the tree,
	 * this method will ignore the search principle but
	 * follow the pre-order search method.*/
	public User findFriend(User root, String friendNeedtoFind) {

		// if the root equals to null,
		// return null.
		if (root == null) {

			return null;
		}

		
		// if we find a match, we return the location of this user object.
		if (root.getUsername().toString().equalsIgnoreCase(friendNeedtoFind)) {

			return root;
		}

		
		else {
			
			// else, we continue search the left of the root.
			User foundUser = this.findFriend(root.getLeft(), friendNeedtoFind);
			
			// if nothing comes out from the left, we search the right of the root.
			if (foundUser == null) {

				foundUser = this.findFriend(root.getRight(), friendNeedtoFind);
			}

			return foundUser;

		}

	}

}
