package com.javafortesters.testswithotherclasses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerExercisesTest {

    @Test
    public void canConfirmIntMinAndMaxLimits(){

        int minimumInt = -2147483648;
        int maximumInt = 2147483647;

        assertEquals("integer min", minimumInt, Integer.MIN_VALUE);
        assertEquals("integer max", maximumInt, Integer.MAX_VALUE);
    }

    @Test
    public void canConvertIntToHex(){
        assertEquals("hex 11 is b", "b",
                Integer.toHexString(11));
        assertEquals("hex 10 is b", "a",
                Integer.toHexString(10));
        assertEquals("hex 3 is b", "3",
                Integer.toHexString(3));
        assertEquals("hex 21 is b", "15",
                Integer.toHexString(21));
    }
}