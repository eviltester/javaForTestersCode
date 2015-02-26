package com.javafortesters.chap021collectionsrevisited.exercises;

import com.javafortesters.domainentities.interim.comparator.User;
import org.junit.Test;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class SortedSetExercisesUserClassNoValEqualZeroComparatorTest {

    @Test
    public void sortedSetWithComparatorForUserWithNoValEqualZero(){
        User bob = new User("Bob", "pA55Word");   // 11
        User dupebob = new User("Bob", "hello");
        User rich = new User("Richie", "RichieRichieRich"); // 22
        User dupebob2 = new User("Bob", "BobsMightyBigBobPassword");
        User mrBeer = new User("Stafford", "sys"); // 11

        SortedSet<User> userSortedList =
                new TreeSet<User>(
                        new UserComparatorDisallowDupesNoValEqualZero());

        userSortedList.add(bob);
        userSortedList.add(dupebob);
        userSortedList.add(rich);
        userSortedList.add(dupebob2);
        assertEquals(2, userSortedList.size());
        userSortedList.add(mrBeer);
        assertEquals("Mr Beer could not be added", 2, userSortedList.size());
    }

    private class UserComparatorDisallowDupesNoValEqualZero implements Comparator {

        public int compare(Object oUser1, Object oUser2) {
            User user1 = (User)oUser1;
            User user2 = (User)oUser2;

            if(user1.getUsername().compareTo(user2.getUsername())==0){
                return 0;
            }

            int user1Comparator = user1.getPassword().length() +
                    user1.getUsername().length();

            int user2Comparator = user2.getPassword().length() +
                    user2.getUsername().length();

            int val =  user1Comparator - user2Comparator;

            // if(val==0){
            //     val = user1.getUsername().compareTo(user2.getUsername());
            // }

            return val;
        }
    }
}