package com.javafortesters.chap018properties.exercises;


import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PropertyExercisesTest {

    @Test
    public void canCreateAndListTheProperties(){

        Properties properties = new Properties();
        properties.setProperty("name", "bob");
        properties.setProperty("gender", "male");
        properties.setProperty("password", "paSSw0rd");

        assertThat(properties.stringPropertyNames().size(), is (3));

        for( String key : properties.stringPropertyNames()){
            System.out.println("Key: " + key + " " +
                    "Value: " + properties.getProperty(key));
        }

        properties.list(System.out);

        Assert.assertTrue(properties.containsKey("gender"));
        Assert.assertEquals("bob", properties.getProperty("name"));
        Assert.assertEquals("Admin",
                    properties.getProperty("permission", "Admin"));
    }

    @Test
    public void canAccessSystemProperties(){
        System.out.println("More Details:");
        System.out.println("docs.oracle.com/javase/tutorial/" +
                           "essential/environment/sysprop.html");

        Properties sys = System.getProperties();
        sys.list(System.out);
    }

    @Test
    public void canSaveAndLoadAPropertiesFile() throws IOException {

        String tempDirectory = System.getProperty("java.io.tmpdir");
        String tempResourceFilePath = tempDirectory +
                System.currentTimeMillis() +
                System.nanoTime() +
                ".properties";

        Properties saved = new Properties();

        long nanoTime = System.nanoTime();
        long millis = System.currentTimeMillis();

        saved.setProperty("nanoTime", String.valueOf(nanoTime));
        saved.setProperty("millis", String.valueOf(millis));

        FileOutputStream outputFile =
                new FileOutputStream(tempResourceFilePath);

        saved.store(outputFile, "Time Data When File Written");
        outputFile.close();

        FileReader propertyFileReader =
                new FileReader(tempResourceFilePath);
        Properties loaded = new Properties();

        try{
            loaded.load(propertyFileReader);
        }finally{
            propertyFileReader.close();
        }

        assertThat(loaded.getProperty("nanoTime"),
                is(String.valueOf(nanoTime)));
        assertThat(loaded.getProperty("millis"),
                is(String.valueOf(millis)));

        new File(tempResourceFilePath).delete();

    }
}