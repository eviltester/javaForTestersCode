package com.javafortesters.chap021collectionsrevisited.exercises;

import com.javafortesters.domainentities.interim.comparator.User;
import org.junit.Test;

import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class SortedSetExercisesComparableUserClassTest {

    @Test
    public void sortedSetWithComparableUser(){
        User bob = new User("Bob", "pA55Word");   // 11
        User dupebob = new User("Bob", "hello");
        User rich = new User("Richie", "RichieRichieRich"); // 22
        User dupebob2 = new User("Bob", "BobsMightyBigBobPassword");
        User mrBeer = new User("Stafford", "sys"); // 11

        SortedSet<User> userSortedList = new TreeSet<User>();

        userSortedList.add(bob);
        userSortedList.add(dupebob);
        userSortedList.add(rich);
        userSortedList.add(dupebob2);
        userSortedList.add(mrBeer);

        assertEquals(3, userSortedList.size());

        User[] users = new User[userSortedList.size()];
        userSortedList.toArray(users);

        assertEquals(bob.getUsername(), users[0].getUsername());
        assertEquals(mrBeer.getUsername(), users[1].getUsername());
        assertEquals(rich.getUsername(), users[2].getUsername());
    }
}