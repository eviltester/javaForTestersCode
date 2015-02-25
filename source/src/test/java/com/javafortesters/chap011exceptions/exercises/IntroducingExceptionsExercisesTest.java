package com.javafortesters.chap011exceptions.exercises;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntroducingExceptionsExercisesTest {

    @Test
    public void noLongerThrowANullPointerException(){
        Integer age=18;

        String ageAsString = age.toString();

        String yourAge =
                "You are " + ageAsString + " years old";

        assertEquals("You are 18 years old", yourAge);
    }

    @Test(expected = NullPointerException.class)
    public void catchADifferentException(){

        Integer age=null;
        String ageAsString;

        try{
            ageAsString = age.toString();

        }catch(ArithmeticException e){
            age = 18;
            ageAsString = age.toString();
        }

        String yourAge =
                "You are " + age.toString() + " years old";

        assertEquals("You are 18 years old", yourAge);
    }

    @Test(expected = NullPointerException.class)
    public void testNotFixedStillThrowsNullPointer(){

        Integer age=null;
        String ageAsString;

        try{
            ageAsString = age.toString();

        }catch(ArithmeticException e){
            //age = 18;
            ageAsString = age.toString();
        }

        String yourAge =
                "You are " + age.toString() + " years old";

        assertEquals("You are 18 years old", yourAge);
    }

    /*
    @Test
    public void thisTriggersASyntaxErrorBecauseExceptionIsNotDeclared(){

        Integer age=null;
        String ageAsString;

        try{
            ageAsString = age.toString();

        }catch(NoSuchMethodException e){
            age = 18;
            ageAsString = age.toString();
        }

        String yourAge =
                "You are " + age.toString() + " years old";

        assertEquals("You are 18 years old", yourAge);
    }
    */

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

    @Test
    public void useExceptionAsAnObjectExtendedForGetStackTrace(){
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

            System.out.println("Stack Trace Length - " +
                                e.getStackTrace().length);
            System.out.println("Stack Trace [0] classname - " +
                                e.getStackTrace()[0].getClassName());
            System.out.println("Stack Trace [0] filename - " +
                                e.getStackTrace()[0].getFileName());
            System.out.println("Stack Trace [0] linenumber - " +
                                e.getStackTrace()[0].getLineNumber());
            System.out.println("Stack Trace [0] methodname - " +
                                e.getStackTrace()[0].getMethodName());
        }
    }
}