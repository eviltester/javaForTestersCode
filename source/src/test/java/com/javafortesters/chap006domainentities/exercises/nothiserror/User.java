package com.javafortesters.chap006domainentities.exercises.nothiserror;

/**
 * This User, used for exercises only has incorrect constructor code
 */
public class User {

    private String username;
    private String password;

    // missing the `this.` so it will fail
    // the username being set is not the field, it is the parameter
    public User(String username, String password) {
        username = username;
        password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}