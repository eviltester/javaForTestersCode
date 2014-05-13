package com.javafortesters.datestimes;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TimeTest {

    @Test
    public void currentTimeMillis(){
        long startTime = System.currentTimeMillis();

        for(int x=0; x < 10; x++){
            System.out.println("Current Time " +
                                System.currentTimeMillis());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total Time " + (endTime - startTime));
    }


    @Test
    public void createAUniqueUserID(){

        String userID = "user" + System.currentTimeMillis();

        System.out.println(userID);
    }

    @Test
    public void createAUniqueUserIDAllChars(){

        String initialUserID = "user" + System.currentTimeMillis();
        System.out.println(initialUserID);

        String userID = initialUserID;

        for(int x = 0; x< 10; x++){
            userID = userID.replace( "" + x, "" + ((char)('A'+x)));
        }

        assertThat(userID.contains("0"), is(false));
        assertThat(userID.contains("1"), is(false));
        assertThat(userID.contains("2"), is(false));
        assertThat(userID.contains("3"), is(false));
        assertThat(userID.contains("4"), is(false));
        assertThat(userID.contains("5"), is(false));
        assertThat(userID.contains("6"), is(false));
        assertThat(userID.contains("7"), is(false));
        assertThat(userID.contains("8"), is(false));
        assertThat(userID.contains("9"), is(false));

        assertThat(initialUserID.length(), is(userID.length()));

        System.out.println(userID);
    }

    @Test
    public void nanoTime(){
        long startTime = System.nanoTime();

        for(int x=0; x < 10; x++){
            System.out.println("Current Time " + System.nanoTime());
        }

        long endTime = System.nanoTime();
        System.out.println("Total Time " + (endTime - startTime));
    }
}