package com.javafortesters.myfirsttest.exercises;



import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MyFirstTestExercisesTest {

    @Test
    public void canAddTwoPlusTwo(){
        int answer = 2+2;
        assertEquals("2+2=4", 4, answer );
    }

    @Test
    public void canSubtractTwoFromTwo(){
        int answer = 2-2;
        assertEquals("2-2=0", 0, answer );
    }

    @Test
    public void canDivideFourByTwo(){
        int answer = 4/2;
        assertEquals("4/2=2", 2, answer );
    }

    @Test
    public void canMultiplyTwoByTwo(){
        int answer = 2*2;
        assertEquals("2*2=4", 4, answer );
    }
}