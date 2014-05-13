package com.javafortesters.domainentities;

public class User {


    private String username;
    private String password;

    public User(){
        this("username", "password");
    }


    public User(String username, String password) {
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

    public String getPermission() {
        return "Normal";
    }
}