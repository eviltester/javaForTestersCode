package com.javafortesters.chap014junit.examples;

import org.junit.Assert;
import org.junit.Test;

public class MyFirstAssertDotTest {

    @Test
    public void canAddTwoPlusTwo(){

        int answer = 2+2;
        Assert.assertEquals("2+2=4", 4, answer);
    }
}