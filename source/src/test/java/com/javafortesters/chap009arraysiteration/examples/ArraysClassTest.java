package com.javafortesters.chap009arraysiteration.examples;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArraysClassTest {

    String[] workdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    @Test
    public void sortArrayOfString(){
        String[] outOfOrder = {"one","Two", "three", "Four", "five"};

        Arrays.sort(outOfOrder);

        for(int i=0; i<outOfOrder.length-1; i++){
            assertTrue("compareTo returns -1 if string is 'less' than comparison",
                    outOfOrder[i].compareTo(outOfOrder[i + 1]) < 0);
        }
    }


    @Test
    public void sortArrayOfInt(){
        int[] outOfOrder = {2,4,3,1,5,0};

        Arrays.sort(outOfOrder);

        assertEquals(0, outOfOrder[0]);
        assertEquals(1, outOfOrder[1]);
        assertEquals(2, outOfOrder[2]);
        assertEquals(3, outOfOrder[3]);
        assertEquals(4, outOfOrder[4]);
        assertEquals(5, outOfOrder[5]);

        for(int i=0; i<outOfOrder.length; i++){
            assertEquals(i, outOfOrder[i]);
        }
    }

    @Test
    public void fillAnArray(){

        int[] minusOne = new int[30];
        Arrays.fill(minusOne,-1);

        for(int arrayInt : minusOne){
            assertEquals(-1, arrayInt);
        }
    }

    @Test
    public void fillPartOfAnArray(){
        int[] tenItems = {0,0,0,0,0,1,1,1,1,1};

        // fill cells 5 - 9 with '2'
        Arrays.fill(tenItems,5,10,2);

        // 0 - 4 are untouched
        assertEquals(0, tenItems[0]);
        assertEquals(0, tenItems[4]);

        // 5 - 9 now equal 2
        assertEquals(2, tenItems[5]);
        assertEquals(2, tenItems[6]);
        assertEquals(2, tenItems[7]);
        assertEquals(2, tenItems[8]);
        assertEquals(2, tenItems[9]);
    }

    @Test
    public void copyOfRange(){

        String[] weekDays = Arrays.copyOfRange(workdays, 2, 5);

        assertEquals(3, weekDays.length);
        assertEquals("Wednesday", weekDays[0]);
        assertEquals("Thursday", weekDays[1]);
        assertEquals("Friday", weekDays[2]);

        assertEquals(weekDays[0], workdays[2]);
        assertEquals(weekDays[1], workdays[3]);
        assertEquals(weekDays[2], workdays[4]);
    }

    @Test
    public void copyOfRangeResize(){
        String[] weekDays = Arrays.copyOfRange(workdays, 2, 7);

        assertEquals(5, weekDays.length);
        assertEquals("Wednesday", weekDays[0]);
        assertEquals("Thursday", weekDays[1]);
        assertEquals("Friday", weekDays[2]);
        assertEquals(null, weekDays[3]);
        assertEquals(null, weekDays[4]);
        assertEquals(weekDays[0], workdays[2]);
        assertEquals(weekDays[1], workdays[3]);
        assertEquals(weekDays[2], workdays[4]);
    }


    @Test
    public void integerArrayDefaultsOnIncrease(){

        int[] ints = {1, 2, 3};

        int[] five = Arrays.copyOf(ints,5);
        assertEquals(3, five[2]);
        assertEquals(0, five[3]);
    }

    @Test
    public void arraysCopyOfAndResize(){

        String[] weekDays;
        weekDays = Arrays.copyOf(workdays, 7);

        weekDays[5] = "Saturday";
        weekDays[6] = "Sunday";

        String days="";
        for(String day: weekDays){
            days = days + "|" + day;
        }

        assertEquals(7, weekDays.length);
        assertEquals("|Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday",days);
    }

    @Test
    public void arraysCopyOfAndResizeEmpty(){
        String[] weekDays;
        weekDays = Arrays.copyOf(workdays, 7);

        assertEquals(null, weekDays[5]);
        assertEquals(null, weekDays[6]);

        String days="";
        for(String day: weekDays){
            days = days + "|" + day;
        }

        assertEquals(7, weekDays.length);
        assertEquals("|Monday|Tuesday|Wednesday|Thursday|Friday|null|null",days);
    }

    @Test
    public void arraysCopyOfAndTruncate(){
        String[] weekDays;
        weekDays = Arrays.copyOf(workdays, 3);

        assertEquals(3, weekDays.length);
        assertEquals("Monday", weekDays[0]);
        assertEquals("Tuesday", weekDays[1]);
        assertEquals("Wednesday", weekDays[2]);
    }

    @Test
    public void arraysCopyOfSameSize(){
        String[] weekDays;

        weekDays = Arrays.copyOf(workdays, workdays.length);

        String days="";
        for(String day: weekDays){
            days = days + "|" + day;
        }

        assertEquals(5, weekDays.length);
        assertEquals("|Monday|Tuesday|Wednesday|Thursday|Friday",days);
    }
}