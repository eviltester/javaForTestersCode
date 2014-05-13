package com.javafortesters.arraysiteration;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayExampleTest {

    String[] workdays = {"Monday", "Tuesday", "Wednesday",
                        "Thursday", "Friday"};


    @Test
    public void arraInitialization(){
        int[] integers = new int[10];
        String strings[] = new String[10];


        int []zeroLength = {};
        int []moreZeroLength = new int[0];

        int []uninitializedArray;

        strings = new String[] {"mr", "mrs", "sir", "lord", "madam"};
    }

    @Test
    public void forEachLoop(){
        String days="";

        for(String workday : workdays){
            days = days + "|" + workday;
        }

        assertEquals("|Monday|Tuesday|Wednesday|Thursday|Friday",days);
    }

    @Test
    public void forLoopWithFixedCondition(){
        String days="";

        for(int i=0; i<5; i++){
            days = days + "|" + workdays[i];
        }

        assertEquals("|Monday|Tuesday|Wednesday|Thursday|Friday",days);
    }

    @Test
    public void forLoopMissingInitialization(){
        String days="";

        int i=0;
        for(; i<5; i++){
            days = days + "|" + workdays[i];
        }
        assertEquals("|Monday|Tuesday|Wednesday|Thursday|Friday",days);
    }

    @Test
    public void forLoopMissingIterator(){
        String days="";

        int i=0;
        for(; i<5; ){
            days = days + "|" + workdays[i];
            i++;
        }
        assertEquals("|Monday|Tuesday|Wednesday|Thursday|Friday",days);
    }

    @Test
    public void forLoopMissingEverything(){
        String days="";
        int i=0;
        for(; ; ){
            days = days + "|" + workdays[i];
            i++;
            if(i>=5) break;
        }
        assertEquals("|Monday|Tuesday|Wednesday|Thursday|Friday",days);
    }

    @Test
    public void forEachWithIndex(){
        String days="";
        int dayindex =0;
        for(String workday : workdays){
            days = days + "|" + workday;
            System.out.println("found " + workday +
                               " at position " + dayindex);
            dayindex++;
        }
        assertEquals("|Monday|Tuesday|Wednesday|Thursday|Friday",days);
    }

    @Test
    public void accessValuesInArray(){

        assertEquals("Monday", workdays[0]);
        assertEquals("Friday", workdays[4]);
    }

    @Test
    public void arraySize(){
        assertEquals(5, workdays.length);
    }

    @Test
    public void arraySizeInForLoop(){
        String days="";

        for(int i=0; i<workdays.length; i++){
            days = days + "|" + workdays[i];
        }
        assertEquals("|Monday|Tuesday|Wednesday|Thursday|Friday",days);
    }
}