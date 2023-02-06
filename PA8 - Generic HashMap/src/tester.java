import java.util.Set;

public class tester {

	public static void main(String[] args) {
		MyHashMap<Integer, Integer> map = new MyHashMap<>();
		map.put(1, 2);
		map.put(2, 3);
		map.put(3, 4);
		map.put(5, 6);
		map.put(7, 8);
		map.put(8, 9);
		int ex = map.get(1);
		System.out.println(ex);
		System.out.println(map.containsValue(9));
		System.out.println(map.keySet());
		map.printTable();
		System.out.println(map.size());
		map.printTable();
	}

}
