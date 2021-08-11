package com.epam.jap;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DollarTest {

    @Test
    void multiplication_WhenMultipliesTwice_NewObjectIsCreated() {
        Money five = Money.dollar(5);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(five.multiply(2)).isEqualTo(Money.dollar(10));
        softAssertions.assertThat(five.multiply(3)).isEqualTo(Money.dollar(15));
        softAssertions.assertAll();
    }

    @Test
    void equals_WhenGivenOfTwoObjectWithTheSameAmount_ResultIsTrue() {
        assertEquals(Money.dollar(5), Money.dollar(5));
    }

    @Test
    void equals_WhenGivenOfTwoObjectWithNotTheSameAmount_ResultIsFalse() {
        assertNotEquals(Money.dollar(5), Money.dollar(10));
    }
}
