package multithreading;

import java.util.concurrent.CyclicBarrier;

class Worker extends Thread{
	
	CyclicBarrier barrier;
	
	Worker(CyclicBarrier barrier){
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		
		try {
			
			System.out.println(Thread.currentThread().getName() + " Arrived..");
			barrier.await();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " Completed...!");
		
	}
	
}

public class CooperationSync_3 {
	
	public static void main(String[] args) {
		
		CyclicBarrier barrier = new CyclicBarrier(3);
		
		new Thread(new Worker(barrier),"Thread-1").start();
		new Thread(new Worker(barrier),"Thread-2").start();
		new Thread(new Worker(barrier),"Thread-3").start();
		
	}
	
}
