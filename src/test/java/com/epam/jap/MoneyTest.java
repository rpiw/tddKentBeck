package com.epam.jap;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MoneyTest {

    @Test
    void multiplication_WhenMultipliesDollar_NewObjectIsCreated() {
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

    @Test
    void multiplication_WhenMultipliesFranck_NewObjectIsCreated() {
        Franck five = new Franck(5);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(five.multiply(2)).isEqualTo(new Franck(10));
        softAssertions.assertThat(five.multiply(3)).isEqualTo(new Franck(15));
        softAssertions.assertThat(five).isNotEqualTo(new Franck(123));
        softAssertions.assertAll();
    }

    @Test
    void equals_DollarNotEqualsToFranck() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(new Dollar(2)).isNotEqualTo(new Franck(2));
        softAssertions.assertThat(new Dollar(2)).isNotEqualTo(new Franck(5));
        softAssertions.assertAll();
    }
}
