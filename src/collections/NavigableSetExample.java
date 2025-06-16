package collections;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.SequencedMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

public class NavigableSetExample {
	
	public static void main(String[] args) {
		
		NavigableSet<Integer> set = new TreeSet<Integer>();
		set.add(100);
		set.add(10);
		set.add(50);
		System.out.println(set.lower(20));
		
		NavigableMap<Integer,String> map = new TreeMap<Integer,String>();
		Queue<Integer> q = new ArrayDeque<Integer>();
	
	
	}
	
}
