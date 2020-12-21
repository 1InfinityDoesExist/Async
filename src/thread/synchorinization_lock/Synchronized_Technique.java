package thread.synchorinization_lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/*
 * shared mutable variables
 */
public class Synchronized_Technique {
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.submit(() -> {
			lock.lock();
			try {

				Thread.sleep(1);
				System.out.println("Locked --: " + lock.isLocked());
				System.out.println("Held by me -- : " + lock.isHeldByCurrentThread());
				boolean locked = lock.tryLock();
				System.out.println("Lock acquired --: " + locked);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		});
		/*
		 * While the first task holds the lock for one second the second task obtains
		 * different information about the current state of the lock:
		 */
		executor.submit(() -> {
			System.out.println("Locked: " + lock.isLocked());
			System.out.println("Held by me: " + lock.isHeldByCurrentThread());
			boolean locked = lock.tryLock();
			System.out.println("Lock acquired: " + locked);
		});
	}
}

class Locker {
	ReentrantLock lock = new ReentrantLock();
	int count = 0;

	public void increment() {
		lock.lock();
		try {
			count++;
		} finally {
			lock.unlock();
		}
	}
}
