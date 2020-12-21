package thread.synchorinization_lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Lock2 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		ReentrantLock lock = new ReentrantLock();
		executor.submit(() -> {
			lock.lock();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		});

		executor.submit(() -> {
			System.out.println("Locked: " + lock.isLocked());
			System.out.println("Held by me: " + lock.isHeldByCurrentThread());
			boolean locked = lock.tryLock();
			System.out.println("Lock acquired: " + locked);
		});

	}

}