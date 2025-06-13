package multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Task implements Runnable{
	
	private int num;
	
	Task(int num){
		this.num = num;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " running task " + num);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

public class FixedThreadPool {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		int corecount = Runtime.getRuntime().availableProcessors();
		System.out.println("Available Core : " + corecount);
		ExecutorService service = Executors.newFixedThreadPool(corecount);
		
		Future[] future = new Future[40];
		
		for(int i = 0 ; i < 40; i++) {
			
			future[i] = service.submit(new Task(i));
			
		}
		
		System.out.println("Initializing shutdown");
		service.shutdown();
		for(Future f : future) {
			f.get();
			System.out.println("Task Completed : " + f.isDone());
		}
		
	}
	
}
