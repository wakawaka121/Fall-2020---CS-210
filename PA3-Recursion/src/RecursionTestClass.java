/*
 * Author: Derek Tominaga
 * File: RecursionTestClass.java
 * Description: This program contains JUnit tests
 * that were made by me to test Recursion.java. The test 
 * cases should be sufficient enough to guarantee that the 
 * functions from Recursion.java are behaving correctly.
 * */
/*
 * This file will hold all of your testcases. Remember, to run all
 * of your tests, right-click on 'RunTests.java' and select 'Run As' ->
 * JUnit Test.
 */
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

public class RecursionTestClass {
	
	/*
	 * Here I have provided an example of one of the tests that I
	 * would write. For each of your tests, leave a brief comment
	 * above the test specifying its purpose. For example, for this
	 * test, I might write, "indexOf_test1 tests when s2 is not a 
	 * substring of s1. This should return -1."
	 */
	
	/* 
	 * These test cases will test indexOf function
	 * @test1: Test s1 = "Hello" s2 = "World"(s1 == s2 in length), s1 != s2, output -1
	 * @test2: Test s1 = "Hello" s2 = "e" s2 that exists in middle of s1, 
	 * output 1
	 * @test3: Test s1 = "Hello" s2 = "o" s2 that exists at end of s1, out 4
	 * @test4: Test s1 = "Hello" s2 = "lo" s2 of length > 1 that exists in s1, output 3
	 * @test5: Test s1 = "Hello" s2 = "h" s2 is in s1 but not equal (upper vs lower case), output -1 
	 * */
    @Test
    public void test_indexOf_test1() {
        int result = Recursion.indexOf("Hello", "World");
        System.out.println("indexOf(Hello, World), got " + result);
        assertEquals(-1, result);
    }
    @Test
    public void test_indexOf_test2() {
        int result = Recursion.indexOf("Hello", "e");
        System.out.println("indexOf(Hello, e), got " + result);
        assertEquals(1, result);
    }
    @Test
    public void test_indexOf_test3() {
        int result = Recursion.indexOf("Hello", "o");
        System.out.println("indexOf(Hello, o), got " + result);
        assertEquals(4, result);
    }
    @Test
    public void test_indexOf_test4() {
        int result = Recursion.indexOf("Hello", "lo");
        System.out.println("indexOf(Hello, lo), got " + result);
        assertEquals(3, result);
    }
    @Test
    public void test_indexOf_test5() {
        int result = Recursion.indexOf("Hello", "h");
        System.out.println("indexOf(Hello, h), got " + result);
        assertEquals(-1, result);
    }
    
    /*
     * These test cases will test removeEvenNumbers function
     * @test1: stack = {0,1,2,3,4,5,6,7,8,9,10} n = 4, should remove 4 even integers
     * return 4 after removeEvenNumbers is run. (covers case where you remove even number of
     * even ints from stack with even numbers > n)
     * @test2: stack = {0,1,2,3,4,5,6,7,8,9,10} n = 0, should remove 0 even integers
     * return 0 after removeEvenNumbers is run. (covers case where n = 0)
     * @test3: stack = {0,1,2,3,4,5,6,7,8,9,10} n = 7, should remove 6 even integers
     * since there are only 6 even integers in the stack
     * return 6 after removeEvenNumbers is run. (cover case that n > number of even ints)
     * @test4: stack = {0,1,2,3,4,5,6,7,8,9,10} n = 5, should remove 5 even integers
     * return 5 after removeEvenNumbers is run. (covers case where you remove odd number of
     * even ints from stack with even numbers > n)
     * */
    @Test
    public void test_removeEvenNumbers_test1() {
    	Stack<Integer> stack = new Stack<Integer>();
    	Stack<Integer> alteredStack = new Stack<Integer>();
    	for (int i = 0; i <= 10; i++) {
    		stack.push(i);
    	}
    	alteredStack.push(0);
    	alteredStack.push(1);
    	alteredStack.push(2);
    	alteredStack.push(3);
    	alteredStack.push(5);
    	alteredStack.push(7);
    	alteredStack.push(9);
    	int result = Recursion.removeEvenNumbers(stack, 4);
    	System.out.println("removeEvenNumbers({0,1,2,3,4,5,6,7,8,9,10},4) " + result);
    	assertEquals(4,result);
    	assertEquals(alteredStack,stack);
    }
    @Test
    public void test_removeEvenNumbers_test2() {
    	Stack<Integer> stack = new Stack<Integer>();
    	Stack<Integer> alteredStack = new Stack<Integer>();
    	for (int i = 0; i <= 10; i++) {
    		stack.push(i);
    		alteredStack.push(i);
    	}
    	int result = Recursion.removeEvenNumbers(stack, 0);
    	System.out.println("removeEvenNumbers({0,1,2,3,4,5,6,7,8,9,10},0) " + result);
    	assertEquals(0,result);
    	assertEquals(alteredStack,stack);
    }
    @Test
    public void test_removeEvenNumbers_test3() {
    	Stack<Integer> stack = new Stack<Integer>();
    	Stack<Integer> alteredStack = new Stack<Integer>();
    	for (int i = 0; i <= 10; i++) {
    		stack.push(i);
    	}
    	alteredStack.push(1);
    	alteredStack.push(3);
    	alteredStack.push(5);
    	alteredStack.push(7);
    	alteredStack.push(9);
    	int result = Recursion.removeEvenNumbers(stack, 7);
    	System.out.println("removeEvenNumbers({0,1,2,3,4,5,6,7,8,9,10},7) " + result);
    	assertEquals(6,result);
    	assertEquals(alteredStack,stack);
    }
    @Test
    public void test_removeEvenNumbers_test4() {
    	Stack<Integer> stack = new Stack<Integer>();
    	Stack<Integer> alteredStack = new Stack<Integer>();
    	for (int i = 0; i <= 10; i++) {
    		stack.push(i);
    	}
    	alteredStack.push(0);
    	alteredStack.push(1);
    	alteredStack.push(3);
    	alteredStack.push(5);
    	alteredStack.push(7);
    	alteredStack.push(9);
    	int result = Recursion.removeEvenNumbers(stack, 5);
    	System.out.println("removeEvenNumbers({0,1,2,3,4,5,6,7,8,9,10},5) " + result);
    	assertEquals(5,result);
    	assertEquals(alteredStack,stack);
    }
    
    /* 
     * These test cases will test evenDigits function
     * @test1: n = 732594, return should be 24 after evenDigits is run.
     * (covers case where n > 0 and has "even" number of digits, where the even digits are
     * in the middle and at the end)
     * @test2: n = -732594, return should be 24 after evenDigits is run.
     * (covers case where n < 0 and has "even" number of digits, where the even digits are
     * in the middle and at the end)
     * @test3: n = 75311, return should be 0 after evenDigis is run.
     * (covers case where n has "odd" number of digits, with no even digits.)
     * @test4: n = 0, return should be 0 after evenDigits is run.
     * (covers case where n = 0, which is only 1 digit that is 0)
     * @test5: n = 725498, return should be 248 after evenDigits is run.
     * (covers case where n has "even" number of digits, three even digits in n,
     * that are in the middle and the end.)
     * @test6: n = 22, should return 22 after evenDigits is run.
     * (covers the case where all digits in n are even.)
     * */
    @Test
    public void test_evenDigits_test1() {
    	int results = Recursion.evenDigits(732594);
    	System.out.println("evenDigits(732594) " + results);
    	assertEquals(24,results);
    	
    }
    @Test
    public void test_evenDigits_test2() {
    	int results = Recursion.evenDigits(-732594);
    	System.out.println("evenDigits(-732594) " + results);
    	assertEquals(24,results);
    }
    @Test
    public void test_evenDigits_test3() {
    	int results = Recursion.evenDigits(75311);
    	System.out.println("evenDigits(75311) " + results);
    	assertEquals(0,results);
    }
    @Test
    public void test_evenDigits_test4() {
    	int results = Recursion.evenDigits(0);
    	System.out.println("evenDigits(0) " + results);
    	assertEquals(0,results);
    }
    @Test
    public void test_evenDigits_test5() {
    	int results = Recursion.evenDigits(725498);
    	System.out.println("evenDigits(725498) " + results);
    	assertEquals(248,results);
    }
    @Test
    public void test_evenDigits_test6() {
    	int results = Recursion.evenDigits(22);
    	System.out.println("evenDigits(22) " + results);
    	assertEquals(22,results);
    }
    
    /*
     * Theses test cases will test repeatStack function
     * @test1: stack = {1,2,3}, should return {1,1,2,2,3,3}
     * (cover case where stack size is odd)
     * @test2: stack = {}, should return {}
     * (cover case where the stack is empty)
     * @test3: stack = {1,1}, should return {1,1,1,1}
     * (cover case where elements are the same in the stack)
     * @test4: stack = {1,2,3,4}, should return {1,1,2,2,3,3,4,4}
     * (covers case where stack size is even)
     * */
    @Test
    public void test_repeatStack_test1() {
    	Stack<Integer> stack = new Stack<Integer>();
    	Stack<Integer> repeatStack = new Stack<Integer>();
    	for (int i = 1; i <= 3; i++) {
    		stack.push(i);
    		repeatStack.push(i);
    		repeatStack.push(i);
    	}
    	Recursion.repeatStack(stack);
    	System.out.println("repatStack([1,2,3]) " + stack);
    	assertEquals(repeatStack,stack);
    	
    }
    @Test
    public void test_repeatStack_test2() {
    	Stack<Integer> stack = new Stack<Integer>();
    	Stack<Integer> repeatStack = new Stack<Integer>();
    	Recursion.repeatStack(stack);
    	System.out.println("repatStack([]) " + stack);
    	assertEquals(repeatStack,stack);
    }
    @Test
    public void test_repeatStack_test3() {
    	Stack<Integer> stack = new Stack<Integer>();
    	Stack<Integer> repeatStack = new Stack<Integer>();
    	stack.push(1);
    	stack.push(1);
    	repeatStack.push(1);
    	repeatStack.push(1);
    	repeatStack.push(1);
    	repeatStack.push(1);
    	Recursion.repeatStack(stack);
    	System.out.println("repatStack([1,1]) " + stack);
    	assertEquals(repeatStack,stack);
    }
    @Test
    public void test_repeatStack_test4() {
    	Stack<Integer> stack = new Stack<Integer>();
    	Stack<Integer> repeatStack = new Stack<Integer>();
    	for (int i = 1; i <=4; i++) {
    		stack.push(i);
    		repeatStack.push(i);
    		repeatStack.push(i);	
    	}
    	Recursion.repeatStack(stack);
    	System.out.println("repatStack([1,2,3,4]) " + stack);
    	assertEquals(repeatStack,stack);
    }
    
    /*
     * This test case is to test evaluate function
     * @test1: q = {(,(,(,1,+,2,),*,(,3,+,1,),),+,(,1,*,(,2,+,2,),),)}
     * return should be 16. This test case is exhaustive enough to cover all cases
     * since we are guaranteed to have "well" formed expression (symmetrical).
     * */
    @Test
    public void test_evaluate_test1() {
    	Queue<Character> q = new LinkedList<Character>();
    	q.add('(');
    	q.add('(');
    	q.add('(');
    	q.add('1');
    	q.add('+');
    	q.add('2');
    	q.add(')');
    	q.add('*');
    	q.add('(');
    	q.add('3');
    	q.add('+');
    	q.add('1');
    	q.add(')');
    	q.add(')');
    	q.add('+');
    	q.add('(');
    	q.add('1');
    	q.add('*');
    	q.add('(');
    	q.add('2');
    	q.add('+');
    	q.add('2');
    	q.add(')');
    	q.add(')');
    	q.add(')');
    	int results = Recursion.evaluate(q);
    	System.out.println("evaluate( (((1+2)*(3+1))+(1*(2+2))) ) " + results);
    	assertEquals(16,results);
    	}
    
    /*
     * These test cases will test doubleElements function
     * @test1: q = {1,2,3}, should return {2,4,6}
     * (cover case of queue size is odd)
     * @test2: q = {0,1,2,3}, should return {0,2,4,6}
     * (covers cases where queue size is even, and shows
     * what would happen if 0 is in the queue.)
     * @test3: q = {-1,-1,-1,-1}, should return {-2,-2,-2,-2}
     * (covers cases where negatives are inside the queue)
     * @test4: q = {}, should return {}
     * (covers case where q is an empty queue)
     * */
    @Test
    public void test_doubleElements_test1() {
    	Queue<Integer> q = new LinkedList<Integer>();
    	Queue<Integer> doubleQ = new LinkedList<Integer>();
    	for(int i = 1; i < 4; i++) {
    		q.add(i);
    		doubleQ.add(2*i);
    	}
    	Recursion.doubleElements(q);
    	System.out.println("doubleElements([1, 2, 3]) " + q);
    	assertEquals(doubleQ,q);
    	
    }
    @Test
    public void test_doubleElements_tes2() {
    	Queue<Integer> q = new LinkedList<Integer>();
    	Queue<Integer> doubleQ = new LinkedList<Integer>();
    	for(int i = 0; i < 4; i++) {
    		q.add(i);
    		doubleQ.add(2*i);
    	}
    	Recursion.doubleElements(q);
    	System.out.println("doubleElements([0, 1, 2, 3]) " + q);
    	assertEquals(doubleQ,q);
    	
    }
    @Test
    public void test_doubleElements_test3() {
    	Queue<Integer> q = new LinkedList<Integer>();
    	Queue<Integer> doubleQ = new LinkedList<Integer>();
    	for(int i = 0; i < 4; i++) {
    		q.add(-1);
    		doubleQ.add(2*(-1));
    	}
    	Recursion.doubleElements(q);
    	System.out.println("doubleElements([-1, -1, -1, -1]) " + q);
    	assertEquals(doubleQ,q);
    	
    }
    @Test
    public void test_doubleElements_test4() {
    	Queue<Integer> q = new LinkedList<Integer>();
    	Queue<Integer> doubleQ = new LinkedList<Integer>();
    	Recursion.doubleElements(q);
    	System.out.println("doubleElements([]) " + q);
    	assertEquals(doubleQ,q);
    	
    }
}
