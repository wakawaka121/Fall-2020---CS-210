import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		MaxPQ aQueue = new MaxPQ();
		List<String> ladder1 = new ArrayList<String>();
		List<String> ladder2 = new ArrayList<String>();
		List<String> ladder3 = new ArrayList<String>();
		List<String> ladder4 = new ArrayList<String>();
		aQueue.enqueue(ladder1, 11);
		aQueue.enqueue(ladder2, 122);
		aQueue.enqueue(ladder3, 13);
		aQueue.enqueue(ladder4, 54);
		aQueue.dequeue();
		System.out.println(aQueue);
	}

}
