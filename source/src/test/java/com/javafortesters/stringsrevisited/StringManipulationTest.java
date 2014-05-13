package com.javafortesters.stringsrevisited;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringManipulationTest {

    @Test
    public void canUseReplace(){
        String hello = "Hello fella fella fella";

        assertThat( hello.replace("fella", "World"),
                    is("Hello World World World"));

        assertThat( hello.replaceFirst("fella", "World"),
                    is("Hello World fella fella"));

        assertThat( hello.replaceAll("fella", "World"),
                    is("Hello World World World"));

        assertThat("1,2,3".replaceFirst("[0-9]","digit"),
                    is("digit,2,3"));

        assertThat("1,2,3".replaceAll("[0-9]", "digit"),
                    is("digit,digit,digit"));
    }

    @Test
    public void canConvertToUpperCaseAndLowerCase(){
        String text = "In the lower 3rd";

        assertThat( text.toUpperCase(),
                    is("IN THE LOWER 3RD"));

        assertThat( text.toLowerCase(),
                    is("in the lower 3rd"));
    }

    @Test
    public void canTrimAString(){
        String padded = "    trim me    ";
        assertThat(padded.length(), is(15));

        String trimmed = padded.trim();

        assertThat(trimmed.length(), is(7));
        assertThat(trimmed, is("trim me"));
    }

    @Test
    public void canCreateSubStrings(){

        String digits = "0123456789";

        assertThat( digits.substring(5), is("56789"));

        assertThat(digits.substring(5, 6), is("5"));

        assertThat( digits.substring(5,9), is("5678"));

        assertThat( digits.substring(5,digits.length()),
                    is("56789"));

    }

    @Test
    public void canUseStringFormat(){

        int value = 4;
        String output = "The value " + value + " was used";
        assertThat(output, is("The value 4 was used"));

        String template = "The value %d was used";
        String formatted = String.format(template, value);
        assertThat(formatted, is("The value 4 was used"));

        String use = "%s %s towards %d large %s";
        assertThat(
            String.format(use, "Bob", "ran", 6, "onions" ),
            is("Bob ran towards 6 large onions"));

        String txt = "%2$s %4$s towards %3$d large %1$s";
        assertThat(
                String.format(txt, "Bob", "ran", 6, "onions" ),
                is("ran onions towards 6 large Bob"));

        String txt2 = "%1$s %1$s towards %3$d large %1$s";
        assertThat(
                String.format(txt2, "Bob", "ran", 6, "onions" ),
                is("Bob Bob towards 6 large Bob"));
    }

    @Test
    public void canSplitStrings(){
        String csv="1,2,3,4,5,6,7,8,9,10";
        String[] results = csv.split(",");

        assertThat(results.length, is(10));
        assertThat(results[0], is("1"));
        assertThat(results[9], is("10"));
    }


}