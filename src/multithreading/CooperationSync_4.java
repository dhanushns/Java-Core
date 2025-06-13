package multithreading;

import java.util.concurrent.Semaphore;

class Database{
	
	private Semaphore dbAcess;
	
	public Database(Semaphore semaphore) {
		// TODO Auto-generated constructor stub
		this.dbAcess = semaphore;
	}
	
	public void accessData() {
		
		try {
			
			dbAcess.acquire();
			System.out.println("<=== " + Thread.currentThread().getName() + " Acquired DB Access");
			Thread.sleep(5000);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbAcess.release();
			System.out.println("===> " + Thread.currentThread().getName() + " Released DB Access");
		}
		
	}
	
	
}

public class CooperationSync_4 {
	
	public static void main(String[] args) {
		
		Semaphore semaphore = new Semaphore(3);
		Database db = new Database(semaphore);
		
		for(int i = 1; i <= 6; i++) {
			
			String user = "User-" + i;
			new Thread(()->db.accessData(),user).start();
			
		}
		
	}
	
}
