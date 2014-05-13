package com.javafortesters.collections;


import com.javafortesters.domainentities.User;
import com.javafortesters.domainentities.UserComparator;
import org.junit.Test;

import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SortedMapTest {

    @Test
    public void exploreSortedMap(){
        SortedMap<String, String> map = new TreeMap<>();

        /*
        map.firstKey()
        map.lastKey()
        map.headMap(k)
        map.tailMap(k)
        map.subMap(k,k)
        map.comparator()
        */
    }

    @Test
    public void firstLastKeyTest(){
        SortedMap<String, String> map = new TreeMap<>();

        map.put("key1", "value1");
        map.put("key3", "value3");
        map.put("key2", "value2");
        map.put("key5", "value5");
        map.put("key4", "value4");

        assertEquals("key1", map.firstKey());
        assertEquals("key5", map.lastKey());
    }


    @Test
    public void subMaps(){

        SortedMap<String, String> map = new TreeMap<>();

        map.put("key1", "value1");
        map.put("key3", "value3");
        map.put("key2", "value2");
        map.put("key5", "value5");
        map.put("key4", "value4");

        SortedMap<String, String> headMap;
        headMap = map.headMap("key3");

        assertEquals(2, headMap.size());
        assertTrue(headMap.containsKey("key1"));
        assertTrue(headMap.containsKey("key2"));


        SortedMap<String, String> tailMap;
        tailMap = map.tailMap("key3");

        assertEquals(3, tailMap.size());
        assertTrue(tailMap.containsKey("key3"));
        assertTrue(tailMap.containsKey("key4"));
        assertTrue(tailMap.containsKey("key5"));

        SortedMap<String, String> subMap;
        subMap = map.subMap("key2", "key4");

        assertEquals(2, subMap.size());
        assertTrue(subMap.containsKey("key2"));
        assertTrue(subMap.containsKey("key3"));
    }


    @Test
    public void sortedMapWithComparatorForUser(){
        User bob = new User("Bob", "pA55Word");   // 11
        User tiny = new User("TinyTim", "hello"); //12
        User rich = new User("Richie", "RichieRichieRich"); // 22
        User sun = new User("sun", "tzu"); // 6
        User mrBeer = new User("Stafford", "sys"); // 11

        SortedMap<User,String> userSortedMap =
                new TreeMap<User,String>(new UserComparator());

        userSortedMap.put(bob, "Bob rules");
        userSortedMap.put(tiny, "Tiny Time");
        userSortedMap.put(rich, "Rich Richie");
        userSortedMap.put(sun, "Warfare Art");
        userSortedMap.put(mrBeer, "Cybernetician");

        User[] users = new User[userSortedMap.size()];
        userSortedMap.keySet().toArray(users);

        assertEquals(sun.getUsername(), users[0].getUsername());
        assertEquals(bob.getUsername(), users[1].getUsername());
        assertEquals(mrBeer.getUsername(), users[2].getUsername());
        assertEquals(tiny.getUsername(), users[3].getUsername());
        assertEquals(rich.getUsername(), users[4].getUsername());
    }

}