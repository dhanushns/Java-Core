package multithreading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class CallableExample implements Callable{
	
	@Override
	public Object call() throws Exception{
		
		System.out.println(Thread.currentThread().getName() + " has been started...!");
		Random random = new Random();
		Integer randamNumber = random.nextInt(5);
		Thread.sleep(randamNumber * 2000);
		return randamNumber;
		
	}
	
}

public class CallableAndFuture {
	
	public static void main(String[] args) throws Exception {
		
		FutureTask[] tasks = new FutureTask[5];
		
		for(int i = 0; i < 5; i++) {
			
			Callable callObj = new CallableExample();
			tasks[i] = new FutureTask(callObj);
			Thread t = new Thread(tasks[i],"Thread -" + (i+1));
			t.start();
			
		}
		
		// printing the results of all the thread
		for(int i = 0 ; i < 5; i++) {
			
			System.out.println(tasks[i].get());
			
		}
		
		
	}
	
}
