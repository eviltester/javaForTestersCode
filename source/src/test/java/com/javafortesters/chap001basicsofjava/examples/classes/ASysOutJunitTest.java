package com.javafortesters.chap001basicsofjava.examples.classes;

import org.junit.Test;

public class ASysOutJunitTest {

    @Test
    public void canOutputHelloWorldToConsole(){
        AClassWithAMethod myClass = new AClassWithAMethod();
        myClass.aMethodOnAClass();
    }
}
