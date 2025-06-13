package multithreading;

import java.util.concurrent.locks.ReentrantLock;

class Database1 {
    private final ReentrantLock lock = new ReentrantLock();

    void updateData() {
        try {
            lock.lockInterruptibly(); // Allows interruption while waiting
            System.out.println(Thread.currentThread().getName() + " acquired lock for DB update.");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted while waiting for lock.");
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
                System.out.println("Lock Released by " + Thread.currentThread().getName());
            }
        }
    }
}

public class LockInterruptiblyExample {
    public static void main(String[] args) {
        Database1 db = new Database1();
        Thread t1 = new Thread(db::updateData, "Worker-1");
        Thread t2 = new Thread(db::updateData, "Worker-2");

        t1.start();
        t2.start();

        try {
            Thread.sleep(1000);
            t2.interrupt(); // Interrupt thread waiting for the lock
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
