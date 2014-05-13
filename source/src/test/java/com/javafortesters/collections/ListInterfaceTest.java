package com.javafortesters.collections;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ListInterfaceTest {

    @Test
    public void listInterfaceExplored(){
       /*
        List<String> aList = new ArrayList<String>();
        aList.get(i);
        aList.remove(i)
        aList.add(i,element);
        aList.addAll(i,collection)
        aList.indexOf(element)
        aList.lastIndexOf(element)
        aList.set(i, element)
        aList.subList(from,to)
        */
    }

    @Test
    public void getAnElementAtAnIndex(){
        List<String> days = new ArrayList<String>();

        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");

        assertEquals("Monday", days.get(0));
        assertEquals("Tuesday", days.get(1));
        assertEquals("Wednesday", days.get(2));
    }

    @Test
    public void removeAnElementAtAnIndex(){
        List<String> days = new ArrayList<String>();

        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");

        days.remove(1);

        assertEquals(2, days.size());
        assertEquals("Monday", days.get(0));
        assertEquals("Wednesday", days.get(1));
    }

    @Test
    public void canAddAnElementAtAnIndex(){
        List<String> days = new ArrayList<String>();

        days.add("Tuesday");
        days.add("Thursday");
        days.add("Saturday");

        days.add(0, "Monday");
        days.add(2, "Wednesday");
        days.add(4, "Friday");
        days.add(6, "Sunday");

        assertEquals(7, days.size());
        assertEquals("Monday", days.get(0));
        assertEquals("Tuesday", days.get(1));
        assertEquals("Wednesday", days.get(2));
        assertEquals("Thursday", days.get(3));
        assertEquals("Friday", days.get(4));
        assertEquals("Saturday", days.get(5));
        assertEquals("Sunday", days.get(6));
    }


    @Test(expected = java.lang.IndexOutOfBoundsException.class)
    public void cannotAddAnElementOutSideListBounds(){
        List<String> days = new ArrayList<String>();

        days.add("Tuesday");
        days.add("Thursday");
        days.add("Saturday");

        // get 3 would throw out of bounds
        //days.get(3);

        assertEquals(3, days.size());
        // cannot add at 20, can only add at end with 3
        days.add(20, "Twenty");
    }

    @Test
    public void canAddAllElementsInACollectionAtASpecificIndex(){

        List<String> days = new ArrayList<String>();
        List<String> missingDays = new ArrayList<String>();

        days.add("Monday");
        days.add("Friday");

        missingDays.add("Tuesday");
        missingDays.add("Wednesday");
        missingDays.add("Thursday");

        days.addAll(1, missingDays);

        assertEquals(5, days.size());
        assertEquals("Monday", days.get(0));
        assertEquals("Tuesday", days.get(1));
        assertEquals("Wednesday", days.get(2));
        assertEquals("Thursday", days.get(3));
        assertEquals("Friday", days.get(4));
    }

    @Test
         public void canAddAllElementsInACollectionAtStartIndex(){

        List<String> days = new ArrayList<String>();
        List<String> missingDays = new ArrayList<String>();

        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");

        missingDays.add("Monday");
        missingDays.add("Tuesday");

        days.addAll(0, missingDays);

        assertEquals(5, days.size());
        assertEquals("Monday", days.get(0));
        assertEquals("Tuesday", days.get(1));
        assertEquals("Wednesday", days.get(2));
        assertEquals("Thursday", days.get(3));
        assertEquals("Friday", days.get(4));
    }

    @Test
    public void canAddAllElementsInACollectionAtEndIndex(){

        List<String> days = new ArrayList<String>();
        List<String> missingDays = new ArrayList<String>();

        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");

        missingDays.add("Thursday");
        missingDays.add("Friday");

        // equivalent to days.addAll(missingDays);
        days.addAll(days.size(), missingDays);

        assertEquals(5, days.size());
        assertEquals("Monday", days.get(0));
        assertEquals("Tuesday", days.get(1));
        assertEquals("Wednesday", days.get(2));
        assertEquals("Thursday", days.get(3));
        assertEquals("Friday", days.get(4));
    }

    @Test
    public void canFindTheIndexOfAnElement(){
        List<String> days = new ArrayList<String>();

        days.add("Tuesday");
        days.add("Thursday");
        days.add("Saturday");

        assertEquals(1, days.indexOf("Thursday"));
        assertEquals(1, days.lastIndexOf("Thursday"));
    }

    @Test
    public void canFindTheIndexOfAnElementWithDupes(){
        List<String> days = new ArrayList<String>();

        days.add("Tuesday");
        days.add("Thursday");
        days.add("Saturday");
        days.add("Thursday");
        days.add("Thursday");
        days.add("Sunday");

        assertEquals(4, days.lastIndexOf("Thursday"));
        assertEquals(1, days.indexOf("Thursday"));
    }

    @Test
    public void canSetTheElementAtAnIndex(){
        List<String> days = new ArrayList<String>();

        days.add("Monday");
        days.add("Thursday");
        days.add("Wednesday");

        days.set(1, "Tuesday");

        assertEquals("Tuesday", days.get(1));

        assertEquals(3, days.size());
        assertEquals("Monday", days.get(0));
        assertEquals("Tuesday", days.get(1));
        assertEquals("Wednesday", days.get(2));
    }

    @Test
    public void canCreateSubList(){

        List<String> days = new ArrayList<String>();

        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        List<String> workdays = days.subList(0,5);

        assertEquals(5, workdays.size());
        assertEquals("Monday", workdays.get(0));
        assertEquals("Tuesday", workdays.get(1));
        assertEquals("Wednesday", workdays.get(2));
        assertEquals("Thursday", workdays.get(3));
        assertEquals("Friday", workdays.get(4));

        List<String> weekend = days.subList(5,7);

        assertEquals(2, weekend.size());
        assertEquals("Saturday", weekend.get(0));
        assertEquals("Sunday", weekend.get(1));



    }

}