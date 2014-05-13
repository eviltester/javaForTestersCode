package com.javafortesters.datestimes;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalendarTest {

    @Test
    public void calendarExploration(){

        Calendar cal = Calendar.getInstance();

        System.out.println(cal.getTime().getTime());
        System.out.println(System.currentTimeMillis());

        System.out.println(cal.toString());

        Calendar sameDate = Calendar.getInstance();
        sameDate.setTime(cal.getTime());
        assertThat(cal.equals(sameDate), is(true));
        assertThat(cal.compareTo(sameDate), is(0));

        System.out.println(cal.getTime().toString());
        Calendar oneWeekFromNow = Calendar.getInstance();
        oneWeekFromNow.setTime(cal.getTime());
        oneWeekFromNow.add(Calendar.DATE,7);
        System.out.println(oneWeekFromNow.getTime().toString());

        assertThat(oneWeekFromNow.after(cal), is(true));
        assertThat(cal.before(oneWeekFromNow), is(true));
        assertThat(cal.compareTo(oneWeekFromNow), is(-1));
        assertThat(oneWeekFromNow.compareTo(cal), is(1));
    }

    @Test
    public void writeCalendarToStringToConsole(){
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.toString());
    }


    @Test
    public void setCalendarFields(){

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR,2013);
        cal.set(Calendar.MONTH, 11);  // starts at 0
        cal.set(Calendar.DAY_OF_MONTH,15);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE,39);
        cal.set(Calendar.SECOND, 54);
        cal.set(Calendar.MILLISECOND, 123);

        cal.set(Calendar.MONTH,Calendar.DECEMBER);

        System.out.println(cal.getTime().toString());

        cal.set(2013, 11, 15);
        cal.set(2013, Calendar.DECEMBER, 15);
        cal.set(2013, 11, 15, 23, 39);
        cal.set(2013, Calendar.DECEMBER, 15, 23,39, 54);

        assertThat(cal.get(Calendar.YEAR), is(2013));

        cal.setTimeInMillis(0L);
        assertThat(cal.get(Calendar.YEAR), is(1970));

        cal.setTime(new Date(0L));
        assertThat(cal.get(Calendar.YEAR), is(1970));

        cal.setWeekDate(2013, 3, Calendar.THURSDAY);
        assertThat(cal.get(Calendar.MONTH), is(Calendar.JANUARY));
        assertThat(cal.get(Calendar.DAY_OF_MONTH), is(17));
    }

    @Test
    public void getCalendarDetails(){
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
    public void getExperimentWithCalendarDetails(){
        Calendar cal = Calendar.getInstance();
        cal.set(2013, Calendar.DECEMBER, 15, 23,39, 54);

        assertThat(cal.get(Calendar.DAY_OF_WEEK), is(1));
        assertThat(cal.get(Calendar.DAY_OF_WEEK), is(Calendar.SUNDAY));
        assertThat(cal.get(Calendar.WEEK_OF_MONTH), is(2));
        assertThat(cal.get(Calendar.WEEK_OF_YEAR), is(50));
        assertThat(cal.get(Calendar.DAY_OF_YEAR), is(349));
    }


    @Test
    public void addDaysToCalendar(){
        Calendar cal = Calendar.getInstance();
        cal.set(2013, Calendar.DECEMBER, 15, 23,39, 54);

        cal.add(Calendar.HOUR_OF_DAY, -1);
        assertThat(cal.get(Calendar.HOUR_OF_DAY), is(22));

        cal.add(Calendar.MINUTE, 10);
        assertThat(cal.get(Calendar.MINUTE), is(49));
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

}