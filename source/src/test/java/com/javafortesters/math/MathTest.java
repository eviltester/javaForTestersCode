package com.javafortesters.math;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MathTest {

    @Test(expected = java.lang.AssertionError.class)
    public void whyBigDecimal(){
        // 10 pence + 73 pence = 83 pence
        float total = 0.1f + 0.73f;
        assertThat(total, is(0.83f));
        // the above assert fails but: was <0.83000004F>
    }

    @Test
    public void usingBigDecimal(){
        BigDecimal bdtotal = new BigDecimal("0.1").add(new BigDecimal("0.73"));
        assertThat(bdtotal, is(new BigDecimal("0.83")));
    }

    @Test
    public void bigDecimalConstructor(){

        BigDecimal fromInt = new BigDecimal(5);
        BigDecimal fromLong = new BigDecimal(5L);
        BigDecimal fromString = new BigDecimal("5");
        BigDecimal fromDouble = new BigDecimal(5.0);
        BigDecimal fromBigInteger = new BigDecimal(BigInteger.valueOf(5L));

        assertThat(fromInt, is(fromLong));
        assertThat(fromString, is(fromDouble));
        assertThat(fromBigInteger, is(fromString));
        assertThat(fromLong, is(fromDouble));
    }

    @Test
    public void bigDecimalStaticMethods(){

       BigDecimal bd0 = BigDecimal.ZERO;
       BigDecimal bd1 = BigDecimal.ONE;
       BigDecimal bd10 = BigDecimal.TEN;
       BigDecimal bdVal = BigDecimal.valueOf(5.0);

       assertThat(bd0, is(new BigDecimal("0")));
       assertThat(bd1, is(new BigDecimal("1")));
       assertThat(bd10, is(BigDecimal.valueOf(10L)));
       assertThat(bdVal, is(new BigDecimal("5.0")));

       assertThat( BigDecimal.ONE.equals(
                       new BigDecimal(1.0)), is(true));
       assertThat( BigDecimal.ONE.equals(
                       new BigDecimal("1")), is(true));
    }

    @Test
    public void bigDecimalGreaterThanLessThan(){

        assertThat(
                BigDecimal.TEN.compareTo(BigDecimal.ONE) > 0
                , is(true));
    }

    @Test
    public void maxTest(){

        assertThat( Math.max(23.0, 42.0), is(42.0));
    }

}