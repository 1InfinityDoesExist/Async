package thread.poolTypes;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutDown {
	public static void main(String[] args) throws InterruptedException {

		// get count of available cores
		int count = Runtime.getRuntime().availableProcessors();
		ExecutorService service = Executors.newFixedThreadPool(count);
		for (int iter = 0; iter < 100; iter++) {
			service.execute(new Task());
		}

		// initiate shutdown
		service.shutdown();

		// will throw RejectionExectutionException
		// service.execute(new Task())
		// will return true, since shutdown has begun
		service.isShutdown();

		/*
		 * will return true if all the task are completed including the queued ones
		 */
		service.isTerminated();

		/*
		 * block until all tasks are completed or if timeout occurs.
		 */
		service.awaitTermination(10, TimeUnit.SECONDS);

		/*
		 * will initiate shutdown and return all queued task.
		 */
		List<Runnable> runnables = service.shutdownNow();

		System.out.println("::::I am main thread " + Thread.currentThread().getName());
	}
}

class TaskD implements Runnable {
	@Override
	public void run() {
		System.out.println("Thread Name " + Thread.currentThread().getName());
	}
}
