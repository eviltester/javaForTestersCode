/*
package com.javafortesters.domainentities;

public class User {
}
*/

package com.javafortesters.domainentities.interim;

public class User {

    private String username;
    private String password;

    public User(){
        username = "username";
        password = "password";
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
}