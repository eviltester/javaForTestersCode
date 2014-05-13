package com.javafortesters.basicsofjavarevisited;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassExampleTest {

    @Test
    public void bigBadTestForClassExample(){
        assertEquals(ClassExample.CONSTANT,
                    "a constant string");

        assertEquals(ClassExample.aClassField,
                     "a class field");

        ClassExample.aClassField = "new value";

        assertEquals(ClassExample.aClassField,
                "new value");

        ClassExample instance = new ClassExample("bob");

        assertEquals("bob", instance.getName());

        instance.setName("test");

        assertEquals("test", instance.getName());

        assertEquals(instance.aClassField,
                     "new value");

        instance.aClassField = "changed";

        assertEquals(ClassExample.aClassField,
                "changed");

        assertEquals(instance.pubField, "a public field");
        instance.pubField = "amended public field";
        assertEquals(instance.pubField, "amended public field");
    }
}