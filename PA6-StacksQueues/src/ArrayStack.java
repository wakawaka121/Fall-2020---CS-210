/*
 * Author: Derek Tominaga
 * File: ArrayStack.java
 * Description: This program implements a Stack that is 
 * backed by an Array. It contains all methods in compliance 
 * of the StackInterface: push(int), pop(), peek(), isEmpty(), 
 * size(), clear(). As well as a copy constructor and 2 Overridden methods:
 * toString() and equals(). The program functions as a normal stack would. */
public class ArrayStack implements StackInterface {

    private static final int DEFAULT_CAPACITY = 10;

    private int[] stackArray;
    private int stackTop;
    private int size;

    /*
     * Constructor:
     * stackArray: is an int{} array of size 10 by when creating a new instance
     * of an ArrayStack
     * stackTop: is an int value that keeps track of the top of the stack, used
     * for poping
     * from the top of the stack. This field will change as the stack changes.
     * size: is an int value that keeps track of the size of the stack,
     * initilized at 0
     */
    public ArrayStack() {
        stackArray = new int[DEFAULT_CAPACITY];
        // -1 cause nothing is in the list so it can not point to anything valid
        stackTop = -1;
        size = 0;

    }

    /*
     * Copy Constructor:
     * This constructor copies a passed in ArrayStack maintaining all fields of
     * the passed in ArrayStack
     */
    public ArrayStack(ArrayStack copy) {
        stackArray = new int[copy.stackArray.length];
        size = copy.size;
        stackTop = copy.stackTop;
        for (int element = 0; element < size; element++) {
            stackArray[element] = copy.stackArray[element];
        }

    }

    /*
     * This method will be called when the array needs to be large than default
     * capacity since int[] arrays have to be given a size at runtime. It will
     * create a new empty array and assign it to the stackArray field and copy
     * the elements from the original
     */
    private void growArray() {
        int[] newArray = new int[2 * stackArray.length];
        for (int element = 0; element < size; element++) {
            newArray[element] = stackArray[element];
        }
        stackArray = newArray;
    }

    /*
     * Add an element to the top of the stack.
     * and grow if adding an element makes it larger than
     * the length of the stackArray
     * and update size and stackTop of the stack.
     */
    public void push(int value) {
        if (size <= stackArray.length) {
            growArray();
        }
        stackTop++;
        stackArray[stackTop] = value;
        size++;

    }

    /*
     * Remove and return the top element in the stack.
     * 
     * If the user attempts to pop an empty stack, ignore the
     * request (i.e. make no changes to the stack) and return -1.
     */
    public int pop() {
        if (size != 0) {
            int popedInt = stackArray[stackTop];
            stackTop--;
            size--;
            return popedInt;
        }
        return -1;
    }

    /*
     * Return (but do NOT remove) the top element of the stack.
     * 
     * If the user attempts to peek on an empty stack, ignore the
     * request (i.e. make no changes to the stack) and return -1.
     */
    public int peek() {
        if (size != 0) {
            return stackArray[stackTop];
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
     */
    public void clear() {
        stackArray = new int[size];
        stackTop = -1;
        size = 0;

    }

    /*
     * Return a string that represents the stack
     * Build a String by traversing through the stackArray and
     * adding it to the string.
     * if the stack is empty return an empty stack in the form
     * {}.
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String theStack = "{";
        /*
         * Traverse to all elements except the top since we have
         * special marker to track top of stack
         */
        for (int element = 0; element < stackTop; element++) {
            theStack += stackArray[element] + ",";
        }
        // stackTop to get formatting right
        theStack += stackArray[stackTop] + "}";
        return theStack;
    }

    /* Return true if that stack is equals to the passed in stack */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ArrayStack) {
            ArrayStack theStack = (ArrayStack) obj;
            if (size == theStack.size) {
                for (int element = 0; element < size; element++) {
                    if (stackArray[element] != theStack.stackArray[element]) {
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
