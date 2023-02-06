/*
 * Author: Derek Tominaga
 * File: ArrayQueue.java
 * Description: This program implements a Queue that is backed
 * by an Array. It contains all methods in compliance of the QueueInterface:
 * enqueue(int), dequeue(), peek(), isEmpty(), size(), and clear(). This program 
 * also contains 2 Overridden methods: toString() and equals() as well as a copy
 * constructor.
 * */
public class ArrayQueue implements QueueInterface {

    private static final int DEFAULT_CAPACITY = 10;

    private int[] queueArray;
    private int queueTop;
    private int size;

    /*
     * Constructor:
     * queueArray: is an int[] array of size 10 when creating a new instance of
     * ArrayQueue
     * queueTop: is an int value that keeps track of the end of the queue, used
     * when reformatting the queue after a dequeue.
     * size: is an int value that keeps track of the size of the queue
     * initilized at 0
     */
    public ArrayQueue() {
        queueArray = new int[DEFAULT_CAPACITY];
        // -1 cause nothing in the list, so it cant not point to anyting valid
        queueTop = -1;
        size = 0;
    }

    /*
     * Copy Constructor:
     * This constructors copies a passed in ListQueue maintaining all fields
     * of the passed in ArrayQueue
     */
    public ArrayQueue(ArrayQueue copy) {
        queueArray = new int[copy.queueArray.length];
        queueTop = copy.queueTop;
        size = copy.size;
        for (int element = 0; element < size; element++) {
            queueArray[element] = copy.queueArray[element];
        }
    }

    /*
     * This method will be called when the array needs to be large than default
     * capacity since int[] arrays have to be given a size at runtime. It will
     * create a new empty array and assign it to the queueArray field and copy
     * the elements from the original
     */
    private void growArray() {
        int[] newArray = new int[2 * queueArray.length];
        for (int element = 0; element < size; element++) {
            newArray[element] = queueArray[element];
        }
        queueArray = newArray;
    }

    /*
     * Add an element to the back of the queue.
     * and grow if adding an element makes it
     * larger than the length of the queueArray
     * and up date size and queueTop of the queue.
     */
    public void enqueue(int value) {
        if (size <= queueArray.length) {
            growArray();
        }
        queueTop++;
        queueArray[queueTop] = value;
        size++;

    }

    /*
     * Remove and return the front element in the queue.
     * To get the modified Queue after removing from the front of
     * the queue, we must iterate through the original array and
     * shift all elements down by 1 index.
     * 
     * If the user attempts to dequeue from an empty queue, ignore the
     * request (i.e. make no changes to your queue) and return -1.
     */
    public int dequeue() {
        int[] dequeuedArray = new int[queueTop];
        if (size != 0) {
            int dequeuedInt = queueArray[0];
            for (int element = 0; element < queueTop; element++) {
                dequeuedArray[element] = queueArray[element + 1];
            }
            queueArray = dequeuedArray;
            queueTop--;
            size--;
            return dequeuedInt;
        }
        return 0;
    }

    /*
     * Return (but do NOT remove) the front element of the queue.
     * 
     * If the user tries to peek on an empty queue, ignore the
     * request (i.e. make no changes to your queue) and return -1.
     */
    public int peek() {
        if (size != 0) {
            return queueArray[0];
        }
        return -1;
    }

    /*
     * Returns true if the queue has no elements.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * Returns the number of elements in the queue.
     */
    public int size() {
        return size;
    }

    /*
     * Removes all elements from the queue.
     */
    public void clear() {
        queueArray = new int[DEFAULT_CAPACITY];
        queueTop = -1;
        size = 0;

    }

    /*
     * Return a string that represents the queue
     * Build a String by traversing through the queueArray and
     * adding it to to the string.
     * if the queue is empty return an empty stack in the form
     * of {}
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String theQueue = "{";
        /*
         * Traverse to all elements except the top since we have
         * special marker to track top of stack
         */
        for (int element = 0; element < queueTop; element++) {
            theQueue += queueArray[element] + ",";
        }
        // stackTop to get formatting right
        theQueue += queueArray[queueTop] + "}";
        return theQueue;
    }

    /*
     * Return true if the stack is equal to the passed in queue
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ArrayQueue) {
            ArrayQueue theQueue = (ArrayQueue) obj;
            if (size == theQueue.size) {
                for (int element = 0; element < size; element++) {
                    if (queueArray[element] != theQueue.queueArray[element]) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
