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
			
			
			// this will check the user exist in our tree.
			User temp = this.findFriend(this.root, friend.getUsername().toString());
			
			// if temp is null, we know that the node doesn't exist
			// in our tree or this root is null, we know that the tree is empty.
			// We return null right away.
			if(temp == null || this.root == null) {
				
				return false;
			}
			
			
			// else we call the defriendassist method
			// to delete the User object.
			else {
								
				this.defriendAssist(this.root, friend);
				
				return true;
			}
															
		}
		
		catch (IllegalArgumentException e) {
					
			throw e;
		}
	}
	
	
	
	public User defriendAssist(User root, User friend) {
		
		
		if(root.getKey() > friend.getKey()) {
						
			User tempUserleft = this.defriendAssist(root.getLeft(), friend);
						
			root.setLeft(tempUserleft);
		}
		
						
		else if(root.getKey() < friend.getKey()) {
			
			
			User tempUserright = this.defriendAssist(root.getRight(), friend);
			
			root.setRight(tempUserright);
		}
		
		// this is where you handle the deletion
		else {
								
			
			// Case 1: if the target node has no leaf node.
			if (root.getLeft() == null && 
				root.getRight() == null) {

				return null;
			}
			
			
			// Case 2: if the target node has one leaf node		
			// the target node has no left node (it has only one node),
			// it returns the right node.
			else if (root.getLeft() == null) {

				return root.getRight();
			}
			
			// the target node has no right node (it has only one node as well),
			// it returns the left node.
			else if (root.getRight() == null) {

				return root.getLeft();
			}
			
			
			// Case 3: if the target node has 2 leaf nodes			
			// the target node has 2 children nodes.
			else {
				
				// create a new user variable and
				// store the old root reference.
				User oldRoot = root;
								
				// find the maximum of the left subtree
				User target = this.findMaxleft(root.getLeft());
								
				// replace the current root to the 
				// maximum of the left subtree.
				root = target;

				
				// -----------------------------------

				root.setLeft(this.defriendAssist(oldRoot.getLeft(), target));
				
				// at this stage, we new root has no right child subtree.
				//?????????????????????????
				System.out.println("!!!!! " + root.getUsername());
				
				
				// this will cause null point exception!!!!
				//System.out.println(root.getRight().getUsername());
				
				// -----------------------------------
				

			}
		}
		
		return root;
	}
	
			
	// this method find the minimum value of the right
	// subtree.(the most left of the right subtree)
	public User findMinRight(User findMin) {

		User minUser = findMin;

		while (findMin.getLeft() != null) {

			minUser = findMin.getLeft();

			findMin = findMin.getLeft();
		}

		return minUser;
	}
	
	
	// this method find the maximum of the left subtree.
	// The most right of the left subtree.
	public User findMaxleft(User findMax) {

		User MaxUser = findMax;

		while (findMax.getRight() != null) {

			MaxUser = findMax.getRight();

			findMax = findMax.getRight();
		}
		return MaxUser;
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
		
		// if the root is empty, it means there is no node 
		// in the tree. We return null.
		if(this.root == null) {
			
			return null;
		}
		
		
		else {
									
			return this.assistMostplatinum(this.root);			
			
		}				
	}
	
	
	public User assistMostplatinum(User passInnode) {
				
		// This is the base method for the recursion.
		// If the passInnode object is null, we return null.
		if(passInnode == null) {
			
			return null;
		}
		
				
		else {
			
			// assume the passinNode object is the maximum.
			User max = passInnode;
			
			// recursively update the left node and compare the object
			// with max object.
			if(passInnode.getLeft() != null) {
				
				User leftMax = this.assistMostplatinum(passInnode.getLeft());
								
				
				if(leftMax.countPlatinums() > max.countPlatinums()) {
					
					max = leftMax;
				}
				
				
				else if(leftMax.countPlatinums() == max.countPlatinums() &&
						leftMax.countGolds() > max.countGolds()) {
					
					max = leftMax;
				}
								
			}
						
			// recursively update the right node and compare the object
			// with max object.			
			if (passInnode.getRight() != null) {
				
				User rightMax = this.assistMostplatinum(passInnode.getRight());
				

				if (rightMax.countPlatinums() > max.countPlatinums()) {

					max = rightMax;
				}

				else if (rightMax.countPlatinums() == max.countPlatinums()
						&& rightMax.countGolds() > max.countGolds()) {

					max = rightMax;
				}

			}
			
			// return the final max object.
			return max;			
		}
				
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
			
			// the find friend method will determine whether 
			// the pass in user exist in our tree.
			User temp = this.findFriend(this.root, username);
			
			if(temp != null) {
				
				// if this user exist in our tree, next, we check whether
				// this user already own the trophy by using the index method.
				int trophieIndex = temp.getTrophies().indexOf(trophy);
				
				// -1 indicates the trophy does not exist,
				// we use the in-build add method to add this trophy 
				// to this user.
				if(trophieIndex == -1) {
					
					temp.getTrophies().add(trophy);
				}
								
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
