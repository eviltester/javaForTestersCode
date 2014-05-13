package com.javafortesters.collections;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class MapExercisesTest {

    @Test
    public void exerciseCanGetAllKeysAsSortedSet(){
        Map<String,String> map = new HashMap<>();

        map.put("key4", "value4");
        map.put("key2", "value2");
        map.put("key1", "value1");
        map.put("key3", "value3");

        SortedSet<String> keys = new TreeSet<String>(map.keySet());

        int valSuffix = 1;
        for(String key : keys){
            assertEquals("value" + valSuffix,
                         map.get(key));

            valSuffix += 1;
        }
    }
}