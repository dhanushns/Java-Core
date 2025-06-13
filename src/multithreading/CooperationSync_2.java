package multithreading;

import java.util.concurrent.CountDownLatch;

public class CooperationSync_2 {

	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch latch = new CountDownLatch(2);
		
		Thread t1 = new Thread(()->{
			System.out.println(Thread.currentThread().getName());
			latch.countDown();
		});
		
		Thread t2 = new Thread(()->{
			System.out.println(Thread.currentThread().getName());
			latch.countDown();
		});

		t1.start();
		t2.start();
		
		latch.await();
		System.out.println("All thread completed...!");

	}

}
