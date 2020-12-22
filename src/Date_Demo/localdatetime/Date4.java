package Date_Demo.localdatetime;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

public class Date4 {
	public static void main(String[] args) {

		// today
		LocalDateTime today = LocalDateTime.now();
		System.out.println("Today is : " + today);

		LocalDateTime birthday = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
		DayOfWeek dayOfWeek = birthday.getDayOfWeek();
		System.out.println("Day is " + dayOfWeek);

		// Month
		Month month = birthday.getMonth();
		System.out.println("Month is :" + month);
	}
}
