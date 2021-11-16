import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;

public class StudyDateTime {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// java.time.CLock
		Clock clock = Clock.systemUTC();
		System.out.println(clock.millis());
		System.out.println(System.currentTimeMillis());

		// java.time.LocalDate
		LocalDate localDate = LocalDate.now();
		int day = localDate.getDayOfMonth();
		int month = localDate.getMonthValue();
		int year = localDate.getYear();
		System.out.println(String.format("%s-%s-%s", year, month, day));
		
		// java.time.ZoneId
		ZoneId zone = ZoneId.of("Europe/London");
		Clock londonClock = Clock.system(zone);
		System.out.println(londonClock.millis());
		System.out.println(System.currentTimeMillis());

		// java.time.LocalDate
		LocalDate londonLocalDate = LocalDate.now();
		int londonDay = londonLocalDate.getDayOfMonth();
		int londonMonth = londonLocalDate.getMonthValue();
		int londonYear = londonLocalDate.getYear();
		System.out.println(String.format("%s-%s-%s", londonYear, londonMonth, londonDay));
	}
}
