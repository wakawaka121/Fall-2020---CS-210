
public class Tester {

    public static void main(String[] args) {
        ListStack<Integer> stack = new ListStack<Integer>();
        // for (int i = 0; i < 15; i++) {
        // stack.push(i);
        // }
        stack.push(11);
        ListStack<Integer> newStack = new ListStack<Integer>(stack);
        // // stack.push(11);
        // // System.out.println(stack.pop());
        // // stack.pop();
        // System.out.println(newStack + "this is NewStack");
        // System.out.println(stack + "this is Stack");
        newStack.pop();
        System.out.println(stack + "this is Stack");
        System.out.println(newStack + "this is NewStack");
        System.out.println(stack.equals(stack));
        System.out.println(stack.equals(newStack));
        System.out.println();
        System.out.println();

        ListQueue<Integer> queue = new ListQueue<Integer>();
        // for (int i = 0; i < 15; i++) {
        // queue.enqueue(i);
        // }
        queue.enqueue(11);
        ListQueue<Integer> newQueue = new ListQueue<Integer>(queue);
        // // stack.push(11);
        // // System.out.println(stack.pop());
        // // stack.pop();
        // System.out.println(newQueue + "this is NewQueue");
        // System.out.println(queue + "this is Queue");
        newQueue.dequeue();
        System.out.println(queue + "this is Queue");
        System.out.println(newQueue + "this is NewQueue");
        System.out.println(queue.equals(queue));
        System.out.println(queue.equals(newQueue));
    }
}
