package com.javafortesters.booksupport.pretendwebdriver;

/**
 * A stub firefox driver to use in examples as a pretend WebDriver
 *
 * I'm not using any Mocking frameworks, I don't really need to, it just has to 'look'
 * like a Driver, it doesn't have to 'be' a driver.
 */
public class FirefoxDriver {

    // a pretend implementation of a get
    public void get(String url){
        // I do nothing
    }

    public String getTitle() {
        return "Test App";
    }
}