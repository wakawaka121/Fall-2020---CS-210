/*
 * Author: Derek Tominaga
 * File: ListQueue.java
 * Description: This program implements a Generic Queue that is backed
 * by a LinkedList. It contains all methods in compliance of the QueueInterface:
 * enqueue(E), dequeue(), peek(), isEmpty(), size(), and clear(). This program 
 * also contains 2 Overridden methods: toString() and equals() as well as a copy
 * constructor.
 * */
public class ListQueue<E> implements QueueInterface<E> {

    private class ListNode {
        private E data;
        private ListNode next;

        public ListNode(E data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        public ListNode(E data) {
            this(data, null);
        }

        public ListNode() {
            this(null, null);
        }
    }

    /*
     * front: a ListNode that represent the front of the Queue,
     * in terms of a LinkedList this is the front or head of the
     * LinkedList
     * 
     * back: a ListNode that represents the back of the Queue,
     * in terms of a LinkedList this is the tail of the LinkedList
     * 
     * size: an int value that represents the size of the Queue
     */
    private ListNode<E> front;
    private ListNode<E> back;
    private int size;

    /*
     * Constructor:
     * Set bottom and top to null, since they have no nodes of reference when
     * creating a new ListQueue.
     * Set size to 0 since there are no elements in the Queue.
     */
    public ListQueue() {
        front = null;
        back = null;
        size = 0;
    }

    /*
     * Copy Constructor:
     * This constructors copies a passed in ListQueue maintaining all fields
     * of the passed in ListQueue
     */
    public ListQueue(ListQueue<E> copy) {
        super();
        // front = null;
        // back = null;
        // size = 0;
        ListNode<E> queueRunner = copy.front;
        while (queueRunner != null) {
            this.enqueue(queueRunner.data);
            queueRunner = queueRunner.next;
        }

    }

    /*
     * Add an element to the back of the queue.
     * Create a new node that is to be added to the Queue
     * change the back.next pointer to the next node, then change
     * the back field to the new node and increase the size of Queue.
     */
    @Override
    public void enqueue(E value) {
        ListNode<E> nodeToAdd = new ListNode<E>(value);
        if (front == null) {
            front = nodeToAdd;
            back = nodeToAdd;
            size++;
        } else {
            back.next = nodeToAdd;
            back = nodeToAdd;
            size++;
        }
    }

    /*
     * Remove and return the front element in the queue.
     * 
     * If the user attempts to dequeue from an empty queue, ignore the
     * request (i.e. make no changes to your queue) and return null.
     * 
     * Assign font.data to a variable, then change the front field to
     * the front.next pointer. We will now have a reference to a new front
     * of the Queue. Then decrement the size of the Queue.
     */
    @Override
    public E dequeue() {
        if (size != 0) {
            E dequeuedInt = front.data;
            front = front.next;
            size--;
            return dequeuedInt;
        }
        return null;
    }

    /*
     * Return (but do NOT remove) the front element of the queue.
     * return value is front.data.
     * 
     * If the user tries to peek on an empty queue, ignore the
     * request (i.e. make no changes to your queue) and return null.
     */
    @Override
    public E peek() {
        if (size != 0) {
            return front.data;
        }
        return null;
    }

    /*
     * Returns true if the queue has no elements.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * Returns the number of elements in the queue.
     */
    @Override
    public int size() {
        return size;
    }

    /*
     * Removes all elements from the queue.
     * By assigning fields to null and 0 which
     * is what the fields should be when we have an empty
     * Queue.
     */
    @Override
    public void clear() {
        front = null;
        back = null;
        size = 0;
    }

    /*
     * Return a string that represents the queue
     * Traverse the Queue and build a string based on the queue.data of
     * each of the element nodes.
     * If the queue is empty return an empty stack in the form
     * of {}
     */
    @Override
    public String toString() {
        if (front == null) {
            return "{}";
        }
        String theQueue = "{";
        ListNode<E> current = front;
        while (current.next != null) {
            theQueue += current.data + ",";
            current = current.next;
        }
        theQueue += back.data + "}";
        return theQueue;
    }

    /*
     * Return true if the stack is equal to the passed in queue
     * This is done by traversing both Queues and comparing the
     * queue.data of each of the elements nodes.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ListQueue<?>) {
            ListQueue<E> theQueue = (ListQueue) obj;
            if (size == theQueue.size) {
                // the ListQueue that is being checked for equality
                ListNode theCurrent = theQueue.front;
                // the ListQueue that equals is called on.
                ListNode thisCurrent = front;
                while (theCurrent != null) {
                    if (thisCurrent.data != theCurrent.data) {
                        return false;
                    }
                    thisCurrent = thisCurrent.next;
                    theCurrent = theCurrent.next;
                }
                return true;
            }
        }
        return false;
    }
}
