package com.javafortesters.unusedCode;


import com.javafortesters.domainentities.interim.exceptions.User;
import org.junit.Test;

public class UserPasswordExceptionsTest {

    /*
    @Test(expected = IllegalArgumentException.class)
    public void passwordMustHaveANumber(){
        User aUser = new User("username", "Password");
    }

    @Test(expected = IllegalArgumentException.class)
    public void passwordMustHaveAnUppercase(){
        User aUser = new User("username", "1assword");
    }
    */

    @Test (expected = IllegalArgumentException.class)
    public void passwordMustBeGreaterThan6Chars(){
        User aUser = new User("username", "I23456");
    }

    /*
    @Test
    public void multipleUppercaseAndDigitsAllowed(){
        User aUser = new User("username", "I23456T");
        aUser = new User("username", "12B4S6TP");
    }
    */

    @Test
    public void passwordMatches(){

        User aUser = new User("username", "Password2");
        aUser = new User("username", "Pas5word");

        aUser = new User("username", "I1234567");
        aUser = new User("username", "1234S67");
        aUser = new User("username", "123456T");

        aUser = new User("username", "I1234567ten");
    }
}