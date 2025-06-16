package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(10);
		arr.add(20);
		arr.add(30);
		
		for(int n : arr) {
			//if( n == 30) arr.add(40); // will throw concurrent modification error
		}
		
		// to handle the above error
		List<Integer> list = new CopyOnWriteArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		
		for(int n : list) {
			if( n == 30) list.add(40);
		}
		
		System.out.println(list);
		
	}
	
}
