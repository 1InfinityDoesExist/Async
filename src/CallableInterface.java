import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableInterface {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService service = Executors.newFixedThreadPool(10);
		for (int iter = 0; iter < 100; iter++) {
			Future<Integer> future = service.submit(new TaskDemo());

			/*
			 * 
			 */

			future.cancel(false);
			future.isCancelled();
			future.isDone();
			Integer value = future.get(1, TimeUnit.SECONDS);
			System.out.println(value);
		}

		System.out.println("::::I am main thread " + Thread.currentThread().getName());
	}
}

class TaskDemo implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return new Random().nextInt();
	}

}
