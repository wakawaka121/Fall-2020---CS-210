/*
 * Author: Derek Tominaga
 * File: Drill03.java
 * Description: This drill contains methods 
 * that are intended to give practice with
 * recursion, string and int manipulation. 
 * */
public class Drill03 {

    // takes a string and two characters as parameters
    // returns a string that is the same as the passed in string
    // except that all occurrences of the first character are replaced
    // with the second
    public static String replaceAll(String s, char from, char to) {
    	if(s.length() == 1) {
    		if (s.charAt(0) == from){
    			return Character.toString(to);
    		}else {
    			return s;
    		}
    	}
    	if(s.charAt(0) == from){
    		return(Character.toString(to) +replaceAll(s.substring(1), from, to));
    	}else {
    		return (s.substring(0,1) + replaceAll(s.substring(1),from, to));
    	}
    }

    // takes an integer as a parameter
    // returns true if the digits are in sorted order ascending, 
    // false otherwise
    public static boolean digitsSorted(int x) {
    	if(Integer.toString(Math.abs(x)).length() == 1){
    		return true;
    	}
    	if(Integer.toString(Math.abs(x)).charAt(0) <= Integer.toString(Math.abs(x)).charAt(1)) {
    		if (x < 0) {
    			int recursiveInt = Integer.valueOf(Integer.toString(Math.abs(x)).substring(1));
    			return digitsSorted(recursiveInt);
    		}else {
    			int recursiveInt = Integer.valueOf(Integer.toString(x).substring(1));
    			return digitsSorted(recursiveInt);
    		}
    	}else {
    		return false;
    	}
    }

    /*
     * Write a recursive function which returns the input string
     * but with adjacent duplicate char- acters removed. Do not use
     * any String functions other than .charAt(), .length(), .isEmpty()
     * and .substring(). Do not use any loops. We recommend you use a
     * helper function so we have provided the helper function header
     * below
     */
    public static String removeAdjacentDuplicateChars(String s) {
    	if(s.length() == 0) {
    		return "";
    	}
    	if (s.length() == 1) {
    		return s;
    	}
    	if(s.charAt(0) == s.charAt(1)) {
    		return s.substring(0,1) + removeAdjacentDuplicateChars(s.substring(2));
    	}
    	return  s.substring(0,1) + removeAdjacentDuplicateChars(s.substring(1));
    }
    // Note that the helper function is 'private' since no other code
    // outside of this file needs to call this method.
    private static String removeHelper(String s, int index) {
    	return "";
    }
    
    /*
     * Write a recursive function that returns the number of occurrences
     * of an integer ’n’ inside of an array of integers. You may not use
     * loops or any array functions. You may use array.length to determine
     * the length of the array. We recommend you use a helper similar to the
     * one above. It would be useful if your helper function kept track of
     * which index in the array you are currently checking.
     */
    public static int countOccurrences(int[] arr, int n) {
    	int index = 0;    	
    	return countHelper(arr, n, index);
    }
    private static int countHelper(int[] arr, int n, int index) {
    	if(arr.length == 0) {
    		return 0;
    	}
    	if(index == arr.length-1) {
    		if(arr[index] == n) {
    			return 1;
    		}else {
    			return 0;
    		}
    	}
    	if(arr[index] == n) {
    		return 1 + countHelper(arr,n,index +1);
    	}
    	return countHelper(arr,n,index +1);
    	
    	
    }
}
