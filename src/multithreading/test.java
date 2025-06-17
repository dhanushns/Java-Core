package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class work implements Runnable{
	
	String threadName;
	
	work(String threadName){
		this.threadName = threadName;
	}
	
	@Override
	public void run() {
		System.out.println(this.threadName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

public class test {
	
	public static void main(String[] args) {
		
		ThreadPoolExecutor exe = new ThreadPoolExecutor(2,2, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5), new ThreadPoolExecutor.AbortPolicy());
		for(int i = 0;i < 10; i++) {
			exe.submit(new work("Worker -" + (i+1)));
		}
		exe.shutdown();
	}
	
}
