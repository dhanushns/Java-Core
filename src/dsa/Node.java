package dsa;

public class Node {
	
	int data;
	Node head;
	Node next;
	int length = 0;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
	
	Node(){}
	
	boolean isEmpty() {
		
		return head == null;
		
	}
	
	private void count() {
		
		if(!isEmpty()) {
			int countNode = 0;
			Node node = head;
			while(node != null) {
				countNode++;
				node = node.next;
			}
			this.length = countNode;
			
		}
		
	}
	
	void insert(int data) {
		
		Node newNode = new Node(data);
		if(isEmpty()) {
			head = newNode;
		}
		else {
			Node node = head;
			while(node.next != null) {
				node = node.next;
			}
			node.next = newNode;
		}
		count();
//		System.out.println("New node inserted");
	}
	
	void insertAt(int pos, int data) {
		
		if(isEmpty() || pos > this.length) {
			System.out.println("Empty node / index out of bounds");
			return;
		}
		else {
			Node node = head;
			int curr_pos = 0;
			
			Node newNode = new Node(data);
			
			if(pos == 0) {
				newNode.next = head;
				head = newNode;
				this.length++;
				return;
			}
			
			while(node != null) {
				
				if(curr_pos == pos-1) {
					
					Node temp = node.next;
					node.next = newNode;
					newNode.next = temp;
					this.length++;
					return;
					
				}
				node = node.next;
				curr_pos++;
				
			}
		}
		
	}
	
	void display() {
		
		if(isEmpty()) {
			System.out.println("Empty Node");
			return;
		}
		else {
			
			Node node = head;
			while(node != null) {
				System.out.print(node.data + " ");
				node = node.next;
			}
			
		}
		
	}
	
	void pop() {
		
		if(isEmpty()) {
			System.out.println("Empty Node");
			return;
		}
		else {
			Node node = head;
			while(node != null) {
				if(node.next != null) {
					if(node.next.next == null) {
						node.next = null;
						this.length--;
						return;
					}
				}
				node = node.next;
			}
			
		}
		
	}
	
	void remove(int pos) {
		
		if(isEmpty()) {
			System.out.println("Empty Node");
			return;
		}
		else {
			Node node = head;
			int curr_pos = 0;
			while(node != null) {
				if(curr_pos == pos-1) {
					if(node.next.next != null) {
						node.next = node.next.next;
						this.length--;
						return;
					}
					else {
						node.next = null;
						this.length--;
						return;
					}
				}
				curr_pos++;
				node = node.next;
			}
		}
		
	}
	
}
