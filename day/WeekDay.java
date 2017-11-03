package day;

public class WeekDay extends NumberOfDays {
    private final int referenceYear = 2017;
    private final int referenceMonth = 10;
    private final int referenceDay = 23;
    String[] dayName = new String[8];
    {
	dayName[1] = "Monday";
	dayName[2] = "Tuesday";
	dayName[3] = "Wednesday";
	dayName[4] = "Thursday";
	dayName[5] = "Friday";
	dayName[6] = "Saturday";
	dayName[7] = "Sunday";
    }

    String getDayInWeek(int inputDay, int inputMonth, int inputYear) {
	int sumDays = 0;
	String day = "";
	if (inputYear > referenceYear) {
	    int firstYear = getDaysInFirstYear(referenceDay, referenceMonth, referenceYear);
	    int lastYear = getDaysInLastYear(inputDay, inputMonth, inputYear);
	    int daysBetweenYears = getDaysBetweenYears(referenceYear, inputYear);
	    sumDays = firstYear + lastYear + daysBetweenYears;
	    day = getDayAfterRefDate(sumDays);
	} else if (inputYear < referenceYear) {
	    int firstYear = getDaysInFirstYear(inputDay, inputMonth, inputYear);
	    int lastYear = getDaysInLastYear(referenceDay, referenceMonth, referenceYear);
	    int daysBetweenYears = getDaysBetweenYears(inputYear, referenceYear);
	    sumDays = firstYear + lastYear + daysBetweenYears;
	    day = getDayBeforeRefDate(sumDays);
	} else {
	    int inputDays = getDaysInFirstYear(inputDay, inputMonth, inputYear);
	    int referenceDays = getDaysInFirstYear(referenceDay, referenceMonth, referenceYear);
	    if (inputDays > referenceDays) {
		sumDays = inputDays - referenceDays;
		day = getDayBeforeRefDate(sumDays);
	    } else if (inputDays < referenceDays) {
		sumDays = referenceDays - inputDays;
		day = getDayAfterRefDate(sumDays);
	    } else {
		day = dayName[1];
	    }
	}
	return day;
    }

    String getDayAfterRefDate(int sumOfDays) {
	int dayInWeek = 0;
	for (int i = 1; i <= sumOfDays + 1; i++) {
	    dayInWeek++;
	    if (dayInWeek > 7) {
		dayInWeek = 1;
	    }
	}
	return dayName[dayInWeek];
    }

    String getDayBeforeRefDate(int sumOfDays) {
	int dayInWeek = 1;
	for (int i = sumOfDays; i >= 1; i--) {

	    dayInWeek--;
	    if (dayInWeek < 1) {
		dayInWeek = 7;
	    }
	}
	return dayName[dayInWeek];
    }
}
