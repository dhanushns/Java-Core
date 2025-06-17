package collections;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import prg.Student;

class MyList<T> extends AbstractList<T>{
	
	private final List<T> internalList;
	
	MyList(Collection<T> collection){
		this.internalList = new ArrayList<>();
		this.internalList.addAll(collection);
	}
	
	MyList(int capacity){
		this.internalList = new ArrayList<>(capacity);
	}
	
	MyList(){
		this.internalList = new ArrayList<>();
	}

	@Override
	public int size() {
		return this.internalList.size();
	}

	@Override
	public T get(int index) {
		
		if(index < 0 || index >= size()) return (T) "--- INVALID INDEX --- ";
		return this.internalList.get(index);
		
	}
	
	public boolean add(T element) {
		if(this.internalList.contains(element)) return false;
		this.internalList.add(0, element);
		return true;
	}
	
	@Override
	public String toString() {
		
		StringBuilder out = new StringBuilder();
		out.append("| index | Element \t \n");
		for(int i = 0 ; i < size(); i++) {
			out.append("| " + i + "\t| " + this.internalList.get(i) + " \t\t \n");
		}
		
		return out.toString();
		
	}
	
	public String deepPrint() {
		
		StringBuilder out = new StringBuilder();
		for(int i = 0; i < size(); i++) {
			
			out.append(this.internalList.get(i));
			out.append("\n--------------------\n");
			
		}
		
		return out.toString();
		
	}
	
	
}

public class CustomeCollections {
	
	public static void main(String[] args) {
		
		MyList<Integer> list = new MyList<>();
		list.add(10);
		list.add(20);
		list.add(40);
		list.add(0, 10);

		System.out.println(list);

		MyList<Student> students = new MyList<>();
		students.add(new Student(1, "Ramesh"));
		students.add(new Student(2, "Suresh"));
		students.add(new Student(3, "Dinesh"));

		System.out.println(students.deepPrint());

		MyList<List<Integer>> li = new MyList<>();
		li.add(List.of(10, 20, 30));
		li.add(List.of(40, 50, 60));

		System.out.println(li);

	}
	
}
