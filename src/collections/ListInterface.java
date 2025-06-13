package collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Stack;
import java.util.LinkedList;

public class ListInterface {
	
	public static void main(String[] args) {
		
		List<Integer> al = new ArrayList<>();
		al.add(12);
		al.add(20);
		al.add(30);
		al.remove((Object)20);
		System.out.println(al);
		
		List<Integer> v = new Vector<>();
		v.add(20);
		v.add(12);
		v.removeFirst();
		System.out.println(v); //Thread Safety
		
		List<Integer> ll = new LinkedList<>();
		ll.add(21);
		ll.addFirst(20);
		System.out.println(ll);
		
		List<Integer> stack = new Stack<>();
		stack.add(12);
		stack.add(20);
		System.out.println(stack);
	}
	
}
