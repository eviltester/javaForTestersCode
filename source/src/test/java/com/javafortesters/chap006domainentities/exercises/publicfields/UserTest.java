package com.javafortesters.chap006domainentities.exercises.publicfields;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void canConstructWithUsernameAndPassword(){
        User auser = new User();
        auser.username = "bob";
        assertEquals("not default username",
                "bob",
                auser.username);
    }

    @Test
    public void canSetNameToInvalidValue(){
        User auser = new User();
        auser.username = "12345£$%$";
        assertEquals("invalid username",
                "12345£$%$",
                auser.username);
    }

}