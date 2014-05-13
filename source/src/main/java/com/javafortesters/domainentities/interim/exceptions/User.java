package com.javafortesters.domainentities.interim.exceptions;

public class User {


    private String username;
    private String password;

    public User(){
        this("username", "password");
    }

    public User(String username, String password) {
        this.username = username;
        setPassword(password);
    }

    public void setPassword(String password) {

      if(password.length()<7){
         throw new IllegalArgumentException("Password must be > 6 chars");
      }

      this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    /*  unused exceptions - might use later
        if(!password.matches(".*[0123456789]+.*")){
            throw new IllegalArgumentException("Password must have a digit");
        }

        if(!password.matches(".*[A-Z]+.*")){
            throw new IllegalArgumentException("Password must have an Uppercase Letter");
        }
     */

}