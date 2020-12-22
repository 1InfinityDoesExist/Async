package Date_Demo.localdate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Date1 {

	public static void main(String[] args) {
		// today
		LocalDate today = LocalDate.now();
		System.out.println(today);
		// tomorrow
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
		LocalDate tom = today.plusDays(1);
		System.out.println(tomorrow);
		System.out.println(tom);
		// yesterday
		LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
		LocalDate yes = today.minusDays(1);
		System.out.println(yesterday);
		System.out.println(yes);
	}
}
