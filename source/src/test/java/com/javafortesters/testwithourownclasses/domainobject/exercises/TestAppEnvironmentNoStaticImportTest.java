package com.javafortesters.testwithourownclasses.domainobject.exercises;

import com.javafortesters.domainobject.TestAppEnv;
import org.junit.Assert;
import org.junit.Test;

// I could import everything on TestAppEnv statically, and then
// I don't need to prefix getUrl with TestAppEnv
/*
import static com.javafortesters.domainobject.TestAppEnv.*;
*/
// If I just import the DOMAIN and PORT then I still need to
// prefix getUrl with TestAppEnv
import static com.javafortesters.domainobject.TestAppEnv.DOMAIN;
import static com.javafortesters.domainobject.TestAppEnv.PORT;


public class TestAppEnvironmentNoStaticImportTest {

    @Test
    public void canGetUrlStatically(){
        Assert.assertEquals("Returns Hard Coded URL",
                "http://192.123.0.3:67",
                TestAppEnv.getUrl());
    }

    @Test
    public void canGetDomainAndPortStatically(){

        Assert.assertEquals("Just the Domain",
                "192.123.0.3",
                DOMAIN);

        Assert.assertEquals("Just the port",
                "67",
                PORT);
    }
}
