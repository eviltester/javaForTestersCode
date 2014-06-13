package com.javafortesters.myfirsttest.examples.naming;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NameTestClass {

    @Test
    public void whenClassHasTestInMiddleThenTestIsNotRun(){
        // this test will not run from maven so i can make
        // a failing test... it fails in the IDE
        assertTrue("whenClassHasTestInMiddleThenTestIsNotRun",
                    false);
    }
}
