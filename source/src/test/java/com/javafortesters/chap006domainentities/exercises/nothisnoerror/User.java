package com.javafortesters.chap006domainentities.exercises.nothisnoerror;

/**
 * This User, used for exercises only has correct constructor code
 */
public class User {

    private String username;
    private String password;

    // missing the `this.` but will not fail
    // because of renamed params
    public User(String aUsername, String aPassword) {
        username = aUsername;
        password = aPassword;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}