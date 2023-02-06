/*Author: Derek Tominaga
 * File: User.java
 * Description: This file contais a class, User. The User
 * constructor contiains info about a User with three private fields, 
 * userName, password, userPlayLists.
 * The file also contains methods to get the name of the user, attempt to login,
 * add a new playlist to the list of playlists for the current user, get all the
 * playlists of the user, select a playlist to play, tell how many playlist the 
 * current user has and list them. */
import java.util.ArrayList;
import java.util.List;

public class User {
	private String userName;
	private String password;
	private List<Playlist> userPlayLists;
	
	/*Constructs a new instance of a User. And assigns the User object
	 * userName, password and an empty list that represents the playlist
	 * of the new User.*/
	public User(String name, String password) {
		this.userName = name;
		this.password = password;
		this.userPlayLists = new ArrayList<Playlist>();
	}
	
	/*This method takes no parameter to 
	 * return the userName of the user which is a 
	 * string*/
	public String getName() {
		return this.userName;	
	}
	
	/*This method takes one parameter to attempt to log in with 
	 * to a userName with and password. If the pass word matches
	 * the password of the User object return true. Else return false.*/
	public boolean attemptLogin(String password) {
		if(this.password.equals(password)) {
			return true;
		}
		return false;
	}
	
	/*This method one parameter which is a Playlist with name newPlaylist object, and
	 *  adds it to the list of Playlist objects.  This is a void 
	 *  method so there is no return.*/
	public void addPlaylist(Playlist newPlaylist) {
		this.userPlayLists.add(newPlaylist);
	}
	
	/*This method take no parameter to get the list of 
	 * current users playlists. 
	 * return this.userPlayLists which is a lists of Playlist objects*/
	public List<Playlist> getPlaylists(){
		return this.userPlayLists;
	}
	
	/*This method takes one parameter which is a string that represents the name of
	 * a user's playlist. It will loop through all the playlist and if there is a
	 * Playlist object that Playlist.name is the name of the input string it will
	 * play that Playlist.
	 * void method so no return.*/
	public void selectPlaylist(String name) {
		for (Playlist playList : this.userPlayLists) {
			if(playList.getName().equals(name)) {
				playList.play();
			}	
		}
	}
	
	/*This method takes no parameter to create and return a string that
	 * contains the User name and the number of playlist that the user has.*/
	public String toString() {
		return this.userName + ", " + this.userPlayLists.size() + " playlists";
		
	}
}
