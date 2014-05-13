package com.javafortesters.myfirsttest.exercises;

import com.javafortesters.domainentities.interim.composition.exercises.User;
import com.javafortesters.domainentities.interim.composition.exercises.UserStaticComposition;
import com.javafortesters.domainobject.TestAppEnv;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class InheritanceOrCompositionExercisesTest {

    @Test
    public void canComposeUserWithNewTestAppEnv(){
        User user = new User();
        assertThat(user.getUrl(), is(TestAppEnv.getUrl()));
    }

    @Test
    public void canComposeUserWithStaticTestAppEnv(){
        UserStaticComposition user = new UserStaticComposition();
        assertThat(user.getUrl(), is(TestAppEnv.getUrl()));
    }
}