package com.javafortesters.booksupport.pretendwebdriver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PretendFirefoxDriverTest {

    @Test
    public void checkTitleCorrectOnApp(){

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://192.123.0.3:67");

        assertEquals("Title should match",
                "Test App", driver.getTitle());
    }

    /*
    @Test
    public void checkTitleCorrectOnAppWithDomainObject(){

        FirefoxDriver driver = new FirefoxDriver();
        driver.get(TestAppEnv.getUrl());

        assertEquals("Title should match",
                "Test App", driver.getTitle());
    }
    */
}