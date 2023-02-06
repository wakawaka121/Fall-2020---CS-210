import java.util.List;

/*
 * Author: Derek Tominaga
 * Descripton: This utility class is a priority queue backed by a binary Max heap.
 * It contains an inner class Link that is a ladder, which are the connective links 
 * that may lead to a desired destination web page. It has methods to add an element to 
 * the queue with a given priority, sort the queue to assure it is in binary max haep order, a way to
 * remove from the queue, a way to get the size of the array and if the array is empty or not. The swap method
 * is used to swap elements to put the max heap into appropriate order.
 */
public class MaxPQ {
	private static final int DEFAULT_CAPACITY = 10;
	private static final int FRONT = 1;
	
	private Link[] pQueue;
	private int numInQ;
	
	/*This inner class makes a Link object that contains the List of links, and an priority integer. 
	 **/
	private class Link {
		
		public List<String> listOfLinks;
		public int priority;
		
		/*Constructor:
		 * Takes two parameters to creat a new Link object.
		 * listOfLinks: set to list
		 * priority: set to priority*/
		private Link(List<String> list, int priority) {
			this.listOfLinks = list;
			this.priority = priority;
		}
		/*Creates a String of the Link object in human readable format. of the form
		 *Return: a string of the list and its priority*/
		public String toString() {
			return listOfLinks + " (" + priority + ")";
		}
	}
	
	/*Construtor
	 * Creates a new instance of the MaxPQ
	 * PQueue: is set to an empty array of size 10(9 elements) 
	 * numInQ: is set to 0, represents number of items in the queue*/
	public MaxPQ() {
		pQueue = new Link[DEFAULT_CAPACITY];
		numInQ = 0;
	}
	
	/*This methods is used to grow the size of the array so that it can hold more elements.
	 * This is done by creating a new array of double the size of the original. Then copying all
	 * the elements from the original to larger array. Set the pQueue to the new larger array.*/
	private void growArray() {
		Link[] newArray = new Link[2*pQueue.length];
		for(int link = 1; link <= numInQ; link++) {
			newArray[link] = pQueue[link];
		}
		pQueue = newArray;
	}
	
	/*
     * This method takes two parameters to add an element to the array.
     * It creates a new Link object with the list and priority input, then
     * adds that elements to the queue, but putting it add the end of the array and
     * bubbling up, so that the element are in appropriate order. Then increase
     * numInQ by 1.
     * list: is a list of links on a web page
     * priority: is an int value that represents the number of links that the list object 
     * has with the end page were are trying to get to. 
     */
	public void enqueue(List<String> list, int priority) {
		Link newLink = new Link(list, priority);
		this.enqueue(newLink);
	}
	
	/*
     * This function takes one parameter to add it to the array.
     * This is done by adding it as the last element of the array
     * and then bubbling down, and increase the numInQ field by 1.
     * Link: is a Link object that is being added to the queue.
     * 
     */
	public void enqueue(Link link) {
		try {
			if(numInQ == pQueue.length-1) {
				growArray();
			}
			if(numInQ == 0) {
				pQueue[FRONT] = link;
				numInQ++;
			} else {
				numInQ++;
				pQueue[numInQ] = link;
				bubbleUp(numInQ);
			}
		} catch(Exception e) {
			throw new NullPointerException("Invalid Entry");
		}
	}
	
	/*
     * This function takes no parameters to remove the first element in the
     * queue.
     * and return the List of links. Then reorganize the queue by moving
     * last element to front and bubbling down so that the queue is in proper
     * order of a max priority queue.
     * Return: a list of string that are the possible links from a page.
     * exception error if empty.
     */
	public List<String> dequeue() {
		try {
			Link toBeRemoved = pQueue[FRONT];
			pQueue[FRONT] = pQueue[numInQ];
			pQueue[numInQ] = null;
			numInQ--;
			if(numInQ >0) {
				bubbleDown(FRONT);
			}
			return toBeRemoved.listOfLinks;
		} catch (Exception e) {
			throw new NullPointerException("The queue is empty");
		}
	}
	
	/*
     * This function takes no parameter it will return
     * true of there are no Link objects in the queue
     */
	public boolean isEmpty() {
		return numInQ == 0;
	}
	
	/*
     * This function takes no parameter and returns
     * the number of elements in the queue.
     */
	public int size() {
		return numInQ;
	}
	
	/*This function is used by bubbleUp or bubbleDown, when changeing the position of 
	 * elements in the queue to be in the form of binary max heap.*/
	private void swap(int fromIndex, int toIndex) {
		Link tempSwapHolder = pQueue[fromIndex];
		pQueue[fromIndex] = pQueue[toIndex];
		pQueue[toIndex] = tempSwapHolder;
	}
	
	/*This method is called when enqueue an element to the array. Inorder to put the array in priority max
	 * start at the index and check its parent to ensure the priority of the parent is larger than the priority
	 * of the element at currentIndex. Call swap when there is a need to modify the queue.*/
	private void bubbleUp(int startIndex) {
		int curIndex = startIndex;
		int parentIndex = curIndex/2;
		while(curIndex != FRONT && pQueue[curIndex].priority >= pQueue[parentIndex].priority) {
			swap(parentIndex,curIndex);
			curIndex = parentIndex;
			parentIndex = curIndex/2;
		}
	}
	/*This function is used when bubblingDown to determine which of the children
	 * will be swaped with.
	 * Return: is an int value that is the index that will be swaped. */
	private int childPriorityMin(int child1, int child2) {
		if(pQueue[child1].priority >= pQueue[child2].priority) {
			return child1;
		} else {
			return child2;
		}
	}
	
	/*This function takes one parameter that is an Index value. This function is called after
	 * and element has been dequeued and you sort the array back into binary max heap, ensuring that
	 * the first element in the pQueue has the largest priority.
	 *  */
	private void bubbleDown(int startIndex) {
		int curIndex = startIndex;
		int child1 = startIndex*2;
		int child2 = child1+1;
		if(child1 > numInQ) {
			return;
		} else if (pQueue[child1] !=null && pQueue[child2] != null) {
			int indexToSwap = childPriorityMin(child1,child2);
			if(pQueue[curIndex].priority < pQueue[indexToSwap].priority) {
				swap(indexToSwap,curIndex);
				bubbleDown(indexToSwap);
			}
		} else if (pQueue[child1] != null && pQueue[child2] == null) {
			if(pQueue[curIndex].priority < pQueue[child1].priority) {
				swap(child1,curIndex);
				bubbleDown(child1);
			}
		}
	}
	
	/*This method will traverse the elements in the pQueue and create a 
	 * string that is in human readable format.
	 * Return: string that represent the pQueue.*/
	public String toString() {
		if(this.isEmpty()) {
			return "{}";
		}
		String pqString = "{";
		for(int link =1; link < numInQ; link++) {
			pqString += pQueue[link].toString() + ", ";
		}
		pqString += pQueue[numInQ].toString() + "}";
		return pqString;
	}
}
