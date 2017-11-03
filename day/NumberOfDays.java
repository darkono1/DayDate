package day;

public class NumberOfDays {
    int yearMonths[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    boolean checkLeapYear(int yearValue) {
	boolean isLeapYear = false;
	final int startLeapYear = 1604;
	final int endLeapYear = 2400;
	for (int i = startLeapYear; i < endLeapYear; i += 4) {
	    if (leapCenturyYear(yearValue)) {
		isLeapYear = false;
		break;
	    }
	    if (yearValue == i) {
		isLeapYear = true;
		break;
	    }
	}
	return isLeapYear;
    }

    boolean leapCenturyYear(int year) {
	final int[] notLeapYears = { 1700, 1800, 1900, 2100, 2200, 2300 };
	boolean notLeapYear = false;
	for (int j = 0; j < notLeapYears.length - 1; j++) {
	    if (year == notLeapYears[j])
		notLeapYear = true;
	}
	return notLeapYear;
    }

    int getDaysInFirstYear(int inputDay, int inputMonth, int inputYear) {
	int daysInFirstYear = 0;
	if (checkLeapYear(inputYear) && inputMonth <= 2) {
	    daysInFirstYear += 1;
	}
	for (int i = inputMonth; i < 12; i++) {
	    daysInFirstYear += yearMonths[i + 1];
	}
	daysInFirstYear += (yearMonths[inputMonth] - inputDay);
	return daysInFirstYear;
    }

    int getDaysInLastYear(int endDay, int endMonth, int endYear) {
	int daysInHigherYear = 0;
	if (checkLeapYear(endYear) && endMonth > 2) {
	    daysInHigherYear += 1;
	}
	for (int i = 1; i < endMonth - 1; i++) {
	    daysInHigherYear += yearMonths[i];
	}
	daysInHigherYear += (yearMonths[endMonth - 1] + endDay);
	return daysInHigherYear;
    }

    int getDaysBetweenYears(int startYear, int endYear) {
	int daysBetweenYears = 0;
	for (int checkYear = startYear + 1; checkYear <= endYear - 1; checkYear++) {
	    if (checkLeapYear(checkYear)) {
		daysBetweenYears += 366;
	    } else {
		daysBetweenYears += 365;
	    }
	}
	return daysBetweenYears;
    }
}
