package com.javafortesters.chap010collections.exercises;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class CollectionsExercisesTest {



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


    @Test
    public void createAndManipulateACollectionOfUsers(){
        Collection<User> someUsers = new ArrayList<User>();

        User bob = new User("bob", "Passw0rd");
        User eris = new User("eris", "Cha0sTime");

        assertEquals(0, someUsers.size());
        assertTrue(someUsers.isEmpty());

        someUsers.add(bob);
        someUsers.add(eris);

        assertEquals(2, someUsers.size());
        assertFalse(someUsers.isEmpty());

        Collection<User> secondUsers = new ArrayList<User>();
        User robert = new User("robert", "9assword");
        User aleister = new User("aleister", "Pass5word");
        secondUsers.add(robert);
        secondUsers.add(aleister);
        assertEquals(2, secondUsers.size());

        someUsers.addAll(secondUsers);
        assertEquals(4, someUsers.size());
        assertTrue(someUsers.containsAll(someUsers));
        assertTrue(someUsers.contains(aleister));

        secondUsers.removeAll(someUsers);
        assertEquals(0, secondUsers.size());

        someUsers.clear();
        assertEquals(0, someUsers.size());
    }


    @Test
    public void createAndManipulateAListOfUsers(){
        List<User> someUsers = new ArrayList<User>();

        assertEquals(0, someUsers.size());

        User bob = new User("bob", "Passw0rd");
        User eris = new User("eris", "Cha0sTime");

        someUsers.add(bob);
        assertEquals(1, someUsers.size());

        someUsers.add(0, eris);
        assertEquals(2, someUsers.size());

        assertEquals(1, someUsers.indexOf(bob));
        assertEquals(0, someUsers.indexOf(eris));

        someUsers.remove(0);
        assertEquals(0, someUsers.indexOf(bob));
        assertEquals(1, someUsers.size());
    }

    @Test
    public void createAndManipulateASetOfUsers(){
        Set<User> someUsers = new HashSet<User>();

        assertEquals(0, someUsers.size());

        User bob = new User("bob", "Passw0rd");

        someUsers.add(bob);
        assertEquals(1, someUsers.size());

        someUsers.add(bob);
        assertEquals(1, someUsers.size());
    }


    @Test
    public void createAndManipulateAMapOfUsers(){
        Map<String, User> someUsers = new HashMap<String, User>();

        assertEquals(0, someUsers.size());

        User bob = new User("bob", "Passw0rd");
        User eris = new User("eris", "Cha0sTime");

        someUsers.put(bob.getUsername(), bob);
        assertEquals(1, someUsers.size());

        someUsers.put(bob.getUsername(), eris);
        assertEquals(1, someUsers.size());
    }
}