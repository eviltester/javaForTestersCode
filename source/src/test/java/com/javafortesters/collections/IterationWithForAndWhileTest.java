package com.javafortesters.collections;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IterationWithForAndWhileTest {

    @Test
    public void findMondayWithLoops(){

        String[] someDays = {"Tuesday","Thursday",
                            "Wednesday","Monday",
                            "Saturday","Sunday",
                            "Friday"};

        List<String> days = Arrays.asList(someDays);

        int forCount=0;
        for(String day : days){
            if(day.equals("Monday")){
                break;
            }
            forCount++;
        }
        assertEquals("Monday is at position 3", 3, forCount);

        int loopCount;
        for(loopCount=0; loopCount <= days.size(); loopCount++ ){
            if(days.get(loopCount).equals("Monday")){
                break;
            }
        }
        assertEquals("Monday is at position 3", 3, loopCount);


        int count=0;
        while(!days.get(count).equals("Monday") ){
           count++;
        }
        assertEquals("Monday is at position 3", 3, count);

        int docount=-1;
        do{
            docount++;
        }while(!days.get(docount).equals("Monday"));
        assertEquals("Monday is at position 3", 3, docount);


    }

    @Test
    public void useAForLoopInsteadOfAWhile(){

        String[] someDays = {"Tuesday","Thursday",
                "Wednesday","Monday",
                "Saturday","Sunday",
                "Friday"};

        List<String> days = Arrays.asList(someDays);

        int forwhile;
        for(forwhile=0; !days.get(forwhile).equals("Monday"); forwhile++){
        }
        assertEquals("Monday is at position 3", 3, forwhile);
    }
}