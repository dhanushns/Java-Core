package collections;

import java.util.concurrent.ArrayBlockingQueue;

public class Blocking {
	
	public static void main(String[] args) {
		
		ArrayBlockingQueue<Integer> block = new ArrayBlockingQueue<Integer>(10);
		block.add(40);
		block.add(10);
		block.add(5);
		System.out.println(block);
		block.poll();
		System.out.println(block);
		
		String res = "ABABA";
		System.out.println(res.contains("AB"));
		
	}
	
}
