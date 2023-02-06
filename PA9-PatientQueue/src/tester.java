
public class tester {
    public static void main(String[] args) {
        PatientQueue aQueue = new PatientQueue();
        // aQueue.enqueue("Tyler", 0);
        // System.out.println(aQueue.toString());
        // aQueue.changePriority("Tyler", 7);
        // System.out.println(aQueue.toString());
        aQueue.enqueue("Anat", 4);
        System.out.println(aQueue.toString());
        aQueue.enqueue("Ben", 9);
        System.out.println(aQueue.toString());
        aQueue.enqueue("Sasha", 8);
        System.out.println(aQueue.toString());
        aQueue.enqueue("Wu", 7);
        System.out.println(aQueue.toString());
        aQueue.enqueue("Rein", 6);
        System.out.println(aQueue.toString());
        aQueue.enqueue("Ford", -2);
        System.out.println(aQueue.toString());
        aQueue.enqueue("Eve", 3);
        System.out.println(aQueue.toString());
        aQueue.dequeue();
        // System.out.println(aQueue.toString());
        // System.out.println(aQueue.toString());
        // aQueue.changePriority("Eve", 10);
        System.out.println(aQueue.toString());
        System.out.println(aQueue.peek());
    }
}
