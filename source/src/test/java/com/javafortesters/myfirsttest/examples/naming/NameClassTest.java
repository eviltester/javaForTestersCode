package com.javafortesters.myfirsttest.examples.naming;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NameClassTest {

    @Test
    public void whenClassHasTestAtEndThenTestIsRun(){
        // this test will run from maven so it needs to pass
        assertTrue("whenClassHasTestAtEndThenTestIsRun",
                    true);
    }
}
