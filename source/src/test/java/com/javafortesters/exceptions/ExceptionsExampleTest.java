package com.javafortesters.exceptions;

import com.javafortesters.domainentities.interim.exceptions.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExceptionsExampleTest {

    @Test(expected = NullPointerException.class)
    public void throwANullPointerException(){
        Integer age=null;

        String ageAsString = age.toString();

        String yourAge = "You are " +
                         ageAsString +
                         " years old";

        assertEquals("You are 18 years old",
                     yourAge);

    }


    @Test
    public void catchANullPointerException(){
        Integer age=null;
        String ageAsString;

        try{
           ageAsString = age.toString();

        }catch(NullPointerException e){
            age = 18;
            ageAsString = age.toString();
        }

        String yourAge = "You are " +
                         age.toString() +
                         " years old";

        assertEquals("You are 18 years old",
                     yourAge);
    }


    @Test
    public void catchMultipleExceptions(){
        Integer age=null;
        String ageAsString;

        try{
            ageAsString = age.toString();

        }catch(NullPointerException e){

            age = 18;
            ageAsString = age.toString();

        }catch(IllegalArgumentException e){
            System.out.println("Illegal Argument: " +
                                e.getMessage());
        }

        String yourAge = "You are " +
                age.toString() +
                " years old";

        assertEquals("You are 18 years old",
                yourAge);
    }

    @Test
    public void tryCatchFinallyPseudoCode(){

        try{
            // try and do something

        }catch(NullPointerException e){
            // handle the exception here

        }finally{
            // perform the code here
            // regardless of whether an
            // exception was thrown or not
        }
    }

    @Test
    public void tryCatchFinallyANullPointerException(){
        Integer age=null;
        String ageAsString;
        String yourAge="";

        try{
            ageAsString = age.toString();

        }catch(NullPointerException e){

            age = 18;
            ageAsString = age.toString();

        }finally{

            yourAge = "You are " +
                age.toString() +
                " years old";
        }

        assertEquals("You are 18 years old", yourAge);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exampleTryCatchFinally(){
        Integer age=null;

        try{
            System.out.println("1. generate a null pointer exception");
            System.out.println(age.toString());

        }catch(NullPointerException e){
            System.out.println("2. handle null pointer exception");
            throw new IllegalArgumentException
                      ("Null pointer became Illegal", e);
        }finally{
            System.out.println("3. run code in finally section");
        }
    }

    @Test(expected = NullPointerException.class)
    public void useWrongExceptionNullPointerThrown(){
        Integer age=null;

        String ageAsString;

        try{
            ageAsString = age.toString();

        }catch(ArithmeticException e){
            age = 18;
            ageAsString = age.toString();
        }

        // No need for any code because a NullPointerException
    }


    @Test(expected = NullPointerException.class)
    public void nullPointerExceptionExpected(){
        Integer age=null;
        age.toString();
    }


    @Test
    public void noExceptionThrown(){
        IllegalArgumentException e =
                new IllegalArgumentException("never thrown");
    }

    @Test
    public void useExceptionAsAnObject(){
        Integer age=null;
        String ageAsString;

        try{
            ageAsString = age.toString();

        }catch(NullPointerException e){
            System.out.println("getMessage - " +
                               e.getMessage());
            System.out.println("getStacktrace - " +
                               e.getStackTrace());
            System.out.println("printStackTrace");
            e.printStackTrace();
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void passwordMustBeGreaterThan6Chars(){
        User aUser = new User("username", "I23456");
    }

}