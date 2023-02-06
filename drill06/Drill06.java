/*
 * Author: Derek Tominaga
 * File: Drill06.java
 * Description: This program contains methods to
 * test our understanding of a HashNode data structure
 * using generics. It test both our understanding of 
 * singly-linked list and generics.
 * */
public class Drill06 {

    // Given a generic HashNode<K,V> as a parameter 
    // return the value in the HashNode.
    public static <K, V> V returnValue(HashNode<K, V> node) {
        return node.getValue();
    }

    // Given a generic HashNode<K,V> as a parameter
    // return the key in the HashNode.
    public static <K, V> K returnKey(HashNode<K, V> node) {
    	return node.getKey();
    }

    // In the singly-linked list of generic HashNode<K,V>s 
    // that starts with the given node, return the value 
    // in the last node.
    public static <K, V> V findLastVal(HashNode<K, V> first) {
    	HashNode<K,V> curr = first;
        while(curr.getNext() != null) {
        	curr = curr.getNext();
        }
        return curr.getValue();
    }

    // In the singly-linked list of generic HashNode<K,V>s that starts 
    // with the given node, return the indexed node. The first node is
    // index 0, then next index 1, etc.
    public static <K, V> HashNode<K, V> findNodeByIndex(HashNode<K, V> first,
            int index) {
    	int count = 0;
    	HashNode<K,V> curr = first;
    	while(count < index) {
    		curr = curr.getNext();
    		count ++;
    	}
    	return curr;    
    }

    // Count all of the nodes in the given singly-linked list of
    // generic HashNode<K,V>s that starts with the given node.
    public static <K, V> int countNodes(HashNode<K, V> first) {	
    	HashNode<K,V> curr = first;	
    	if(first == null) {
    		return 0;
    	}
    	int count = 1;
        while(curr.getNext() != null) {
        	curr = curr.getNext();
        	count++;
        }
        return count;
    }
}
