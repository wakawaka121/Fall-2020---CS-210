import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * For this drill, you will get practice with recursive backtracking. As with
 * the previous drill that emphasized recursion, this drill will be more difficult
 * than other drills for many students. Start early!
 * 
 * Remember these are all recursive backtracking problems. So make sure to ask yourself
 * the questions detailed in the slides. These questions will lead you to the answer.
 * All of the code should be in the general pseudocode shown in the slides. A shortened
 * version:
 * -------------------------------
 * Base Case(s) - if all decisions have been made
 * 
 * Recursive Case - must go through all decisions possible at that point in time
 * 		Choose - choose one decision out of all the options
 * 		Explore - recurse, trying to solve the problem with the choice you just made
 * 		Unchoose - need to undo the choice you made above so that you can try another choice!
 */
public class Drill08 {
    
	
    /* Write a recursive function named canMakeSum that takes a list of
     * integers and an integer target value (sum) and returns true if it is
     * possible to have some set of values from the list that sum to the
     * target value.
     * 
     * For example, the list {2,1,1,3,5} and target value 9 should return true
     * (5 + 3 + 1 = 9).
     * However, the list {5,4,1,6} and target value 8 should return false.
     */
    public static boolean canMakeSum(ArrayList<Integer> list, int sum) {
    	int total = 0;
    	return canMakeSumHelper(list, sum, total, new HashSet<Integer>()).contains(sum);
    }
    
   
    
    
    
    private static Set<Integer> canMakeSumHelper(ArrayList<Integer> list, int sum, int total, Set<Integer> setTotals) {
		if(sum == total) {
			setTotals.add(total);
		} else {
			for(int index = 0; index < list.size(); index++) {
				int valueAt = list.remove(index);
				canMakeSumHelper(list, sum, total+valueAt, setTotals);
				list.add(index, valueAt);
			}
		}
		return setTotals;
	}





	/* Write a recursive function named longestCommonSubsequence that returns the
     * longest common subsequence of two strings. Recall that if a string is a subsequence
     * of another, each of its letters occurs in the longer string in the same order, but
     * not necessarily consecutively.
     * 
     * Some examples:
     *    longestCommonSubsequence("tyler", "kate") -> "te"
     *    longestCommonSubsequence("hannah", "banana") "anna"
     *    longestCommonSubsequence("she sells", "seashells") "sesells"
     *    longestCommonSubsequence("CS210", "arizona") ""
     */
    public static String longestCommonSubsequence(String s1, String s2) {
    	if(s1.length() == 0 || s2.length() == 0) {
    		return "";
    	} else {
    		String longest;
    		String shortest;
    		if(s1.length() > s2.length()) {
    			longest = s1;
    			shortest = s2;
    		} else {
    			longest = s2;
    			shortest = s1;
    		}
    		char curChar = longest.charAt(0);
    		if(curChar == shortest.charAt(0)) {
    			return curChar + longestCommonSubsequence(longest.substring(1), shortest.substring(1));
    		} else {
    			//int x = longestCommonSubsequence(longest.substring(1),shortest).length();
    			//int y = longestCommonSubsequence(longest,shortest.substring(1)).length();
    			if(longestCommonSubsequence(longest.substring(1),shortest).length() > longestCommonSubsequence(longest,shortest.substring(1)).length()){
    				return longestCommonSubsequence(longest.substring(1),shortest);
    			} else {
    				return longestCommonSubsequence(longest,shortest.substring(1));
    			}
    		}
    	}
		
    }
     
    /* Write a recursive function named editDistance that accepts two string
     * parameters and returns the "edit distance" between the two strings as an
     * integer. Edit distance (also called Levenshtein distance) is the minimum
     * number of "changes" required to get from s1 to s2 or vice versa. A "change"
     * is a) inserting a character,
     *    b) deleting a character, or
     *    c) changing a character to a different character.
     *    
     * Some examples:
     *    editDistance("driving", "diving") -> 1
     *    editDistance("debate", "irate") -> 3
     *    editDistance("football", "cookies") -> 6
     */
    public static int editDistance(String s1, String s2) {
			return -1;
    }

}
