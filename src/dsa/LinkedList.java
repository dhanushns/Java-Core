package dsa;


public class LinkedList {
	
	public static void main(String[] args) {
		
		Node root = new Node();
		root.insert(10);
		root.insert(20);
		root.insert(30);
		root.pop();
		root.insertAt(1, 40);
		root.remove(1);
		root.insertAt(0,50);
		root.remove(root.length-1);
		root.display();
		
		
	}
	
}
