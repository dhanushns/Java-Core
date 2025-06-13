package multithreading;

class BankAccount {
    private int balance = 1000;

    synchronized void withdraw(int amount) {  // Synchronized Method
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
            balance -= amount;
            System.out.println("Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient balance for " + Thread.currentThread().getName());
        }
    }
    
    
    public void deposite(int amount) {
    	
    	System.out.println("Deopsiting the amount...!");
    	synchronized (this) {   // Synchronized block
    		this.balance += amount;
		}
    	
    }	
}

public class P2 {
	
	public static void main(String[] args) {
		
		BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> account.withdraw(600), "User-1");
        Thread t2 = new Thread(() -> account.withdraw(600), "User2");

        t1.start();
        t2.start();
		
	}
	
}
