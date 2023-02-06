/*
 * Author: Derek Tominaga
 * File: Library.java
 * Description:This files contains a class, Library, which is a song library.
 * The library constructor has a single private field that is a TreeMap. Where the keys are
 * are the names of songs and the values are Song objects. 
 * It contains methods to, find a song in the library, get a list
 * of all the songs, add a song, remove a song and convert the library
 * to a string. 
 * */
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Library {
	private TreeMap<String, Song> library;
	
	/*Constructs a new instance of the library class*/
	public Library() {
		this.library = new TreeMap<String, Song>();	
	}
	
	/*This method takes one parameter title, which is a string
	 * that represent a song that is being looked for in the
	 * song library. 
	 * It will return a Song object if found in the library.*/
	public Song getSong(String title) {
		if(this.library.containsKey(title)) {
			return this.library.get(title);
		}
		return null;
		
	}
	/*This method takes no parameters and will generate a list
	 * of Song objects. If the list of songs is empty return null,
	 * otherwise if the return libraryList, which represent a list of
	 * all the Song objects in sorted order by title.*/
	public List<Song> getAllSongs(){
		List<Song> libraryList = new ArrayList<Song>();
		for(String song: this.library.keySet()) {
			libraryList.add(library.get(song));
		}
		if(libraryList.isEmpty()) {
			return null;
		}
		else return libraryList;
	}
	
	/*This method takes one parameter Song which is an object and adds 
	 * it to the library with they key as the title of the song and the
	 * the value as the Song object
	 * no return values cause this method is a void method.*/
	public void addSong(Song song) {
		this.library.put(song.getTitle(), song);
		
	}
	
	/*This method takes one parameter Song, to remove from the library.
	 * There is no return since it is a void method.*/
	public void removeSong(Song song) {
		this.library.remove(song.getTitle());
		
	}
	
	/*This method takes no parameter to generate a string
	 * that represents all the Song objects in the library, listed one Song per line
	 * and contains the Tilte of the song, the artist and the number of times played for
	 * the current user.
	 * Returns the string built of all the songs in the library.*/
	public String toString() {
		String libraryString = "";
		for(String song : this.library.keySet()) {
			libraryString = libraryString + "\n" + song + " by "+ this.library.get(song).getArtist() + ", " + this.library.get(song).getTimesPlayed() + " play(s)";
		}
		return libraryString;
		
	}
}
