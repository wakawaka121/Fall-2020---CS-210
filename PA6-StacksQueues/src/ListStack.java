/*
 * Author: Derek Tominaga
 * File: ListStack.java
 * Description: This program implements a Stack that is 
 * backed by a LinkedList. It contains all methods in compliance 
 * of the StackInterface: push(int), pop(), peek(), isEmpty(), 
 * size(), clear(). As well as a copy constructor and 2 Overridden methods:
 * toString() and equals(). The program functions as a normal stack would. */

public class ListStack implements StackInterface {

    private class ListNode {
        private int data;
        private ListNode next;

        private ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        public ListNode(int data) {
            this(data, null);
        }

        public ListNode() {
            this(0, null);
        }
    }

    /*
     * bottom: a ListNode that represent the bottom of the Stack,
     * in terms of a LinkedList this is the front or head of the
     * LinkedList
     * 
     * top: a ListNode that represents the top of the Stack,
     * in terms of a LinkedList this is the tail of the LinkedList
     * 
     * size: an int value that represents the size of the Stack
     */
    private ListNode bottom;
    private ListNode top;
    private int size;
    
    /*
     * Constructor:
     * Set bottom and top to null, since they have no nodes of reference when
     * creatig a new ListStack.
     * Set size to 0 since there are no elements in the Stack.
     */
    public ListStack() {
        bottom = null;
        top = null;
        size = 0;
    }

    /*
     * Copy Constructor:
     * This constructor copies a passed in ListStack maintaining all fields of
     * the passed in ListStack
     */
    public ListStack(ListStack copy) {
        bottom = null;
        top = null;
        size = 0;
        ListNode stackRunner = copy.bottom;
        while (stackRunner != null) {
            this.push(stackRunner.data);
            stackRunner = stackRunner.next;
        }
    }

    /*
     * Add an element to the top of the stack.
     * Create a new node that is to be added to the Stack
     * change the top.next pointer to the new node, then change
     * the top field to the new node and increase the size of the
     * Stack.
     */
    public void push(int value) {
        ListNode nodeToAdd = new ListNode(value);
        if (bottom == null) {
            bottom = nodeToAdd;
            top = nodeToAdd;
            size++;
        } else {
            top.next = nodeToAdd;
            top = nodeToAdd;
            size++;
        }
    }

    /*
     * Remove and return the top element in the stack.
     * 
     * If the user attempts to pop an empty stack, ignore the
     * request (i.e. make no changes to the stack) and return -1.
     * 
     * Assign top.data to a variable.
     * 
     * Then the stack is modified by traversing the LinkList nodes until one
     * before the end of the Stack, then setting the top of the stack to
     * that node, and setting the top.next to null. Then decrement the
     * size of the Stack.
     */
    public int pop() {
        if (size > 1) {
            ListNode current = bottom;
            int popedElement = top.data;
            while (!current.next.equals(top)) {
                current = current.next;
            }
            top = current;
            top.next = null;
            size--;
            return popedElement;
        } else if (size == 1) {
            int popedElement = bottom.data;
            this.clear();
            return popedElement;
        }
        return -1;
    }

    /*
     * Return (but do NOT remove) the top element of the stack.
     * return value is top.data.
     * 
     * If the user attempts to peek on an empty stack, ignore the
     * request (i.e. make no changes to the stack) and return -1
     */
    public int peek() {
        if (size != 0) {
            return top.data;
        }
        return -1;
    }

    /*
     * Returns true if the stack has no elements.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * Returns the number of elements in the stack.
     */
    public int size() {
        return size;
    }

    /*
     * Removes all elements from the stack.
     * By assigning fields to null and 0 which
     * is what the fields should be when we have an empty
     * Stack
     */
    public void clear() {
        bottom = null;
        top = null;
        size = 0;
    }

    /*
     * Return a string that represents the stack
     * Traverse the Stack and build a string based on the stack.data of
     * each of the elements nodes.
     * If the stack is empty return an empty stack in the form
     * {}.
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String theStack = "{";
        ListNode current = bottom;
        if (size == 1) {
            theStack += current.data + "}";
            return theStack;
        }
        while (current.next != null) {
            theStack += current.data + ",";
            current = current.next;
        }
        theStack += top.data + "}";
        return theStack;
    }

    /*
     * Return true if that stack is equals to the passed in stack
     * This is done traversing both Stacks and comparing the stack.data of
     * of each of the elements.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ListStack) {
            ListStack theStack = (ListStack) obj;
            if (size == theStack.size) {
                ListNode theCurrent = theStack.bottom;
                ListNode thisCurrent = bottom;
                while (thisCurrent != null) {
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
