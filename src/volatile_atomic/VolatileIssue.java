package volatile_atomic;

public class VolatileIssue extends Thread {
	private boolean flag = true;

	public void run() {
		System.out.println("Presentation Started ");
		while (flag) {
			try {
				System.out.println("Present for 3 second by : " + Thread.currentThread().getName());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Presentation Stopped ");
	}

	public void stopThread() {
		this.flag = false;
	}

	public static void main(String[] args) throws Exception {
		VolatileIssue v = new VolatileIssue();
		v.start();
		Thread.sleep(3000);
		System.out.println("Going to close the presentation by : " + Thread.currentThread().getName());
		v.stopThread();
	}
}
