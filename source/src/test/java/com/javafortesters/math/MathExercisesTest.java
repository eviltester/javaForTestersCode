package com.javafortesters.math;


import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class MathExercisesTest {

    @Test
    public void convinceYourselfOfBigDecimalUsage(){

        try{
            double total = 5 - 0.3 - 0.47 - 1.73;
            System.out.println("2.5 != " + total);
            assertThat(total, is(2.5));
            fail("Expected the assert to fail");

        }catch(java.lang.AssertionError e){}

        int inPennies = 500 - 30 - 47 - 173;
        assertThat(inPennies, is(250));

        BigDecimal bdTotal = new BigDecimal("5").
                        subtract(new BigDecimal("0.30")).
                        subtract(new BigDecimal(("0.47"))).
                        subtract(new BigDecimal("1.73"));
        assertThat(bdTotal, is(new BigDecimal("2.50")));
    }

    @Test
    public void basicArithmeticWithBigDecimal(){

        BigDecimal bd = BigDecimal.ZERO;
        bd = bd.add(BigDecimal.TEN);
        bd = bd.multiply(BigDecimal.valueOf(2L));
        bd = bd.subtract((BigDecimal.TEN));
        bd = bd.divide(BigDecimal.valueOf(2L));

        assertThat(bd, is(BigDecimal.valueOf(5L)));
    }


    @Test
    public void bigDecimalCompareTenAndOne(){
        assertTrue( BigDecimal.TEN.compareTo(BigDecimal.ONE) > 0);
        assertTrue( BigDecimal.ONE.compareTo(BigDecimal.TEN) < 0);
        assertTrue( BigDecimal.TEN.compareTo(BigDecimal.TEN) == 0);
        assertTrue( BigDecimal.TEN.compareTo(BigDecimal.ONE) != 0);
        assertTrue( BigDecimal.TEN.compareTo(BigDecimal.ONE) >= 0);
        assertTrue( BigDecimal.TEN.compareTo(BigDecimal.TEN) >= 0 );
        assertTrue( BigDecimal.TEN.compareTo(BigDecimal.TEN) <= 0);
        assertTrue( BigDecimal.ONE.compareTo(BigDecimal.TEN) <= 0);
    }
}