package com.javafortesters.stringsrevisited;


import com.javafortesters.domainentities.interim.exceptions.custom.InvalidPassword;
import com.javafortesters.domainentities.interim.exceptions.custom.regex.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserPasswordExceptionsTest {

    @Test(expected = InvalidPassword.class)
    public void passwordMustHaveANumber() throws InvalidPassword {
        User aUser = new User("username", "Password");
    }

    @Test(expected = InvalidPassword.class)
    public void passwordMustHaveAnUppercase() throws InvalidPassword {
        User aUser = new User("username", "1assword");
    }

    @Test (expected = InvalidPassword.class)
    public void passwordMustBeGreaterThan6Chars() throws InvalidPassword {
        User aUser = new User("username", "I23456");
    }

    @Test
    public void multipleUppercaseAndDigitsAllowed() throws InvalidPassword {
        User aUser = new User("username", "I23456T");
        aUser = new User("username", "12B4S6TP");
    }

    @Test
    public void canStilCreateDefaultUser(){
        User aUser = new User();
        assertThat(aUser.getPassword(), is("Passw0rd"));
    }

    @Test
    public void passwordMatches() throws InvalidPassword {

        User aUser = new User("username", "Password2");
        aUser = new User("username", "Pas5word");

        aUser = new User("username", "I1234567");
        aUser = new User("username", "1234S67");
        aUser = new User("username", "123456T");

        aUser = new User("username", "I1234567ten");
    }
}