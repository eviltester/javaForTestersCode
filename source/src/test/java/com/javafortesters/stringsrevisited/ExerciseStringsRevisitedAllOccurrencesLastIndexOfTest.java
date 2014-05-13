package com.javafortesters.stringsrevisited;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExerciseStringsRevisitedAllOccurrencesLastIndexOfTest {

    @Test
    public void canFindAllOccurrencesInStringUsingLastIndexOf(){
        List<Integer> results;
        results = findAllOccurrences("Hello fella", "l");

        assertThat(results.size(), is(4));

        assertThat(results.contains(2), is(true));
        assertThat(results.contains(3), is(true));
        assertThat(results.contains(8), is(true));
        assertThat(results.contains(9), is(true));

        assertThat(results.get(0), is(9));
        assertThat(results.get(1), is(8));
        assertThat(results.get(2), is(3));
        assertThat(results.get(3), is(2));
    }

    @Test
    public void worksWhenNothingToFind(){
        List<Integer> results;
        results = findAllOccurrences("Hello fella", "z");
        assertThat(results.size(), is(0));

        results = findAllOccurrences("", "z");
        assertThat(results.size(), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSearchForEmpty(){
        List<Integer> results = findAllOccurrences("", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSearchForNullString(){
        List<Integer> results = findAllOccurrences(null, "hello");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSearchForNullSubString(){
        List<Integer> results = findAllOccurrences("hello", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSearchForNulls(){
        List<Integer> results = findAllOccurrences(null, null);
    }

    private List<Integer> findAllOccurrences(String string,
                                             String substring) {

        List<Integer> results = new ArrayList<Integer>();

        if(string==null || substring==null){
            throw new IllegalArgumentException("Cannot search using null");
        }

        if(substring.isEmpty()){
            throw new IllegalArgumentException(
                                      "Cannot search for Empty substring");
        }

        // set search to the start of the string
        int lastfoundPosition = string.length();

        do{
            // try and find the substring
            lastfoundPosition = string.lastIndexOf(substring,
                                                   lastfoundPosition);

            // if we found it
            if(lastfoundPosition!=-1){

                // add it to the results
                results.add(lastfoundPosition);

                // next start before this index
                lastfoundPosition--;
            }

         // keep looking until we can't find it
        }while(lastfoundPosition!=-1);

        return results;
    }
}