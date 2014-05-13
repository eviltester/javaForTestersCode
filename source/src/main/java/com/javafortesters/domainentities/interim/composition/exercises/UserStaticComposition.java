package com.javafortesters.domainentities.interim.composition.exercises;

import com.javafortesters.domainobject.TestAppEnv;

/**
 * A user which implements getUrl through composition
 */
public class UserStaticComposition {

    private String username;
    private String password;

    public UserStaticComposition(){
        this("username", "password");
    }

    public UserStaticComposition(String username, String password) {
        this.username = username;
        this.password = password;
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
        return TestAppEnv.getUrl();
    }

}