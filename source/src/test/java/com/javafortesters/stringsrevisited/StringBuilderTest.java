package com.javafortesters.stringsrevisited;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringBuilderTest {

    @Test
    public void canConstructStringBuilder(){

        StringBuilder builder = new StringBuilder();
        assertThat(builder.capacity(), is(16));
        assertThat(builder.toString().length(), is(0));

        // capacity is space allocated in memory, not the string length
        // StringBuilder will automatically resize
        StringBuilder sblen = new StringBuilder(512);
        assertThat(sblen.capacity(), is(512));
        assertThat(sblen.toString().length(), is(0));

        StringBuilder sb = new StringBuilder("hello");
        assertThat(sb.toString().length(), is(5));
    }

    @Test
    public void quickStringBuilderDemo(){
        StringBuilder builder = new StringBuilder();
        builder.append("Hello There").
                replace(7,11,"World").
                delete(5,7);
        assertThat(builder.toString(), is("HelloWorld"));
    }

    @Test
    public void appendToStringBuilder(){
        StringBuilder builder = new StringBuilder();
        builder.append("> ");
        builder.append(1);
        builder.append(" + ");
        builder.append(2);
        char[] ca = {' ', '=', ' ', '3'};
        builder.append(ca);

        assertThat(builder.toString(), is("> 1 + 2 = 3"));
    }

    @Test
    public void capacitySizeIncreasesAutomaticallyWithAppend(){
        StringBuilder builder = new StringBuilder(5);
        assertThat(builder.capacity(), is(5));
        builder.append("Hello World");
        assertThat(builder.capacity() > 5, is(true));
    }

    @Test(expected=StringIndexOutOfBoundsException.class)
    public void insertOutsideIntoStringBuilderWhichIsEmpty(){
        StringBuilder builder = new StringBuilder();
        builder.insert(5,"Hello");
    }

    @Test
    public void writeATestToInsert(){

        StringBuilder builder = new StringBuilder();
        builder.insert(0,"a");
        assertThat(builder.toString(), is("a"));

        builder.insert(builder.toString().length(),"b");
        assertThat(builder.toString(), is("ab"));

        builder.insert(1,".");
        assertThat(builder.toString(), is("a.b"));
    }

    @Test
    public void insertIntoStringBuilder(){
        StringBuilder builder = new StringBuilder("123890");
        builder.insert(3,"4567");
        assertThat(builder.toString(), is("1234567890"));
    }


    @Test
    public void insertCharArrayIntoStringBuilder(){
        char[] ca = {'.', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder builder = new StringBuilder("abgh");
        builder.insert(2,ca, 3, 4);
        assertThat(builder.toString(), is("abcdefgh"));
    }

    @Test(expected=StringIndexOutOfBoundsException.class)
    public void insertOutsideStringBuilder(){
        StringBuilder builder = new StringBuilder("a");
        builder.insert(2,"Hello");
    }

    @Test
    public void deleteFromStringBuilder(){
        StringBuilder builder = new StringBuilder("abcdefg");
        builder.delete(2,4);
        assertThat(builder.toString(), is("abefg"));
    }

    @Test
    public void deleteSingleCharFromStringBuilder(){
        StringBuilder builder = new StringBuilder("abcdefg");
        builder.deleteCharAt(2);
        assertThat(builder.toString(), is("abdefg"));
    }

    @Test
    public void ensureCapacityForStringBuilder(){
        StringBuilder builder = new StringBuilder("abcdefg");
        builder.ensureCapacity(600);
        assertThat(builder.capacity(), is(600));
        assertThat(builder.toString(), is("abcdefg"));
    }

    @Test
    public void capacityManagementWithTrimToSize(){
        StringBuilder builder = new StringBuilder(600);
        assertThat(builder.capacity(), is(600));

        builder.append("hello");
        assertThat(builder.capacity(), is(600));
        builder.trimToSize();
        assertThat(builder.capacity(), is(5));
    }

    @Test
    public void replaceStringBuilderSubStrings(){
        StringBuilder builder = new StringBuilder("abcdefgh");
        builder.replace(0,4,"12345678");
        assertThat(builder.toString(), is("12345678efgh"));
    }

    @Test
    public void replaceStringBuilderChar(){
        StringBuilder builder = new StringBuilder("012345678");
        builder.setCharAt(5,'f');
        assertThat(builder.toString(), is("01234f678"));
    }

    @Test
    public void reverseStringBuilder(){
        StringBuilder builder = new StringBuilder("0123456789");
        assertThat(builder.reverse().toString(), is("9876543210"));
    }

    @Test
    public void substringStringBuilder(){
        StringBuilder builder = new StringBuilder("0123456789");
        assertThat(builder.substring(3,7), is("3456"));
        assertThat(builder.substring(3), is("3456789"));
    }
}