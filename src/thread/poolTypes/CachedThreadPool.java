package thread.poolTypes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * If all threads are busy, then create a new thread for the task
 * and place it in the pool
 * 
 * LifeCycle : If thread is ideal for 60 seconds(no task to execute) then
 * kill the thread
 * 
 * Synchronous queue
 */
public class CachedThreadPool {
	public static void main(String[] args) {

		ExecutorService service = Executors.newCachedThreadPool();
		for (int iter = 0; iter < 100; iter++) {
			service.execute(new Task());
		}
		System.out.println("::::I am main thread " + Thread.currentThread().getName());
	}
}

class Task implements Runnable {
	@Override
	public void run() {
		System.out.println("Thread Name " + Thread.currentThread().getName());
	}
}