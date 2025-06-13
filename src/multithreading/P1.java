package multithreading;

class A extends Thread{
	
	public int count;
	
	@Override
	public void run() {
		System.out.println("Thread A executing....");
		for (int i = 1; i <= 5; i++) {
			this.count = i;
            System.out.println("Iteration count : " + i);
            try {
				Thread.sleep(5000); // simulating work
			}catch(Exception e) {
				e.printStackTrace();
			}
        }
	}
	
}

class B extends Thread{
	
	@Override
	public void run() {
		
		for (int i = 0; i < 5; i++) {
            System.out.println("Thread B executing...");
        }
		
	}
	
}

class DaemonMonitor extends Thread{
	
	A objA;
	
	public DaemonMonitor(A objA) {
		this.objA = objA;
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			System.out.println("Deamon Thread Monitoring count : " + objA.count);
			try {
				Thread.sleep(500); // monitors every 500 mili-seconds
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}

public class P1 {
	public static void main(String[] args) {
		
		A objA = new A();
		B objB = new B();
		
		objB.setPriority(Thread.MAX_PRIORITY);
		objA.setPriority(Thread.MIN_PRIORITY);
		
		//objA.start();
		//objB.start();
		System.out.println("Main class");
		System.out.println();
		
		Thread t = new Thread(()->{
			
			while(true) {
				
				try {
					Thread.sleep(5000);
					System.out.println("Autosaving your document ....");
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		//t.setDaemon(true);
		//t.start();
		
//		try {
//			
//			Thread.sleep(25000);			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		//System.out.println("Closing the document!!");
		
		DaemonMonitor monitor = new DaemonMonitor(objA);
		monitor.setDaemon(true);
		objA.start();
		monitor.start();
		
	}
}
