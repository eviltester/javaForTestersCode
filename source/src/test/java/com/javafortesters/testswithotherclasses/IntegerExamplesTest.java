package com.javafortesters.testswithotherclasses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerExamplesTest {

    @Test
    public void integerExploration(){

        Integer four = new Integer(4);
        assertEquals("intValue returns int 4",
                     4, four.intValue());

        Integer five = new Integer("5");
        assertEquals("intValue returns int 5",
                     5, five.intValue());

        Integer six = 6;
        assertEquals("autoboxing assignment for 6",
                      6, six.intValue());
    }


}