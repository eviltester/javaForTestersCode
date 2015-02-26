package com.javafortesters.chap013moreexceptions.examples;

import com.javafortesters.domainentities.interim.exceptions.custom.InvalidPassword;
import com.javafortesters.domainentities.interim.exceptions.custom.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class customExceptionsTest {

    @Test
    public void canCreateDefaultUserWithoutHandlingException(){
        User aUser = new User();
        assertEquals("username", aUser.getUsername());
        assertEquals("password", aUser.getPassword());
    }

    @Test
    public void haveToCatchIllegalPasswordForParamConstructor(){
        try {
            User aUser = new User("me","wrong");
            fail("An exception should have been thrown");
        } catch (InvalidPassword invalidPassword) {
            assertTrue("The exception was thrown", true);
        }
    }

    @Test(expected = InvalidPassword.class)
    public void propogateIllegalPasswordExpected() throws InvalidPassword {
        User aUser = new User("me", "bad");
    }
}