/*
 * Author: Derek Tominaga
 * File: drill02.java
 * Descriptions: This drill gives practice using stacks and
 * queues. It also gives us practice with recursion*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Drill02 {
	
	// -------- Stacks/Queues

	// Given a stack as input, return a stack that has the
	// same values in reverse order.
	static Stack<Integer> reverseStack(Stack<Integer> in) {
		//System.out.println(in + "Start");   used for debug
		Stack<Integer> reversed = new Stack<Integer>();
		while(!in.empty()) {
			reversed.push(in.pop());
			//System.out.println(reversed + " filling");  used for debug
		}
		//System.out.println(reversed + " finished");	  used for debug
		return reversed;
	}

	// Given a queue, return a new queue that has the
	// same values in reverse order
	static Queue<Integer> reverseQueue(Queue<Integer> in) {
		//System.out.println(in + " Start");    used for debug
		Queue<Integer> reversed = new LinkedList<>();
		Stack<Integer> tempStack = new Stack<>();
		while(!in.isEmpty()) {
			tempStack.push(in.remove());
		}
		while(!tempStack.empty()) {
			reversed.add(tempStack.pop());
//			System.out.println(reversed + " Filling")  used to debug
		}
		//System.out.println(reversed + " finished");  used to debug
		return reversed;
	}
	
	
	// -------- Recursion

    // takes a number of characters to print as a parameter
    // returns a string with one or two asterisks in the middle
    // surrounded by alligators
	// See the README
    public static String zigzag(int n) {
    	if (n == 0) {
    		return "";
    	}
    	if(n-1 == 0) {
    		return "*";
    	}
    	if(n-1 == 1) {
    		return "**";
    	}
    	return "<" + zigzag(n-2) + ">";
//    	String left = "<";
//		String right = ">";
//		String zigzag = "";
//    	if(n == 0) {
//    		return "";
//    	}
//    	if(n%2 != 0) {
//    		int multiplyer = (n-1)/2;
//    		for(int i = 0; i < multiplyer; i++) {
//    			zigzag += left;
//    		}
//    		zigzag += "*";
//    		for(int i = 0; i < multiplyer; i++) {
//    			zigzag += right;
//    		}
//    		
//    	}
//    	else {
//    		int multiplyer = (n-2)/2;
//    		for (int i = 0; i < multiplyer; i++) {
//    			zigzag += left;
//    		}
//    		zigzag += "*";
//    		for(int i = 0; i < multiplyer; i++) {
//    			zigzag += right;
//    		}
//    	}
//    	return zigzag;
    	//return "";
    }

    // takes a string and a character as parameters and returns 
    // the string with all copies of the character moved to the 
    // end and capitalized
    // See the README
    public static String moveToEnd(String s, char c) {
    	if(s.length() == 1) {
    		if(s.equals(Character.toString(c))) {
    			if(Character.isLetter(c)) {
    				return s.toUpperCase();
    			}
    			else {
    				return s;
    			}
    		}
    		else {
    			return s;
    		}
    	}
    	if(s.substring(0,1).toLowerCase().equals(Character.toString(c).toLowerCase())) {
    		//System.out.println(s.charAt(0) + " string"); used to debug
    		//System.out.println(c + " char");             used to debug
    		String recursedString = s.substring(1,s.length());
    		if(Character.isLetter(c)) {
    			return moveToEnd(recursedString, c) + Character.toString(c).toUpperCase();
    		}
    		else {
    			return moveToEnd(recursedString,c) + s.substring(0,1) ;
    		}
    	}
    	else {
    	return s.substring(0,1) + moveToEnd(s.substring(1,s.length()),c);
    	}
    }
}
