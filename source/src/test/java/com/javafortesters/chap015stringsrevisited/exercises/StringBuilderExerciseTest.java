package com.javafortesters.chap015stringsrevisited.exercises;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringBuilderExerciseTest {

    @Test
    public void capacitySizeIncreasesAutomaticallyWithAppend(){
        StringBuilder builder = new StringBuilder(5);
        assertThat(builder.capacity(), is(5));
        builder.append("Hello World");
        assertThat(builder.capacity() > 5, is(true));
    }

    @Test
    public void writeATestToInsert(){

        StringBuilder builder = new StringBuilder();

        // insert at start
        builder.insert(0,"a");
        assertThat(builder.toString(), is("a"));

        // insert to end
        builder.insert(builder.toString().length(),"b");
        assertThat(builder.toString(), is("ab"));

        // insert to middle
        builder.insert(1,".");
        assertThat(builder.toString(), is("a.b"));
    }
}