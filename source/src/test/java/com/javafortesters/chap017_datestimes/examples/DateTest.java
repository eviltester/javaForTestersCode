package com.javafortesters.chap017_datestimes.examples;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DateTest {

    @Test
    public void dateExploration(){

        Date date = new Date();

        Date equivDate1 = new Date();
        Date equivDate2 = new Date(System.currentTimeMillis());
        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());

        Assert.assertEquals(equivDate1, equivDate2);


        System.out.println(new Date().getTime());
        System.out.println(System.currentTimeMillis());

        System.out.println(date.toString());

        long oneWeekFromNowTime = date.getTime();
        oneWeekFromNowTime = oneWeekFromNowTime +
                             (1000 * 60 * 60 * 24 * 7);
        Date oneWeekFromNow = new Date(oneWeekFromNowTime);
        System.out.println(oneWeekFromNow.toString());

        assertThat(oneWeekFromNow.after(date), is(true));
        assertThat(date.before(oneWeekFromNow), is(true));
        assertThat(date.compareTo(oneWeekFromNow), is(-1));
        assertThat(oneWeekFromNow.compareTo(date), is(1));

        Date sameDate = new Date();
        sameDate.setTime(date.getTime());
        assertThat(date.equals(sameDate), is(true));
        assertThat(date.compareTo(sameDate), is(0));
    }

}