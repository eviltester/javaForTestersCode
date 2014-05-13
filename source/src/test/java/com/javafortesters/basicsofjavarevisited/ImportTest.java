package com.javafortesters.basicsofjavarevisited;

import com.javafortesters.classes.*;
import com.javafortesters.domainentities.User;
import org.junit.Test;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;

public class ImportTest {

    @org.junit.Test
    public void nonImportTest(){
        org.junit.Assert.assertEquals(3, 2 + 1);
    }

    @Test
    public void importClassNameTest(){
        User user = new User();
        // no assert needed for docs
    }

    @Test
    public void importClassWithWildcard(){
        AClassWithAMethod aClass = new AClassWithAMethod();
        AnEmptyClass emptyClass = new AnEmptyClass();
        // no assert needed for docs
    }

    @Test
    public void nonStaticImport(){
        Assert.assertEquals(5,3+2);
        assertEquals(6,3+3);
    }

}