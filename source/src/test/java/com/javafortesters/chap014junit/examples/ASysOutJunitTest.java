package com.javafortesters.chap014junit.examples;

import com.javafortesters.chap001basicsofjava.examples.classes.AClassWithAMethod;
import org.junit.Test;

public class ASysOutJunitTest {

    @Test
    public void canOutputHelloWorldToConsole(){
        AClassWithAMethod myClass = new AClassWithAMethod();
        myClass.aMethodOnAClass();
    }
}
