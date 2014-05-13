package com.javafortesters.basicsofjavarevisited;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VariablesTest {

    @Test
    public void variableNaming(){
        String $aString="bob";
        float £owed=10F;
        int aMount=4;
        long Amount=5;
        String A0123456789bCd$f="ugh";

        assertEquals(4,aMount);
        assertEquals(5, Amount);
        assertEquals(10.0F, £owed, 0);
        assertEquals("bob", $aString);
        assertEquals("ugh", A0123456789bCd$f);
    }
}