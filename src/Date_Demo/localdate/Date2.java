package Date_Demo.localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Date2 {
	public static void main(String[] args) {
		// Get Day
		LocalDate independentDay = LocalDate.of(2014, Month.JULY, 10);
		DayOfWeek dayOfWeeek = independentDay.getDayOfWeek();
		System.out.println(dayOfWeeek);

		// Format
		DateTimeFormatter german = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
		LocalDate birthday = LocalDate.parse("24.11.2015", german);
		System.out.println(birthday);
	}

}
