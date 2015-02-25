package com.javafortesters.chap012inheritance.exercises;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReadOnlyUserTest {

    @Test
    public void readOnlyUserPrivsAndDefaults(){

        ReadOnlyUser rod = new ReadOnlyUser();
        assertEquals("ReadOnly", rod.getPermission());
        assertEquals("username", rod.getUsername());
        assertEquals("password", rod.getPassword());
    }
}