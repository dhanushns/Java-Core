package collections;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Hashtable;

public class MapInterface {
	
	public static void main(String[] args) {
		
		Map<Integer,String> hm = new HashMap<Integer, String>();
		hm.put(4, "Java");
		hm.put(2, "Python");
		System.out.println(hm);
		
		Map<Integer,String> lhm = new LinkedHashMap<Integer, String>();
		lhm.put(4, "Java");
		lhm.put(2, "Python");
		System.out.println(lhm);
		
		Map<Integer,String> tm = new TreeMap<Integer, String>();
		tm.put(4, "Java");
		tm.put(2, "Python");
		System.out.println(tm);
		
		Map<Integer,String> ht = new Hashtable<Integer, String>();
		ht.put(4, "Java");
		ht.put(2, "Python");
		System.out.println(ht); //thread safety
		
	}
	
}
