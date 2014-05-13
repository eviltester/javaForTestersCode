package com.javafortesters.stringsrevisited;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RegexMatchesTest {

    @Test
    public void checkMatchesFunction(){

        String mustIncludeADigit = ".*[0123456789]+.*";

        assertThat("invalid".matches(mustIncludeADigit), is(false));
        assertThat("Invalid".matches(mustIncludeADigit), is(false));
        assertThat("".matches(mustIncludeADigit), is(false));
        assertThat("   ".matches(mustIncludeADigit), is(false));

        assertThat("12345678".matches(mustIncludeADigit), is(true));
        assertThat("1nvalid".matches(mustIncludeADigit), is(true));
        assertThat("1nval1d".matches(mustIncludeADigit), is(true));
        assertThat("inval1d".matches(mustIncludeADigit), is(true));
        assertThat("invali6".matches(mustIncludeADigit), is(true));


        String mustIncludeUppercase = ".*[A-Z]+.*";

        assertThat("invalid".matches(mustIncludeUppercase), is(false));
        assertThat("".matches(mustIncludeUppercase), is(false));
        assertThat("   ".matches(mustIncludeUppercase), is(false));
        assertThat("12345678".matches(mustIncludeUppercase), is(false));

        assertThat("Valid".matches(mustIncludeUppercase), is(true));
        assertThat("val1D".matches(mustIncludeUppercase), is(true));
        assertThat("vaL1d".matches(mustIncludeUppercase), is(true));
        assertThat("vaLid".matches(mustIncludeUppercase), is(true));
        assertThat("VALID".matches(mustIncludeUppercase), is(true));
    }

}