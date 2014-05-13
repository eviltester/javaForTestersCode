package com.javafortesters.random;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MathRandomTest {

    @Test
    public void canUseRandomMethodOnMath(){

        double rnd = Math.random();

        System.out.println(
            String.format(
                    "generated %f as random number", rnd));

        assertThat(rnd < 1.0d, is(true));
        assertThat(rnd > 0.0d, is(true));
    }


}