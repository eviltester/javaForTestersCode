package com.javafortesters.chap012inheritance.examples;


import com.javafortesters.domainentities.AdminUser;
import com.javafortesters.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InheritanceTest {


    @Test
    public void emptyUserExampleTest(){
        EmptyUser enu = new EmptyUser();
        assertEquals("username", enu.getUsername());
        assertEquals("password", enu.getPassword());
    }

    @Test
    public void aUserHasNormalPermissions(){
        User aUser = new User();
        assertEquals("Normal", aUser.getPermission());
    }


    @Test
    public void anAdminUserDefaultConstructor(){
        AdminUser adminUser = new AdminUser();
        assertEquals("adminuser", adminUser.getUsername());
        assertEquals("password", adminUser.getPassword());
        assertEquals("Elevated", adminUser.getPermission());
    }

    @Test
    public void anAdminUserHasElevatedPermissions(){
        AdminUser adminUser = new AdminUser("admin","Passw0rd");
        assertEquals("admin", adminUser.getUsername());
        assertEquals("Passw0rd", adminUser.getPassword());
        assertEquals("Elevated", adminUser.getPermission());
    }
}