package com.epam.jap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.assertj.core.api.SoftAssertions;

class DollarTest {

    @Test
    void multiplication_WhenMultipliesTwice_NewObjectIsCreated() {
        Dollar five = new Dollar(5);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(five.multiply(2)).isEqualTo(new Dollar(10));
        softAssertions.assertThat(five.multiply(3)).isEqualTo(new Dollar(15));
        softAssertions.assertAll();
    }

    @Test
    void equals_WhenGivenOfTwoObjectWithTheSameAmount_ResultIsTrue() {
        assertEquals(new Dollar(5), new Dollar(5));
    }
    @Test
    void equals_WhenGivenOfTwoObjectWithNotTheSameAmount_ResultIsFalse() {
        assertNotEquals(new Dollar(5), new Dollar(10));
    }
}
