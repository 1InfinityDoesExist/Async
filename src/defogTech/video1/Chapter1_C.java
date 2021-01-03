package defogTech.video1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Chapter1_C {

	public static void main(String[] args) {
		// create thread pool
		ExecutorService service = Executors.newFixedThreadPool(10);

		// submit the tasks for execution
		for (int iter = 0; iter < 10; iter++) {
			service.execute(new Task());
		}
		System.out.println("Thread Name :" + Thread.currentThread().getName());
		service.shutdown();
	}

	static class Task implements Runnable {

		@Override
		public void run() {
			System.out.println("Thread Name :" + Thread.currentThread().getName());
		}

	}
}
