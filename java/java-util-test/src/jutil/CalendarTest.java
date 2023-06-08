package jutil;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        Date time = calendar.getTime();
        System.out.println("Current date and time "+time);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // January is 0
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Print the current year, month, and day
        System.out.println("Current year: " + year);
        System.out.println("Current month: " + month);
        System.out.println("Current day: " + day);

        // Create a new GregorianCalendar object representing January 1, 2023
        Calendar gregorianCalendar = new GregorianCalendar(2023, Calendar.APRIL, 18);

        // Print the date represented by the calendar object
        System.out.println("Date: " + calendar.getTime());

        // Get the year, month, and day of the month
        int gregorianCalendarYear = gregorianCalendar.get(Calendar.YEAR);
        int gregorianCalendarMonth = gregorianCalendar.get(Calendar.MONTH) + 1; // January is 0
        int gregorianCalendarDay = gregorianCalendar.get(Calendar.DAY_OF_MONTH);

        // Print the year, month, and day of the month
        System.out.println("Year: " + gregorianCalendarYear);
        System.out.println("Month: " + gregorianCalendarMonth);
        System.out.println("Day of month: " + gregorianCalendarDay);

        // Create a new Calendar.Builder object and set the date to January 1, 2023
        Calendar.Builder builder = new Calendar.Builder().setDate(2023, 0, 1);

        // Build the calendar object
        Calendar buildCalendar = builder.build();

        // Print the date represented by the calendar object
        System.out.println("Date: " + buildCalendar.getTime());

        // Get the year, month, and day of the month
        int buildCalendarYear = buildCalendar.get(Calendar.YEAR);
        int buildCalendarMonth = buildCalendar.get(Calendar.MONTH) + 1; // January is 0
        int buildCalendarDay = buildCalendar.get(Calendar.DAY_OF_MONTH);

        // Print the year, month, and day of the month
        System.out.println("Year: " + buildCalendarYear);
        System.out.println("Month: " + buildCalendarMonth);
        System.out.println("Day of month: " + buildCalendarDay);
    }
}
