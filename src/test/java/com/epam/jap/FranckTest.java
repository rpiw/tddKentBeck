package com.epam.jap;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class FranckTest {
    @Test
    void multiplication_WhenMultipliesTwice_NewObjectIsCreated() {
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
