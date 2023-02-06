/*Author: Derek Tominaga
 * File: Song.java
 * Description: This file contains a class,Song, which represent a Song
 * object. The Song object has three private fields. title, which is a string
 * that represents the title of the song. artist, which is a string that
 * represents the artist of the song. timesPlayed, which is an int that
 * represents the number of time the songs has been played for this users library.
 * The file also contains methods that, get the tile, artist and timesPlayed of the
 * Song object. A method to play a Song object, and a method to represent the
 * Song objects as a string. */
public class Song{
		private String title;
		private String artist;
		private int timesPlayed;
		
	/*Constructs a new Song instance with given title and artist, 
	 * timesPlayed initilized at 0.*/	
	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
		this.timesPlayed = 0;
	}
	
	/*This method takes no parameter to return the 
	 * title of the Song which is a string.*/	
	public String getTitle() {
		return this.title;
		
	}
	
	/*This method takes no parameter to return the
	 * artist of the song which is a string.*/
	public String getArtist() {
		return this.artist;
		
	}
	
	/*This method take no parameters to return the
	 * number of times the song is play Song.timesPlayed
	 * which is an int value.*/
	public int getTimesPlayed() {
		return this.timesPlayed;
		
	}
	
	/*This method takes no parameter to "play"
	 * the song. The song is played by printing it.
	 * timesPlayed is incremented after the song is "played"
	 * no return values since this is a void method.*/
	public void play() {
		System.out.println(this.toString());
		this.timesPlayed ++;
	}
	
	/*This method takes no parameter to print the Song object as a string.
	 * prints out the title of the song, the artist and the number of times played.
	 * returns a string that contains all this information.*/
	public String toString() {
		return this.title + " by " + this.artist + ", " + this.timesPlayed + " play(s)" ;
	}
}
