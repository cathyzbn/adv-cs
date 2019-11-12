
public class APCalenderHelper {

	public static int numberOfLeapYears(int year1, int year2) {
		int count = 0;
		for(int i = year1; i<=year2; i++) {
			if(isLeapYear(i)) {
				count++;
			}
		}
		return count;
	}
	
	public static int dayOfWeek(int month, int day, int year) {
		int initial = firstDayOfYear(year)-1;
		int daysPassed = dayOfYear(month, day, year);
		int output = (initial + daysPassed)%7;
		return output;
	}
}
