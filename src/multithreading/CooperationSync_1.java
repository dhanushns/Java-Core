package multithreading;

class SharedResource{
	
	public int data;
	public boolean isAvailabel = false;
	
	synchronized void produce(int val)  {
		
		while(isAvailabel) {
			try {
				wait();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		data = val;
		isAvailabel = true;
		System.out.println("Produce Data : " + data);
		notify();
	}
	
	synchronized void consume() {
		
		while(!isAvailabel) {
			try {
				wait();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Consume Data : " + data);
		isAvailabel = false;
		notify();
		
	}
	
}

public class CooperationSync_1 {
	
	public static void main(String[] args) {
		
		SharedResource res = new SharedResource();
		
		Thread t1 = new Thread(() -> {
			for(int i  = 0; i < 5; i++) res.produce(i);
		}, "Produce-Thread");
		
		Thread t2 = new Thread(() ->{
			for(int i =  0; i < 5; i++) res.consume();
		}, "Consume-Thread");
		
		t1.start();
		t2.start();
		
	}
	
}
