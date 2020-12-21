package thread.poolTypes;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * Schedule the tasks to run based on time delay (and retrigger for
 * fixedRate/ fixedDelay)
 * 
 * LifeCycle More threads are created if required
 * 
 * Delay queue
 * 
 * Service.schedule
 * Service.scheduleAtFixedRate
 * Service.scheduleAtFixedDelay
 */
public class ScheduledThreadPool {
	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
		service.schedule(new Task(), 10, TimeUnit.SECONDS);
		service.scheduleAtFixedRate(new Task(), 15, 10, TimeUnit.SECONDS);
		service.scheduleWithFixedDelay(new Task(), 15, 10, TimeUnit.SECONDS);
	}
}
