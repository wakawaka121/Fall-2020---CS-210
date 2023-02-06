/*Author:Derek Tominaga
 * File: Drill01.java
 *Description: This program contains methods for Array,List,Sets
 *and Maps that iterate through data structure or gets a value
 *from a data structure.
 **/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Drill01 {
	
	/* -------- Arrays -------- */
	
	/*
	 * Return the item at the index specified by the 
	 * parameter 'index'. Only do this if 'index' exists
	 * in your array. i.e. first check to make sure the
	 * array is big enough to contain such an index. If
	 * the array does not contain this index, return -1.
	 */
	static int getElementAtIndex(int index, int[] array) {
		// TODO: Implement the getElementAtIndex method
		//System.out.println(array.length-1);
		//System.out.println(array[3]);
		if (index <= array.length-1){
			return array[index];
		}
		return -1; 
		
	}
	
	/*
	 * Return the sum of all the values in the given array.
	 */
	static int sumValues(int[] array) {
		// TODO: Implement the sumValues method
		if (array.length > 0) {
			int sumTotal = 0;
			for (int index = 0; index < array.length; index++) {
				sumTotal = sumTotal + array[index];
			}
			return sumTotal;
		}
		return 0;
	}
	
	/*
	 * Return a new array that doubles every element in the 
	 * given array.
	 */
	static int[] doubleElements(int[] array) {
		// TODO: Implement the doubleElements method
		if(array.length > 0) {
			int[] doubleElements;
			doubleElements = new int[array.length];
			for(int index = 0; index < array.length; index++) {
				doubleElements[index] = 2 * array[index];
			}
			return doubleElements;
		}
		return null;
	}
	
	/* -------- Lists -------- */
	
	/*
	 * Return the item at the index specified by the 
	 * parameter 'index'. Only do this if 'index' exists
	 * in your list. i.e. first check to make sure the
	 * list is big enough to contain such an index. If
	 * the list does not contain this index, return -1.
	 */
	static int getElementAtIndex(int index, List<Integer> list) {
		// TODO: Implement the getElementAtIndex method
		if(index <= list.size()-1) {
			return list.get(index);
		}
		return -1;
	}
	
	/*
	 * Return the sum of all the values in the given list.
	 */
	static int sumValues(List<Integer> list) {
		// TODO: Implement the sumValues method
		if (list.size() > 0) {
			int sum = 0;
			for(int index = 0; index < list.size(); index++) {
				sum = sum + list.get(index);
				}
			return sum;
		}
		return 0;
	}
	
	/*
	 * Return a new list that doubles every element in the 
	 * given list.
	 */
	static List<Integer> doubleElements(List<Integer> list) {
		// TODO: Implement the doubleElements method
		if(list.size() > 0) {
			List<Integer> doubleElements = new ArrayList<Integer>();
			for(int index = 0; index < list.size(); index++) {
				doubleElements.add(2*list.get(index));
			}
			return doubleElements;
		}
		return new ArrayList<>();
	}

	/* -------- Sets -------- */
	
	/*
	 * Return whether the given set contains the given value.
	 */
	static boolean setContains(Set<Integer> set, int val) {
		// TODO: Implement the setContains method
		if(set.contains(val)) {
			return true;	
		}
		return false;
	}
	
	/*
	 * Return a new set containing the intersection 
	 * (common elements) of the given sets.
	 */
	static Set<Integer> setIntersection(Set<Integer> set1, Set<Integer> set2) {
		// TODO: Implement the setIntersection method
		if(!set1.isEmpty() && !set2.isEmpty()) {
			Set<Integer> setIntersections = new HashSet<>();
			setIntersections.addAll(set1);
			setIntersections.retainAll(set2);
			return setIntersections;
		}
		return new HashSet<>();
	}
	
	/*  -------- HashMaps -------- */
	
	/*
	 * Given a string, return a map with each character as 
	 * a key and the number of times that character appears 
	 * in the string as the value.
	 */
	static Map<Character, Integer> characterCount(String s) {
		// TODO: Implement the characterCount method
		if(s.length() > 0) {
			Map<Character, Integer> characterCount = new HashMap<Character, Integer>();
			for(int index = 0; index < s.length(); index++) {
				if(!characterCount.containsKey(s.charAt(index))) {
					characterCount.put(s.charAt(index),1);
				}
				else {
					characterCount.put(s.charAt(index), characterCount.get(s.charAt(index)) +1);
				}
			}
			return characterCount;
		}
		return new HashMap<>();
	}
	
	/*
	 * Given a mapping of cities to their population, return the city
	 * with the largest population. If the given map is empty, return 
	 * an empty string.
	 */
	static String largestPopulation(Map<String, Integer> cities) {
		// TODO: Implement the largestPopulation method
		if(!cities.isEmpty()) {
			String largestCity = "";
			int largestPop = 0;
			for(String city : cities.keySet()) {
				int pop = cities.get(city);
				if (pop > largestPop) {
					largestPop = pop;
					largestCity = city;
				}
			}
			return largestCity;
		}
		return "";
	}

}
