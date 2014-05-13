package com.javafortesters.junit;

import com.javafortesters.classes.AClassWithAMethod;
import org.junit.Test;

public class ASysOutJunitTest {

    @Test
    public void canOutputHelloWorldToConsole(){
        AClassWithAMethod myClass = new AClassWithAMethod();
        myClass.aMethodOnAClass();
    }
}
