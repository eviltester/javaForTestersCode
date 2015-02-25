package com.javafortesters.chap015stringsrevisited.exercises;


import com.javafortesters.domainentities.interim.exceptions.custom.InvalidPassword;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class UserPasswordExceptionsTest {

    @Test(expected = InvalidPassword.class)
    public void passwordMustHaveANumber() throws InvalidPassword {
        User aUser = new User("username", "Password");
        fail("User creation should have thrown an exception");
    }

    @Test(expected = InvalidPassword.class)
    public void passwordMustHaveAnUppercase() throws InvalidPassword {
        User aUser = new User("username", "1assword");
        assertEquals("1assword", aUser.getPassword());
    }

    @Test (expected = InvalidPassword.class)
    public void passwordMustBeGreaterThan6Chars() throws InvalidPassword {
        User aUser = new User("username", "I23456");
        assertEquals("I23456", aUser.getPassword());
    }

    @Test
    public void multipleUppercaseAndDigitsAllowed() throws InvalidPassword {
        User aUser = new User("username", "I23456T");
        assertEquals("I23456T", aUser.getPassword());

        aUser = new User("username", "12B4S6TP");
        assertEquals("12B4S6TP", aUser.getPassword());
    }

    @Test
    public void canStillCreateDefaultUser(){
        User aUser = new User();
        assertThat(aUser.getPassword(), is("Passw0rd"));
    }

    @Test
    public void validPasswordMatchExamples() throws InvalidPassword {

        User aUser = new User("username", "Password2");
        assertEquals("Password2", aUser.getPassword());

        aUser = new User("username", "Pas5word");
        assertEquals("Pas5word", aUser.getPassword());

        aUser = new User("username", "I1234567");
        assertEquals("I1234567", aUser.getPassword());

        aUser = new User("username", "1234S67");
        assertEquals("1234S67", aUser.getPassword());

        aUser = new User("username", "123456T");
        assertEquals("123456T", aUser.getPassword());

        aUser = new User("username", "I1234567ten");
        assertEquals("I1234567ten", aUser.getPassword());
    }
}