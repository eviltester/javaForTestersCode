package com.javafortesters.collections;


import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CollectionInterfacesTest {


    @Test
    public void collectionDeclarationAndInitializationExplored(){

        Collection<String> cola = new ArrayList<String>();
        Collection<String> colb = new <String>ArrayList();
        Collection<String> colc = new ArrayList<>();

    }

    @Test
    public void hashSetDoesNotAllowDupes(){

        Collection workdays = new HashSet();

        workdays.add("Monday");
        workdays.add("Monday");
        workdays.add("Monday");
        workdays.add("Monday");
        workdays.add("Monday");

        assertEquals(1, workdays.size());
    }

    @Test
    public void arrayListDoesAllowDupes(){

        Collection workdays = new ArrayList();

        workdays.add("Monday");
        workdays.add("Monday");
        workdays.add("Monday");
        workdays.add("Monday");
        workdays.add("Monday");

        assertEquals(5, workdays.size());
    }

    @Test
    public void instantiateCollection17(){

        Collection<String> weekendDays = new ArrayList<>();

    }

    @Test
    public void instantiateCollectionInterface(){

        Collection workdays;
        workdays = new ArrayList();

        // a collection doesn't need to hold all the same object
        // but we can iterate without casting if we specify it
        Collection<String> weekendDays = new <String>ArrayList();
        Collection<String> daysOfWeek = new <String>ArrayList();

        setupWorkDays(workdays);
        addAllWorkdaystoDaysOfWeek(workdays, daysOfWeek);

        setupWeekendDays(weekendDays);

        // add all weekend days to days of week
        daysOfWeek.addAll(weekendDays);
        assertTrue(daysOfWeek.containsAll(weekendDays));


        assertEquals(weekendDays.size() + workdays.size(), daysOfWeek.size());
    }

    public void setupWorkDays(Collection workdays){
        // setup the workdays
        workdays.add("Monday");
        workdays.add("Tuesday");
        workdays.add("Wednesday");
        workdays.add("Thursday");
        workdays.add("Friday");

        assertEquals(5, workdays.size());
    }

    public void addAllWorkdaystoDaysOfWeek(Collection workdays, Collection daysOfWeek){
        // add all the workdays days into daysOfWeek
        assertEquals(0, daysOfWeek.size());
        assertFalse( daysOfWeek.containsAll(workdays) );

        daysOfWeek.addAll(workdays);

        assertEquals( workdays.size(), daysOfWeek.size() );
        assertTrue( daysOfWeek.containsAll(workdays ));
    }


    @Test
    public void canRemoveElementAndContainsReturnsFalse(){

        Collection<String> weekendDays = new <String>ArrayList();

        // setup the weekend days
        weekendDays.add("Saturday");
        weekendDays.add("Funday");

        assertEquals(2, weekendDays.size());
        assertTrue("Bug, Funday exists but it should really be Sunday",
                weekendDays.contains("Funday"));

        // fix the bug and replace Funday with Sunday
        weekendDays.remove("Funday");

        assertFalse(weekendDays.contains("Funday"));
        assertEquals(1, weekendDays.size());

        weekendDays.add("Sunday");

        assertEquals(2, weekendDays.size());
        assertTrue("Bug Fixed, Sunday is in the collection now",
                weekendDays.contains("Sunday"));
    }


    private void setupWeekendDays(Collection weekendDays) {
        weekendDays.add("Saturday");
        weekendDays.add("Sunday");
    }

    @Test
    public void canOutputAllDaysOfWeek(){

        Collection workdays;
        workdays = new ArrayList();

        //Collection<String> workdays = new <String>ArrayList();
        Collection<String> weekendDays = new <String>ArrayList();
        Collection<String> daysOfWeek = new <String>ArrayList();

        setupWorkDays(workdays);
        setupWeekendDays(weekendDays);

        daysOfWeek.addAll(workdays);
        daysOfWeek.addAll(weekendDays);

        // iterate over the String collection because of iterator()
        for(String dayOfWeek : daysOfWeek){
            System.out.println(dayOfWeek);
        }

        // iterate over the Object collection
        // demonstrates casting
        for(Object workday : workdays){
            String outputDay = (String)workday;
            System.out.println(outputDay);
        }
    }

    @Test
    public void clearCanEmptyACollection(){

        Collection<String> workdays = new <String>ArrayList();
        Collection<String> weekendDays = new <String>ArrayList();

        setupWorkDays(workdays);
        setupWeekendDays(weekendDays);

        Collection<String> daysOfWeek = new <String>ArrayList();

        daysOfWeek.addAll(workdays);
        daysOfWeek.addAll(weekendDays);

        assertEquals(7, daysOfWeek.size());

        daysOfWeek.clear();

        assertEquals(0, daysOfWeek.size());
        assertTrue(daysOfWeek.isEmpty());
    }

    @Test
    public void canRemoveAllOneCollectionFromAnother(){

        Collection<String> workdays = new <String>ArrayList();
        Collection<String> weekendDays = new <String>ArrayList();


        setupWorkDays(workdays);
        setupWeekendDays(weekendDays);

        Collection<String> daysOfWeek = new <String>ArrayList();

        daysOfWeek.addAll(workdays);
        daysOfWeek.addAll(weekendDays);

        assertEquals(7, daysOfWeek.size());

        daysOfWeek.removeAll(weekendDays);

        assertTrue(daysOfWeek.containsAll(workdays));
        assertEquals(5, daysOfWeek.size());
        assertFalse(daysOfWeek.containsAll(weekendDays));

    }

    @Test
    public void retainAllRemoveAllButACollection(){

        Collection<String> workdays = new <String>ArrayList();
        Collection<String> weekendDays = new <String>ArrayList();

        setupWorkDays(workdays);
        setupWeekendDays(weekendDays);

        Collection<String> daysOfWeek = new <String>ArrayList();

        daysOfWeek.addAll(workdays);
        daysOfWeek.addAll(weekendDays);

        assertTrue(daysOfWeek.containsAll(workdays));
        assertTrue(daysOfWeek.containsAll(weekendDays));

        daysOfWeek.retainAll(weekendDays);

        assertEquals("only weekend days now", 2, daysOfWeek.size());
        assertTrue(daysOfWeek.containsAll(weekendDays));
        assertFalse(daysOfWeek.containsAll(workdays));
    }

    @Test
    public void collectionConvertToArray(){

        Collection<String> workdays = new <String>ArrayList();
        Collection<String> weekendDays = new <String>ArrayList();
        Collection<String> daysOfWeek = new <String>ArrayList();

        setupWorkDays(workdays);
        setupWeekendDays(weekendDays);

        daysOfWeek.addAll(workdays);
        daysOfWeek.addAll(weekendDays);

        assertEquals(weekendDays.size() + workdays.size(), daysOfWeek.size());

        // convert to array as object
        Object[] daysOfWeekArray = daysOfWeek.toArray();
        assertEquals(7, daysOfWeekArray.length);

        assertEquals("Monday".length(),
                    ((String)daysOfWeekArray[0]).length());


        // convert to array with correct type
        String[] anotherArray = new String[daysOfWeek.size()];
        daysOfWeek.toArray(anotherArray);
        assertEquals("Monday".length(),
                    anotherArray[0].length());


    }

}