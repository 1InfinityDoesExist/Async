package defogTech.video2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Chapter1_A {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		List<Future<Integer>> allFuture = new ArrayList<>();
		for (int iter = 0; iter < 100; iter++) {
			Future<Integer> future = service.submit(new Task());
			allFuture.add(future);
		}
		// 100 futures, with 100 placeholder
		for (int iter = 0; iter < 100; iter++) {
			Future<Integer> future = allFuture.get(iter);

			/*
			 * 
			 */
//			future.cancel(false);
//			future.isCancelled();
//			future.isDone();

			try {
				Integer result = future.get(1, TimeUnit.SECONDS);// blocking
				System.out.println("Result :- " + iter + "-> " + result);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
			}
		}

		service.shutdown();
	}

	static class Task implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			return new Random().nextInt();
		}
	}
}
