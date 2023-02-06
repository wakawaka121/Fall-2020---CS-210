/*Author: Derek Tominaga
 * File: UserCollection.java
 * Description: This file contains a class, UserCollection which is a collection of all users. 
 * The constructor contains one private field, userCollection. The userCollection is a TreeMap where the 
 * keys are the userNames and the values are the User object associated with that userName.The file also 
 * contains methods that will, check if the User exists, login with a username and passwrod, add a 
 * new user, and create a string of all the users in the collection with the number of playlists they have.*/
import java.util.TreeMap;

public class UserCollection {
	private TreeMap<String, User> userCollection;
	
	/*Constructs a new instance of the UserCollection
	 * userCollection field is set to an empty TreeMap.*/
	public UserCollection() {
		this.userCollection = new TreeMap<String, User>();
	}
	
	/*This method takes on parameter which is a string that represents
	 * a username and check to see if the username already exists in the 
	 * userCollection. If the does not exists then return true, else false*/
	public boolean userExists(String username) {
		if(this.userCollection.containsKey(username)) {
			return true;
		}
		return false;
		
	}
	
	/*This method takes in two parameters username and password to login. If the 
	 * username exists in the userCollection then it will attempt to login with 
	 * the password that was passed in. If the username and password match 
	 * then return the user with that username and password. 
	 * else return null, meaning the user name does match or the username
	 * does not exists.*/
	public User login(String username, String password) {
		if(userExists(username)) {
			User theUser = this.userCollection.get(username);
			if(theUser.attemptLogin(password) == true) {
				return theUser;
			}
		}
		return null;	
	}
	
	/*This method takes one parameter which is a User obejct that is to be
	 * added to the userCollection.
	 * This does not return since it is a void method.*/
	public void addUser(User add) {
		this.userCollection.put(add.getName(),add);
	}
	
	/*This method takes no parameter to create a string that represent all the user
	 * that exists in the userCollection object and the number of playlists that
	 * each user has. */
	public String toString() {
		String description = "";
		for(String userString : this.userCollection.keySet()) {
			User info = this.userCollection.get(userString);
			description = description + userString + ": " + info.getName() + ", " + 
					info.getPlaylists().size() + " playlists, ";
		}
		return description;
	}
}
