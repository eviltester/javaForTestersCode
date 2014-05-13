package com.javafortesters.domainentities.interim.inheritance;

import com.javafortesters.domainobject.TestAppEnv;

/**
 * A user which implements getUrl through composition
 */
public class User {

    private String username;
    private String password;
    private TestAppEnv testAppEnv;

    public User(){
        this("username", "password");
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.testAppEnv = new TestAppEnv();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl(){
        return this.testAppEnv.getUrl();
    }

}