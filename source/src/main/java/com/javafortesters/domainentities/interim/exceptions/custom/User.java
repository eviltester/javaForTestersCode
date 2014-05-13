package com.javafortesters.domainentities.interim.exceptions.custom;

public class User {


    private String username;
    private String password;

    public User(){
            this("username", "password", false);
    }

    private User(String username, String password, boolean b) {
        // only call this because we don't want to throw the exception
        this.username = username;
        try{
            setPassword(password);
        }catch(InvalidPassword e){
            throw new IllegalArgumentException(
                            "Default password incorrect ", e);
        }
    }

    public User(String username, String password) throws InvalidPassword{
        this.username = username;
        setPassword(password);
    }

    public void setPassword(String password) throws InvalidPassword {

      if(password.length()<7){
         throw new InvalidPassword("Password must be > 6 chars");
      }

      this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}