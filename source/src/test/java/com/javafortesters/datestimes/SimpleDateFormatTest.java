package com.javafortesters.datestimes;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleDateFormatTest {

    @Test
    public void simpleDateFormatExample(){

        System.out.println("|  Pattern    |        Output|");
        System.out.println("|----------   |     ----------|");

        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date(0L);

        sdf.applyPattern("MM/dd/yyyy");
        assertThat(sdf.format(date), is("01/01/1970"));


        String pattern = "MM/dd/yyyy";

        sdf.applyPattern(pattern);
        assertThat(sdf.format(date), is("01/01/1970"));

        System.out.println(String.format(
                            "|\"%s\"  |  \"%s\"|",
                            pattern,
                            sdf.format(date)));

        pattern = "MMM/dd/yyy";
        sdf.applyPattern(pattern);
        assertThat(sdf.format(date), is("Jan/01/1970"));

        System.out.println(String.format(
                "|\"%s\"  |  \"%s\"|",
                pattern,
                sdf.format(date)));

        pattern = "MMMM/d/yy";
        sdf.applyPattern(pattern);
        assertThat(sdf.format(date), is("January/1/70"));

        System.out.println(String.format(
                "|\"%s\"  |  \"%s\"|",
                pattern,
                sdf.format(date)));
    }

    @Test
    public void importantDateFormatPatterns() throws ParseException {


        SimpleDateFormat sdf = new SimpleDateFormat("y M d HH:mm:ss.SSS");
        Date date = sdf.parse("2013 12 15 23:39:54.123");

        String[][] formatElement = {
                {"y", "year"},
                {"yy", "year"},
                {"yyy", "year"},
                {"yyyy", "year"},
                {"yyyyy", "year"},
                {"M", "Month"},
                {"MM", "Month"},
                {"MMM", "Month"},
                {"MMMM", "Month"},
                {"d", "Day in Month"},
                {"dd", "Day in Month"},
                {"ddd", "Day in Month"},
                {"h", "Hour in AM/PM Time"},
                {"hh", "Hour in AM/PM Time"},
                {"hhh", "Hour in AM/PM Time"},
                {"H", "Hour in 24 Hr Time"},
                {"HHH", "Hour in 24 Hr Time"},
                {"m", "Minute in Time"},
                {"mm", "Minute in Time"},
                {"mmm", "Minute in Time"},
                {"s", "Second in Minute"},
                {"ss", "Second in Minute"},
                {"sss", "Second in Minute"},
                {"S", "Milllisecond"},
                {"E", "Week Day Name"},
                {"EEEE", "Week Day Name"},
                {"a", "AM/PM"},
        };

        System.out.println("|Element  |   Description  |  Output|");
        System.out.println("|-------  | -----------  |--------|");

        for(String []details : formatElement){

            sdf.applyPattern(details[0]);
            System.out.println(
                    String.format("|\"%s\" |   %s |  \"%s\"|",
                                    details[0],
                                    details[1],
                                    sdf.format(date)
                                   )
                               );
        }
    }

    @Test
    public void unusualDateFormatPatterns() throws ParseException {


        SimpleDateFormat sdf = new SimpleDateFormat("y M d HH:mm:ss.SSS");
        Date date = sdf.parse("2013 12 15 23:39:54.123");

        String[][] formatElement = {
                {"w", "Week in the year"},
                {"www", "Week in the year"},

                {"W", "Week in the month"},
                {"WW", "Week in the month"},
                {"WWW", "Week in the month"},

                {"D", "Day in the year"},

                {"F", "Day of week in the month"},
                {"FF", "Day of week in the month"},
                {"FFF", "Day of week in the month"},

                {"u", "Day number in the week"},
                {"uu", "Day number in the week"},

                {"k", "Hour in the day (1-24)"},
                {"kkk", "Hour in the day (1-24)"},

                {"H", "Hour in the am/pm (0-11)"},
                {"HHH", "Hour in the am/pm (0-11)"},

                {"z", "General Time Zone"},

                {"Z", "RTC 822 Time Zone"},

                {"X", "ISO 8601 Time Zone"},


        };

        System.out.println("|Element  |   Description  |  Output|");
        System.out.println("|-------  |   -----------  |  --------|");

        for(String []details : formatElement){

            sdf.applyPattern(details[0]);
            System.out.println(
                    String.format("|\"%s\"  |  %s |  \"%s\"|",
                            details[0],
                            details[1],
                            sdf.format(date)
                    )
            );
        }
    }
}