/*Author: Derek Tominaga
 * File: Playlist.java
 * Description: This files contains a class, Playlist. The Playlist constructor
 * has two private fields, name and contents. name is a string that represents
 * the name of the Playlist and contents is list of Song objects that are in
 * the Playlist.
 * It also contains methods to, get the name of the playlist, add a song 
 * to the playlist, play the songs in the playlist, shuffle and play the
 * songs in the playlist, and remove the a song from the playlist.*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist {
	private String name;
	private ArrayList<Song> contents;
	
	/*Constructs a new instance of a play list*/
	public Playlist(String name) {
		this.name = name;
		this.contents = new ArrayList<Song>();
		
	}
	
	/*Initilizes a playlist*/
	public Playlist(String name, List<Song> contents) {
		this.name = name;
		this.contents = (ArrayList<Song>) contents;
		
	}
	
	/*This methods takes no parameter to get the 
	 * name of the play list. 
	 * Returns the String name of the playlist*/
	public String getName() {
		return this.name;
	}
	
	/*This method takes one parameter song that is a Song object
	 * and adds it to the Playlist.contents.
	 * There is no return since this is a void method.*/
	public void addSong(Song song) {
		this.contents.add(song);
	}
	
	/*This method takes no parameters to play the songs in the 
	 * Playlist.contents in the order that they were input.
	 * This is a void method so there is no return.*/
	public void play() {
		for(Song playing : this.contents) {
			playing.play();
		}
	}
	
	/*This method takes no parameter and will shuffle the songs in the
	 * Playlist.contents and play them in the shuffled order.
	 * There is no return since this is a void method.*/
	public void shuffle() {
		Collections.shuffle(this.contents);
		for(Song playing : this.contents){
			playing.play();
		}
	}
	
	/*This method takes on parameter that is a Song object. The method 
	 * will remove the song from the contents. 
	 * There is no return since this is a void method.*/
	public void removeSong(Song song) {
		this.contents.remove(this.contents.indexOf(song));
	}
}
