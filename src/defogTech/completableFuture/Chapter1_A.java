package defogTech.completableFuture;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Chapter1_A {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		Future<Integer> future = service.submit(new Task());
		try {
			Integer result = future.get(); // blocking
			System.out.println("Result from the task is :" + result);
		} catch (final InterruptedException | ExecutionException ex) {
			ex.printStackTrace();
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
