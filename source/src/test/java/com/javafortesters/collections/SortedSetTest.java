package com.javafortesters.collections;

import com.javafortesters.domainentities.User;
import com.javafortesters.domainentities.UserComparator;
import org.junit.Test;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class SortedSetTest {

    @Test
    public void sortedSetExplored(){
        SortedSet<String> set = new <String>TreeSet();

        /*
        set.first()
        set.last()
        set.headSet(e)
        set.tailSet(e)
        set.subSet(i1,i2)
        set.comparator()
        */


    }


    @Test
    public void canRetrieveFirstFromSortedSet(){
        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        assertEquals("c", alphaset.first());

        alphaset.add("d");
        assertEquals("c", alphaset.first());

        alphaset.add("b");
        assertEquals("b", alphaset.first());

        alphaset.add("a");
        assertEquals("a", alphaset.first());
    }


    @Test
    public void canRetrieveLastFromSortedSet(){
        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        assertEquals("c", alphaset.last());

        alphaset.add("b");
        assertEquals("c", alphaset.last());

        alphaset.add("d");
        assertEquals("d", alphaset.last());

        alphaset.add("a");
        assertEquals("d", alphaset.last());
    }

    @Test
    public void sortedSetCanMaintainSortOrder(){

        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        alphaset.add("d");
        alphaset.add("a");
        alphaset.add("b");
        alphaset.add("a");

        assertEquals(4, alphaset.size());

        String[] alphas = new String[alphaset.size()];
        alphaset.toArray(alphas);

        assertEquals("a", alphas[0]);
        assertEquals("b", alphas[1]);
        assertEquals("c", alphas[2]);
        assertEquals("d", alphas[3]);
    }

    @Test
    public void sortedSetcanReturnHeadSet(){

        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        alphaset.add("d");
        alphaset.add("b");
        alphaset.add("a");

        SortedSet<String> subset = alphaset.headSet("c");

        assertEquals(2, subset.size());

        String[] alphas = new String[subset.size()];
        subset.toArray(alphas);

        assertEquals("a", alphas[0]);
        assertEquals("b", alphas[1]);
    }

    @Test
    public void sortedSetcanReturnTailSet(){

        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        alphaset.add("d");
        alphaset.add("b");
        alphaset.add("a");

        SortedSet<String> subset = alphaset.tailSet("c");

        assertEquals(2, subset.size());

        String[] alphas = new String[subset.size()];
        subset.toArray(alphas);

        assertEquals("c", alphas[0]);
        assertEquals("d", alphas[1]);
    }

    @Test
    public void sortedSetcanReturnSubSet(){

        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        alphaset.add("d");
        alphaset.add("b");
        alphaset.add("a");

        SortedSet<String> subset = alphaset.subSet("b", "d");

        assertEquals(2, subset.size());

        String[] alphas = new String[subset.size()];
        subset.toArray(alphas);

        assertEquals("b", alphas[0]);
        assertEquals("c", alphas[1]);
    }



    @Test(expected = java.lang.ClassCastException.class)
    public void sortedSetWithComparatorForUserNoComparator(){
        User bob = new User("Bob", "pA55Word");   // 11
        User tiny = new User("TinyTim", "hello"); //12
        User rich = new User("Richie", "RichieRichieRich"); // 22
        User sun = new User("sun", "tzu"); // 6
        User mrBeer = new User("Stafford", "sys"); // 11

        SortedSet<User> userSortedList = new TreeSet<User>();

        userSortedList.add(bob);
    }



    @Test
    public void sortedSetWithComparatorForUser(){
        User bob = new User("Bob", "pA55Word");   // 11
        User tiny = new User("TinyTim", "hello"); //12
        User rich = new User("Richie", "RichieRichieRich"); // 22
        User sun = new User("sun", "tzu"); // 6
        User mrBeer = new User("Stafford", "sys"); // 11

        SortedSet<User> userSortedList =
                            new TreeSet<User>(new UserComparator());

        userSortedList.add(bob);
        userSortedList.add(tiny);
        userSortedList.add(rich);
        userSortedList.add(sun);
        userSortedList.add(mrBeer);

        User[] users = new User[userSortedList.size()];
        userSortedList.toArray(users);

        assertEquals(sun.getUsername(), users[0].getUsername());
        assertEquals(bob.getUsername(), users[1].getUsername());
        assertEquals(mrBeer.getUsername(), users[2].getUsername());
        assertEquals(tiny.getUsername(), users[3].getUsername());
        assertEquals(rich.getUsername(), users[4].getUsername());
    }

    @Test
    public void comparatorExcludesUsersWithSameUserName(){
        // where the username and password length is the same
        User bob = new User("Bob", "pA55Word");   // 11
        User tiny = new User("Bob", "helloBob"); //11
        User rich = new User("Bob", "12345678"); // 11
        User bigBob = new User("Bob", "123456789"); // 11

        SortedSet<User> userSortedList = new TreeSet<User>(new UserComparator());

        userSortedList.add(bob);
        userSortedList.add(tiny);
        userSortedList.add(rich);
        userSortedList.add(bigBob);

        assertEquals(2, userSortedList.size());

        User[] users = new User[userSortedList.size()];
        userSortedList.toArray(users);

        assertEquals(bob.getPassword(), users[0].getPassword());
        assertEquals(bigBob.getPassword(), users[1].getPassword());
    }

}