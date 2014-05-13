package com.javafortesters.collections;


import com.javafortesters.domainentities.User;
import org.junit.Test;

import java.util.*;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MapTest {

    @Test
    public void mapExplored(){
        Map<String,User> mapa = new HashMap<>();
        Map<String,User> mapb = new HashMap<String,User>();
        Map<String,User> mapc = new <String,User>HashMap();
        /*
        map.containsKey(o)
        map.containsValue(o)
        map.entrySet()
        map.get(o)
        map.keySet()
        map.put(o,o)
        map.putAll(m);
        map.size()
        map.clear();
        map.isEmpty()
        map.values()
        map.remove(o)
        */

    }

    @Test
    public void canAddKeyValuePairToAMap(){
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        assertEquals(3, map.size());

        map.put("key1", "newvalue1");
        assertEquals("newvalue1", map.get("key1"));
    }

    @Test
    public void canRemoveKeyValuePairUsingKeyFromMap(){

        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        map.remove("key1");

        assertEquals(2, map.size());
    }

    @Test
    public void cannotRemoveKeyValuePairwhenKeyIsWrongFromMap(){
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        map.remove("key15");

        assertEquals(3, map.size());
    }

    @Test
    public void canRetrieveAValueFromMapWithKey(){

        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        assertEquals("value1", map.get("key1"));
        assertEquals("value2", map.get("key2"));
        assertEquals("value3", map.get("key3"));

        assertEquals(null, map.get("key4"));
    }

    @Test
    public void canEmptyAMapWithClear(){

        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        assertEquals(3, map.size());

        map.clear();
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
    }


    @Test
         public void canCheckContentsOfMap(){

        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        assertTrue(map.containsKey("key1"));
        assertFalse(map.containsKey("key23"));

        assertTrue(map.containsValue("value2"));
        assertFalse(map.containsValue("value23"));
    }

    @Test
    public void canPutOneMapInAnotherMap(){

        Map<String,String> map = new HashMap<>();
        Map<String,String> mapToAdd = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        mapToAdd.put("key1", "keyvalue1");
        mapToAdd.put("key4", "value4");

        map.putAll(mapToAdd);

        assertEquals(4, map.size());
        assertEquals("keyvalue1", map.get("key1"));
    }

    @Test
    public void canUseEntrySet(){
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        Set<Map.Entry<String,String>> entries = map.entrySet();

        for( Map.Entry<String,String> entry : entries){
            entry.setValue("bob");
        }

        assertEquals("bob", map.get("key1"));
        assertEquals("bob", map.get("key2"));
        assertEquals("bob", map.get("key3"));
    }


    @Test
         public void canGetAllValues(){
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        Collection<String> values = map.values();

        assertEquals(map.size(), values.size());
    }

    @Test
    public void canGetAllKeys(){
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        Set<String> keys = map.keySet();

        assertEquals(map.size(), keys.size());
    }

    @Test
    public void canGetAllKeysAsSortedSet(){
        Map<String,String> map = new HashMap<>();

        map.put("key2", "value2");
        map.put("key1", "value1");
        map.put("key3", "value3");

        SortedSet<String> keys = new TreeSet<String>(map.keySet());

        String[] keysa = new String[keys.size()];
        keys.toArray(keysa);

        assertEquals("key1", keysa[0]);
        assertEquals("key2", keysa[1]);
        assertEquals("key3", keysa[2]);
    }
}