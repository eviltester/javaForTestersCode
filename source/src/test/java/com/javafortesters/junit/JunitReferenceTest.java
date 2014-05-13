package com.javafortesters.junit;

import com.javafortesters.domainentities.interim.exceptions.custom.InvalidPassword;
import com.javafortesters.domainentities.interim.exceptions.custom.User;
import org.junit.*;
import org.junit.Assert.*;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;


public class JunitReferenceTest {

    @BeforeClass
    public static void runOncePerClassBeforeAnyTests(){
        System.out.println("@BeforeClass method");
    }

    @Before
    public void runBeforeEveryTestMethod(){
        System.out.println("@Before each method");
    }

    @Test
    public void thisTestWillNeverFail(){
    }

    @Test(expected=InvalidPassword.class)
    public void expectInvalidPasswordException() throws InvalidPassword {
        User user = new User("username", "<6");
    }


    @Test
    public void junitHasAssertions(){
        assertEquals(6, 3 + 3);
        assertEquals("3 + 3 = 6", 6, 3 + 3);

        assertFalse("false is false", false);
        assertFalse(false);

        assertTrue("true is true", true);
        assertTrue(true);

        int [] oneTo10 = {1,2,3,4,5,6,7,8,9,10};
        int [] tenToOne = {10,9,8,7,6,5,4,3,2,1};
        Arrays.sort(tenToOne);
        assertArrayEquals(oneTo10, tenToOne);

        assertNotNull("An empty string is not null", "");
        assertNotNull("");

        assertNotSame("An empty string is not null", null, "");
        assertNotSame(null, "");

        assertNull("Only null is null", null);
        assertNull(null);

        assertSame("Only null is null", null, null);
        assertSame(null, null);
    }


    @Test
    public void assertThatWithHamcrestMatchers(){

        assertThat(3 + 3, is(6));
        assertThat("3 + 3 = 6", 3 + 3, is(6));

        assertThat("false is false", false, equalTo(false));
        assertThat(false, is(false));

        assertThat("true is true", true, equalTo(true));
        assertThat(true, is(true));

        int [] oneTo10 = {1,2,3,4,5,6,7,8,9,10};
        int [] tenToOne = {10,9,8,7,6,5,4,3,2,1};
        Arrays.sort(tenToOne);
        assertThat(oneTo10, equalTo(tenToOne));

        assertThat("An empty string is not null", "",
                                is(not(nullValue())));
        assertThat("", is(not(nullValue())));
        assertThat("",is(notNullValue()));

        assertThat("Only null is null", null, is(nullValue()));
        assertThat(null, nullValue());
    }


    @Test
    public void useTheListedHamcrestMatchers(){

        assertThat(3, is(equalTo(3)));
        assertThat(3, is(not(4)));
        assertThat("This is a string", containsString("is"));
        assertThat("This is a string", endsWith("string"));
        assertThat("This is a string", startsWith("This is"));
     }

    @Test(expected=AssertionError.class)
    public void junitFailWithDescription(){
        fail("fail always fails");
    }

    @Test(expected=AssertionError.class)
    public void junitFailWithoutDescription(){
        fail();
    }

    @Ignore
    @Test
    public void thisTestIsIgnored(){
        throw new NullPointerException();
    }

    @Ignore("Because it is not finished yet")
    @Test
    public void thisTestIsIgnoredBecauseItIsNotFinished(){
    }

    @After
    public void runAfterEveryTestMethod(){
        System.out.println("@After each method");
    }

    @AfterClass
    public static void runOncePerClassAfterAllTests(){
        System.out.println("@AfterClass method");
    }
}