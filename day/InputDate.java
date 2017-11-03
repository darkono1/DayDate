//This program displays the day in the week for a date user enters.
//Date range is between year 1604 and 2400.
package day;

public class InputDate {
    public static void main(String[] args) {
	int inputDay;
	int inputMonth;
	int inputYear;
	System.out.println("Enter date in range between years 1604. and 2400. in following format,for example: 23.11.1994");
	Check date = new Check();
	date.CheckValues();
	inputDay = (date.getDay());
	inputMonth = (date.getMonth());
	inputYear = (date.getYear());
	WeekDay day = new WeekDay();
	System.out.println("Day of the week on the date: " + inputDay + "." + inputMonth + "."
		+ inputYear + " is: " + day.getDayInWeek(inputDay, inputMonth, inputYear));
    }

}