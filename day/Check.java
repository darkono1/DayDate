package day;

import java.util.Scanner;

public class Check {
    private String dateToCheck;
    private int day = 0, month = 0, year = 0;
    private int firstDot, secondDot;
    private boolean isValid = false;

    void CheckValues() {
	Scanner input = new Scanner(System.in);
	do {
	    dateToCheck = input.next();
	    input.nextLine();
	    firstDot = dateToCheck.indexOf(".");
	    secondDot = dateToCheck.lastIndexOf(".");
	    try {
		day = Integer.parseInt(dateToCheck.substring(0, firstDot));
		month = Integer.parseInt(dateToCheck.substring(firstDot + 1, secondDot));
		year = Integer.parseInt(dateToCheck.substring(secondDot + 1, dateToCheck.length()));
		if (!checkDateValues()) {
		    System.out.println("Days in a month 1 to 31, months in a year 1 to 12.");
		    continue;
		}
		isValid = true;

	    } catch (Exception e) {
		System.out.println("Wrong input.Try again.");
	    }
	} while (!isValid);
    }

    boolean checkDateValues() {
	boolean value = true;
	if (!(day >= 1 && day <= 31) || !(month >= 1 && month <= 12) || !(year >= 1604 && year <= 2400))
	    value = false;
	return value;
    }

    int getDay() {
	return day;
    }

    int getMonth() {
	return month;
    }

    int getYear() {
	return year;
    }
}
