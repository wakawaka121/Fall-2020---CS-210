
public class testForPA6 {

    public static void main(String[] args) {
        ListQueue queue = new ListQueue();
        for (int i = 0; i < 15; i++) {
            queue.enqueue(i);
        }
        // stack.push(11);
        ListQueue newQueue = new ListQueue(queue);
        // stack.push(11);
        // System.out.println(stack.pop());
        // stack.pop();
        System.out.println(newQueue + "this is NewStack");
        System.out.println(queue + "this is Stack");
        newQueue.dequeue();
        System.out.println(queue + "this is Stack");
        System.out.println(newQueue + "this is NewStack");
        // System.out.println(stack.equals(newStack));
        // ListQueue queue2 = new ListQueue();
        // for (int i = 0; i < 20; i++) {
        // queue1.enqueue(i);
        // if (i < 19) {
        // queue2.enqueue(i);
        // }
        // }
        // ListQueue queue3 = new ListQueue(queue1);
        // queue3.clear();
        // System.out.println(queue1);
        // System.out.println(queue2);
        // // System.out.println(queue1.size());
        // // System.out.println(queue2.equals(queue1));
        // queue2.enqueue(19);
        // queue2.dequeue();
        // // int num = queue2.peek();
        // int num2 = queue2.size();
        // System.out.println(queue1);
        // System.out.println(queue2);
        // // System.out.println(queue2.equals(queue1));
        // // System.out.println(num);
        // System.out.println(queue2.equals(queue1));
        // System.out.println(queue1.size());
        // System.out.println(queue2.size());
        // System.out.println(queue3.isEmpty());

        // ListQueue theQueue = new ListQueue();
        // // ArrayStack secondStack = new ArrayStack(theStack);
        // for (int i = 0; i < 15; i++) {
        // theQueue.enqueue(i);
        // }
        // System.out.println(theQueue);
        // // theQueue.dequeue();
        // theQueue.clear();
        // theQueue.enqueue(1);
        // theQueue.enqueue(123);
        // System.out.println(theQueue);
        //
        //// ListStack secondStack = new ListStack(theStack);
        //// System.out.println(theStack);
        //// System.out.println();
        //// System.out.println(theStack.equals(secondStack));
        //// System.out.println(theStack.peek());
        //// theStack.pop();
        //// theStack.pop();
        //// theStack.pop();
        //// System.out.println(theStack);
        //// theStack.push(12);
        //// System.out.println(theStack.peek());
        //// theStack.push(13);
        //// System.out.println(theStack);
        //// System.out.println(theStack.peek());
        //// System.out.println(theStack.equals(secondStack));
    }
}
