package com.javafortesters.myfirsttest.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MyFirstTestDifferentAsserts {

    @Test
    public void canAddTwoPlusTwo(){
        int answer = 2+2;
        assertEquals(4, answer );
    }
}