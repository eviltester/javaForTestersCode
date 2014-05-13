package com.javafortesters.stringsrevisited;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringsRevisitedTest {

    @Test
    public void aStringLiteralIsAnObject(){
        assertThat("hello".length(), is(5));
    }


    @Test
    public void canOutputStringsToTheConsole(){
        int i=4;
        System.out.println("Print an int to the console " + i);
    }

    @Test
    public void canUseEscapeSequencesInAString(){
        System.out.println("Bob said \"hello\" to his cat's friend");
        System.out.println("This is a single backslash \\");
    }


    @Test
    public void tryUsingTheOtherEscapeCharactersOutputToConsole(){
        String firstLine = "|first line\n";
        String secondLine = "|\tsecond line\n";
        String thirdLine = "|\t\tthird line\n";
        String fullLine = firstLine + secondLine + thirdLine;
        System.out.println(fullLine);
    }

    @Test
    public void canConcatenateStringsInDifferentWays(){
        String thisIs = "This is ";
        String s1 = thisIs.concat("String1");
        assertThat(s1, is("This is String1"));

        String s2 = thisIs + "String2";
        assertThat(s2, is("This is String2"));
    }

    @Test
    public void canConvertToStrings(){
        String intConcatConvert = "" + 1;
        assertThat(intConcatConvert, is("1"));

        String integerIntConvert = Integer.toString(2);
        assertThat(integerIntConvert, is("2"));

        String integerStringConvert = String.valueOf(3);
        assertThat(integerStringConvert, is("3"));
    }

    @Test
    public void canConvertFromStrings(){
        assertThat(Integer.valueOf("2"), is(2));

        char[] cArray = {'2','3'};
        assertThat("23".toCharArray(), is(cArray));
    }

    @Test
    public void canConstructStrings(){

        String empty = new String();
        assertThat(empty.length(), is(0));

        char[] cArray = {'2','3'};
        assertThat(new String(cArray), is("23"));
        assertThat(new String(cArray, 1, 1), is("3"));

        byte[] bArray = "hello there".getBytes();
        assertThat(new String(bArray, 3, 3), is("lo "));

        byte[] b8Array = new byte[0];
        try {
            b8Array = "hello there".getBytes("UTF8");
            assertThat(new String(b8Array, 3, 3, "UTF8"), is("lo "));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String hello = new String("hello" + " " + "there");
        assertThat(hello, is("hello there"));
    }


    @Test
    public void canConvertBytesUTF8() throws UnsupportedEncodingException {
        byte[] b8Array = "hello there".getBytes("UTF8");
    }
}