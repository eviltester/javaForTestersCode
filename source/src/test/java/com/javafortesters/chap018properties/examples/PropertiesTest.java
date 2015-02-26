package com.javafortesters.chap018properties.examples;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class PropertiesTest {

    @Test
    public void canCreateGetAndSetProperties(){

        Properties properties = new Properties();

        assertThat(properties.size(), is(0));

        properties.setProperty("browser", "firefox");
        properties.setProperty("port", "80");
        assertThat( properties.getProperty("browser"),
                    is("firefox"));
        assertThat( properties.getProperty("port"),
                    is("80"));

        assertThat( properties.getProperty("missing"),
                    is(nullValue()));

        assertThat( properties.getProperty("missing", "default"),
                    is("default"));

        assertThat( properties.containsKey("browser"), is(true));
    }


    @Test
    public void canDisplayTheProperties(){

        Properties properties = new Properties();
        properties.setProperty("browser", "firefox");
        properties.setProperty("port", "80");

        assertThat(properties.stringPropertyNames().size(), is (2));

        for( String key : properties.stringPropertyNames()){
            System.out.println("Key: " + key + " " +
                               "Value: " + properties.getProperty(key));
        }

        properties.list(System.out);
    }


    @Test
    public void canAccessSystemProperties(){

        String workingDirectory = System.getProperty("user.dir");

        String resourceFilePath = workingDirectory +
                                  "/src/test/resources/" +
                                  "property_files/" +
                                  "static_example.properties";

        Properties sys = System.getProperties();
        sys.list(System.out);
    }

    @Test
    public void exampleSetWebdriverChromeIfNotSet(){
        if(!System.getProperties().containsKey("webdriver.chrome.driver")){
            String currentDir = System.getProperty("user.dir");
            String chromeDriverLocation
                        = currentDir +
                        "/../tools/chromedriver/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        }
    }


    @Test
    public void simpleSaveLoadPropertiesFile() throws IOException {

        String tempDirectory = System.getProperty("java.io.tmpdir");
        String tempResourceFilePath =
                    tempDirectory +
                    "tempFileForPropertiesStoreTest.properties";

        Properties saved = new Properties();
        saved.setProperty("prop1", "Hello");
        saved.setProperty("prop2", "World");

        FileOutputStream outputFile =
                            new FileOutputStream(tempResourceFilePath);
        saved.store(outputFile, "Hello There World");
        outputFile.close();

        FileReader propertyFileReader =
                            new FileReader(tempResourceFilePath);
        Properties loaded = new Properties();

        try{
            loaded.load(propertyFileReader);
        }finally{
            propertyFileReader.close();
        }

        assertThat(loaded.getProperty("prop1"), is("Hello"));
        assertThat(loaded.getProperty("prop2"), is("World"));


        new File(tempResourceFilePath).delete();

    }
}