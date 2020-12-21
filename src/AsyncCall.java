import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * If task type is CPU Intensive - pool = count
 * If task type is IO Intensive  - pool = any large number like 1 to 100
 */
public class AsyncCall {
	public static void main(String[] args) {

		// get count of available cores
		int count = Runtime.getRuntime().availableProcessors();
		ExecutorService service = Executors.newFixedThreadPool(count);
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
