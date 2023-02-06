import java.util.HashSet;
import java.util.Set;

//TODO: Make generic
/*
 * Author: Derek Tominaga
 * File: MyHashMap.java
 * Description: This program contains a generic implementation of a 
 * HashMap. That is backed by a 2D LinkedList. It contains all methods
 * that MyHashMap documentation has. This implementation contains methods to 
 * clear the HashMap, check if a Key or Value exists, check if the HasmMap is empty,
 * get the set of Keys for the HashMap, put/remove and element from the HashMap, 
 * get the size of the HashMap and print out a table of the collisions that may
 * occur when adding elements. Elements are represented as HashNode, and the Table 
 * is represented as ListNodes.  */
public class MyHashMap<K,V> {
	
	/*Inner Private Class:
	 * data: is a HashNode that represent the front of HashNode
	 * LinkedList
	 * 
	 * next: Is a pointer to the next ListNode (bucket) in the
	 * ListNode LinkedList*/
	private class ListNode {
        private HashNode<K,V> data;
        private ListNode next;

        /*Constructor:
         * set data to passed in HashNode
         * set next to passed in ListNode*/
        private ListNode(HashNode<K,V> data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        /*This constructor is not used but put in for style.*/
        public ListNode(HashNode<K,V> data) {
            this(data, null);
        }
        
        /*Zero Argument Constuctor:
         * creates an empty ListNode*/
        public ListNode() {
            this(null, null);
        }
    }
	
	/*
	 * NUM_BUCKETS: is a constant int that
	 * denotes the number of buckets that the elements will 
	 * be hashed into.
	 * 
	 * size: is the number of elements in the HashTable
	 * 
	 * bucketHead: is the head of the LinkedList, which is
	 * a ListNode
	 * 
	 * keySet: is a HashSet of all the keys that are
	 * in the HashMap*/
	private static final int NUM_BUCKETS = 8;
	
	private int size;
	private ListNode bucketHead;
	private Set<K> keySet;
	
	/*Constructor:
	 * Set size to 0 since there are no elements in the HashMap.
	 * Create an zero argument ListNode and assign it as the bucketHead.
	 * Create zero argument ListNodes link their next points to create 
	 * LinkedList of ListNodes that represent the buckets of the HashTable.
	 * Create an empty HashSet of the keySet and assign it to the keySet field. 
	 * */
	public MyHashMap() {
		size = 0;
		ListNode head = new ListNode();
		int bucket = 0;
		bucketHead = head;
		ListNode curr = head;
		while(bucket < NUM_BUCKETS) {
			ListNode newBucket = new ListNode();
			curr.next = newBucket;
			curr = curr.next;
			bucket++;
		}
		Set<K> keySet = new HashSet<K>();
		this.keySet = keySet;
	}
	
	/*This function takes one parameter to create the hash index for
	 * a given key. The hash index is the mode of the hashcode of the
	 * key moded by number of buckets.
	 * return: is an int, that represent the index of the bucket 
	 * the key will be put into
	 * */
	private int hash(K key) {
		int hashCode = key.hashCode();
		int index = hashCode%NUM_BUCKETS;
		return Math.abs(index);
	}
	
	/*This function will clear the HashMap by setting all of the 
	 * ListNodes.data to null.
	 * It will set the size to 0 and create an empty HashSet
	 * and assign it to the keySet field. */
	public void clear() {
		size = 0;
		ListNode curr = bucketHead;
		int bucket = 0;
		while(bucket < NUM_BUCKETS) {
			curr.data = null;
			curr = curr.next;
			bucket++;
		}
		Set<K> keySet = new HashSet<K>();
		this.keySet = keySet;
	}
	
	/*This function takes one parameters which is a key.
	 * returns true if the key is in the HashMap, false if not*/
	public boolean containsKey(K key) {
		return keySet.contains(key);
	}
	
	/*This function takes one parameter which is a value.
	 *The function will loop through the HashMap by looping through
	 *each bucket, and checking each HashNode in the bucket. 
	 *Return true if the value is found in the HashMap.
	 *Otherwise return false.*/
	public boolean containsValue(V value) {
		ListNode curr = bucketHead;
		int bucket = 0;
		while (bucket < NUM_BUCKETS) {
			HashNode<K,V> currNode = curr.data;
			while(currNode != null) {
				if(currNode.getValue().equals(value)) {
					return true;
				} else {
					currNode = currNode.getNext();
				}
			}
			bucket++;
		}
		return false;
	}
	
	/*This function takes one paremeter which is a key.
	 * It will search the HashMap to get the value associated 
	 * with the given key. This is done by determining the hashIndex 
	 * of they key by calling the hash function. Loop through the buckets
	 * till you get to the hashIndex. Then searching trhough the HashNode
	 * LinkedList till you find the HashNode with that key.
	 * Return the value for the specified key when found in HashNode LinkedList.
	 * If key does not exists in the HashMap return null.*/
	public V get(K key) {
		if(this.containsKey(key)) {
			int hashIndex = hash(key);
			int bucket = 0;
			ListNode curr = bucketHead;
			while(bucket != hashIndex) {
				curr = curr.next;
				bucket++;
			}
			/*Create references to the HashNode to travers the LinkedList
			 * and not effect the HashNodes till we need to.*/
			HashNode<K,V> currNode = curr.data;
			HashNode<K,V> currNextNode = currNode.getNext();
			//if they key is fond at head of the HashNode LinkedList
			if(currNode.getKey() == key) {
				return currNode.getValue();
			} else {
				while(currNextNode.getKey() != key) {
					currNode = currNode.getNext();
					currNextNode = currNextNode.getNext();
				}
				return currNextNode.getValue();
			}
		}
		else return null;
	}
	
	/*This function deteremines if the HashMap is empty.
	 * return true if size is 0, false if not*/
	public boolean isEmpty() {
		return size == 0;
	}
	
	/*This function will return the set of keys
	 * that are in the HashMap*/
	public Set<K> keySet(){
		return keySet;
	}
	
	/*This function takes two parameters, a Key and a Value and will insert
	 * them into the HashTable, when collision occur insert as the new head 
	 * of the HashNode LinkedList. When put is called, if the key already exists
	 * in the HashMap update the value associated with that key by calling 
	 * private method replaceValue(K,V). If key does not exists, determine
	 * hashIndex of the key, traverse to that index of the buckets. Create a new
	 * HashNode with corresponding (K,V) pair, set the newNodes next pointer to 
	 * the buckets ListNode.data which is a HashNode, then set the buckets ListNode.data to the newNode.
	 * Return the previous value that was replace when a new HashNode was inserted at
	 * front.
	 * Return null, if the bucket was empty when inserting. 
	 * */
	public V put(K key, V val) {
		if(!this.containsKey(key)) {
			HashNode<K,V> newNode = new HashNode<>(key, val);
			keySet.add(key);
			int hashIndex = hash(key);
			ListNode curr = bucketHead;
			int bucket = 0;
			while(bucket != hashIndex) {
				curr = curr.next;
				bucket++;
			}
			newNode.setNext(curr.data);
			curr.data = newNode;
			size++;
			//ListNode.data is empty, there is no previous value
			if(newNode.getNext() == null) {
				return null;
			} else {
				V previousValue = newNode.getNext().getValue();
				return previousValue;
			}
		} 
		V previousValue = this.replaceValue(key, val);
		return previousValue;
	
	}
	
	/*This function takes one parameter to remove a key and
	 * its associated value from the HashMap. This is done by
	 * determining the hashIndex of the key, traversing to the
	 * corresponding "bucket". Traversing the HashNode LinkedList
	 * till you get to the HashNode that has the key to be removed.
	 * Reassign the pointers of the previous node and the next node to
	 * no longer include the HashNode that had they key we are removing.
	 * Return the value of the key that was removed. 
	 * If they key does not exists in the HashMap return null.  
	 * */
	public V remove(K key) {
		if(this.containsKey(key)) {
			keySet.remove(key);
			V removedValue = this.get(key);
			int hashIndex = hash(key);
			int bucket = 0;
			ListNode curr = bucketHead;
			while(bucket != hashIndex) {
				curr = curr.next;
				bucket++;
			}
			/*Create references to the HashNode to traverse the LinkedList
			 * and not effect the HashNodes till we need to.
			 * currNode and currNextNode both needed to reassign next points
			 * to remove a HashNode*/
			HashNode<K,V> currNode = curr.data;
			HashNode<K,V> currNextNode = currNode.getNext();
			if(currNode.getKey() == key) {
				curr.data = currNode.getNext();
			} else {
				while(currNextNode.getKey() != key) {
					currNode = currNode.getNext();
					currNextNode = currNextNode.getNext();
				}
				currNode.setNext(currNextNode.getNext());
			}
			size--;
			return removedValue;
		}
		return null;
			
	}
	
	/*This function will return the number
	 * of elements in the HashMap*/
	public int size() {
		return size;
	}
	
	/*This function will print a table representation of the buckets, with the
	 * number of collision that occur in each bucket, the keys that exists in
	 * each bucket, and the total number of collision that occurred.
	 * Collision only occur when a bucket has more than 1 element. */
	public void printTable() {
		int totalConflicts = 0;
		ListNode curr = bucketHead;
		int bucket = 0;
		while(bucket < NUM_BUCKETS) {
			HashNode<K,V> currNode = curr.data;
			String keySetString = "[";
			int bucketConflicts = 0;
			while(currNode != null) {
				if(currNode != curr.data) {
					bucketConflicts++;
				}
				keySetString += currNode.getKey() + ", ";
				currNode = currNode.getNext();
			}
			keySetString += "]";
			totalConflicts += bucketConflicts;
			System.out.println("Index " + bucket + ": (" + bucketConflicts + " conflicts), " + keySetString);
			curr = curr.next;
			bucket++;
		}
		System.out.println("Total # of conflicts: " + totalConflicts);
		
	}
	
	/*This function is called to replace an existing key with a new value
	 * when put is called with an pre-existing key.
	 * This is done by determining the hashIndex of they key, traversing
	 * the buckets LinkedList to at the corresponding index. Then traversing 
	 * the HashNode LinkedList till you get to the correspond HashNode with that key.
	 * Then replace that HashNode value with the input value.
	 * Return the previous value that was replaced.  */
	private V replaceValue(K key, V value) {
		int hashIndex = hash(key);
		V previousValue = this.get(key);
		ListNode curr = bucketHead;
		int bucket = 0;
		while(bucket != hashIndex) {
			curr = curr.next;
			bucket++;
		}
		HashNode<K,V> currNode = curr.data;
		while(currNode.getKey() != key) {
			currNode = currNode.getNext();
		}
		currNode.setValue(value);
		return previousValue;
		
	}
}
