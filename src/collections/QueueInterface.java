package collections;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class QueueInterface {
	
	public static void main(String[] args) {
		
		Queue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(40);
		pq.add(20);
		pq.add(1);
		System.out.println(pq);
		System.out.println(pq.peek());
		
		Queue<Integer> ad = new ArrayDeque<Integer>();
		ad.add(12);
		ad.add(10);
		System.out.println(ad);
		
		
	}
	
}
