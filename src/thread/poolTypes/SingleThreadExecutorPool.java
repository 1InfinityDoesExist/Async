package thread.poolTypes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * If you want task1 to be execute then task 2 then 3, 4, 5 and so on
 */
public class SingleThreadExecutorPool {
	public static void main(String[] args) {
		ExecutorService service = Executors.newSingleThreadExecutor();
		for (int iter = 0; iter < 100; iter++) {
			service.execute(new Task());
		}
		System.out.println("::::I am main thread " + Thread.currentThread().getName());
	}
}
