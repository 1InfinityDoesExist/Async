package defogTech.video1;

public class Chapter1_B {
	public static void main(String[] args) {
		for (int iter = 0; iter < 10; iter++) {
			Thread thread = new Thread(new Task());
			thread.start();
		}
		System.out.println("Thread Name : " + Thread.currentThread().getName());
	}

	static class Task implements Runnable {

		@Override
		public void run() {
			System.out.println("Tread Name :" + Thread.currentThread().getName());

		}
	}
}
