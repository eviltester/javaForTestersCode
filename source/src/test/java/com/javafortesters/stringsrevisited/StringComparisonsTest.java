package com.javafortesters.stringsrevisited;

import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringComparisonsTest {

    @Test
    public void canCompareToString(){
        String hello = "Hello";
        assertThat(hello.compareTo("Hello"), is(0));

        assertThat(hello.compareTo("hello") < 0, is(true));
        assertThat(hello.compareTo("Helloo") < 0, is(true));
        assertThat(hello.compareTo("Hemlo") < 0, is(true));

        assertThat(hello.compareTo("H") > 0, is(true));
        assertThat(hello.compareTo("Helln") > 0, is(true));
        assertThat(hello.compareTo("HeLlo") > 0, is(true));

        assertThat(hello.compareToIgnoreCase("hello"), is(0));
        assertThat(hello.compareToIgnoreCase("Hello"), is(0));
        assertThat(hello.compareToIgnoreCase("HeLlo"), is(0));
    }

    @Test
    public void canCheckContainsOnString(){
        String hello = "Hello";
        assertThat(hello.contains("He"), is(true));
        assertThat(hello.contains("Hello"), is(true));

        assertThat(hello.contains("he"), is(false));

        assertThat(hello.contains("z"), is(false));
        assertThat(hello.contains("world"), is(false));
        assertThat(hello.contains("Helloo"), is(false));
    }

    @Test
    public void canCheckContentEquals(){
        String hello = "Hello";
        assertThat(hello.contentEquals("Hello"), is(true));
        assertThat(hello.contentEquals("hello"), is(false));

        assertThat(hello.equalsIgnoreCase("hello"), is(true));
    }

    @Test
    public void canCheckEndsWithStartsWith(){
        String hello = "Hello";
        assertThat(hello.endsWith("Hello"), is(true));
        assertThat(hello.endsWith(""), is(true));
        assertThat(hello.endsWith("lo"), is(true));

        assertThat(hello.startsWith("Hello"), is(true));
        assertThat(hello.endsWith(""), is(true));
        assertThat(hello.startsWith("He"), is(true));

        assertThat(hello.startsWith("he"), is(false));
        assertThat(hello.startsWith("Lo"), is(false));
    }

    @Test
    public void canCheckEmpty(){

        String empty = "";
        assertThat(empty.isEmpty(), is(true));
        assertThat(empty.length(), is(0));

        String notEmpty = " ";
        assertThat(notEmpty.isEmpty(), is(false));
        assertThat(notEmpty.length(), is(1));
    }

    @Test
    public void canFindIndexOf(){
        /*
         "Hello fella"
          01234567890
         */
        String hello = "Hello fella";

        assertThat(hello.indexOf("l"), is(2));
        assertThat(hello.lastIndexOf("l"), is(9));

        assertThat(hello.indexOf('l',3), is(3));
        assertThat(hello.indexOf("l",4), is(8));

        assertThat(hello.lastIndexOf('l',8), is(8));
        assertThat(hello.lastIndexOf("l",7), is(3));


        assertThat(hello.indexOf('z'), is(-1));
        assertThat(hello.lastIndexOf("z"), is(-1));
    }


    @Test
    public void checkRegionMatches(){

        String hello = "Hello fella";
        hello.regionMatches(true, 3,"fez",0,2);

        hello.regionMatches(true, 3,"lady",0,2);
        hello.regionMatches(true, 3,"young lady",6,2);

        hello.regionMatches(true, 3,"fel",0,2);
    }

    @Test
    public void exerciseUseRegionMatches(){
        String hello = "Hello fella";
        hello.regionMatches(true, 3,"young lady",6,2);
    }

}