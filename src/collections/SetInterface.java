package collections;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetInterface {
	
	public static void main(String[] args) {
		
		Set<Integer> hs = new HashSet<>();
		hs.add(-34);
		hs.add(12);
		hs.add(0);
		hs.add(100);
		System.out.println(hs);
		
		Set<Integer> lhs = new LinkedHashSet<>();
		lhs.add(12);
		lhs.add(0);
		System.out.println(lhs);
		
		Set<Integer> ts = new TreeSet<>();
		ts.add(12);
		ts.add(0);
		System.out.println(ts);
	}

}
