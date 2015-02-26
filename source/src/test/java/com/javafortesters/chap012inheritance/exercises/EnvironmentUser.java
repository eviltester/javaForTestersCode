package com.javafortesters.chap012inheritance.exercises;

import com.javafortesters.domainentities.User;
import com.javafortesters.domainobject.TestAppEnv;

public class EnvironmentUser extends User {

    public String getUrl(){
        return TestAppEnv.getUrl();
    }
}
