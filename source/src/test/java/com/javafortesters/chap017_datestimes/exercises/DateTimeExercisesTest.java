package com.javafortesters.chap017_datestimes.exercises;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DateTimeExercisesTest {

    @Test
    public void nanoTime(){
        long startTime = System.nanoTime();

        for(int x=0; x < 10; x++){
            System.out.println("Current Time " + System.nanoTime());
        }

        long endTime = System.nanoTime();
        System.out.println("Total Time " + (endTime - startTime));
    }

    @Test
    public void createAUniqueUserIDAllChars(){

        String initialUserID = "user" + System.currentTimeMillis();
        System.out.println(initialUserID);

        String userID = initialUserID;

        for(int x = 0; x< 10; x++){
            String charReplacement = "" + ((char)('A'+x));
            String intToReplace = String.valueOf(x);
            userID = userID.replace( intToReplace, charReplacement);
        }

        assertThat(userID.contains("0"), is(false));
        assertThat(userID.contains("1"), is(false));
        assertThat(userID.contains("2"), is(false));
        assertThat(userID.contains("3"), is(false));
        assertThat(userID.contains("4"), is(false));
        assertThat(userID.contains("5"), is(false));
        assertThat(userID.contains("6"), is(false));
        assertThat(userID.contains("7"), is(false));
        assertThat(userID.contains("8"), is(false));
        assertThat(userID.contains("9"), is(false));

        assertThat(initialUserID.length(), is(userID.length()));

        System.out.println(userID);
    }

    @Test
    public void writeCalendarToStringToConsole(){
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.toString());
    }

    @Test
    public void useOtherCalendarConstants(){
        Calendar cal = Calendar.getInstance();

        cal.set(2013, Calendar.DECEMBER, 15, 23,39, 54);
        assertThat(cal.get(Calendar.MONTH), is(Calendar.DECEMBER));
        assertThat(cal.get(Calendar.YEAR), is(2013));
        assertThat(cal.get(Calendar.DAY_OF_MONTH), is(15));
        assertThat(cal.get(Calendar.HOUR_OF_DAY), is(23));
        assertThat(cal.get(Calendar.MINUTE), is(39));
        assertThat(cal.get(Calendar.HOUR), is(11));
        assertThat(cal.get(Calendar.AM_PM), is(Calendar.PM));
    }


    @Test
    public void experimentWithCalendarConstants(){
        Calendar cal = Calendar.getInstance();
        cal.set(2013, Calendar.DECEMBER, 15, 23, 39, 54);


        assertThat(cal.get(Calendar.DAY_OF_WEEK), is(1));
        assertThat(cal.get(Calendar.DAY_OF_WEEK), is(Calendar.SUNDAY));
        assertThat(cal.get(Calendar.DAY_OF_YEAR), is(349));

        // week of month depends on first day of week
        // some places use SUNDAY as first day
        // set to MONDAY for our calculation
        // and control Minimal Days in First Week
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setMinimalDaysInFirstWeek(6);
        assertThat(cal.get(Calendar.WEEK_OF_MONTH), is(2));

        // Week of the year, similarly requires the
        // config to control first day
        assertThat(cal.get(Calendar.WEEK_OF_YEAR), is(50));
    }

    @Test
    public void incrementAndDecrementOtherFields(){
        Calendar cal = Calendar.getInstance();
        cal.set(2013, Calendar.DECEMBER, 15, 23,39, 54);

        cal.add(Calendar.YEAR,-2);
        cal.add(Calendar.MONTH, -6);
        cal.add(Calendar.DAY_OF_MONTH, -12);

        assertThat(cal.get(Calendar.YEAR), is(2011));
        assertThat(cal.get(Calendar.MONTH), is(Calendar.JUNE));
        assertThat(cal.get(Calendar.DAY_OF_MONTH), is(3));

        cal.set(2013, Calendar.DECEMBER, 15, 23,39, 54);

        // bump it forward to 3rd June 2014,
        // then pull it back
        cal.add(Calendar.DAY_OF_MONTH, 19);
        cal.add(Calendar.MONTH, 5);
        cal.add(Calendar.YEAR,-3);

        assertThat(cal.get(Calendar.YEAR), is(2011));
        assertThat(cal.get(Calendar.MONTH), is(Calendar.JUNE));
        assertThat(cal.get(Calendar.DAY_OF_MONTH), is(3));
    }

    @Test
    public void rollCalendar(){
        Calendar cal = Calendar.getInstance();
        cal.set(2013, Calendar.DECEMBER, 15, 23,39, 54);

        cal.roll(Calendar.DAY_OF_MONTH,17);

        assertThat(cal.get(Calendar.YEAR), is(2013));
        assertThat(cal.get(Calendar.MONTH), is(Calendar.DECEMBER));
        assertThat(cal.get(Calendar.DAY_OF_MONTH), is(1));

        cal.set(2013, Calendar.DECEMBER, 15, 23,39, 54);

        cal.add(Calendar.DAY_OF_MONTH,17);
        assertThat(cal.get(Calendar.YEAR), is(2014));
        assertThat(cal.get(Calendar.MONTH), is(Calendar.JANUARY));
        assertThat(cal.get(Calendar.DAY_OF_MONTH), is(1));
    }
}