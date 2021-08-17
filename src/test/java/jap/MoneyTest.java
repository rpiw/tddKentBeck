package jap;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MoneyTest {

    @Test
    void multiplication_WhenMultipliesDollar_NewObjectIsCreated() {
        Money five = Money.dollar(5);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(five.times(2)).isEqualTo(Money.dollar(10));
        softAssertions.assertThat(five.times(3)).isEqualTo(Money.dollar(15));
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
        Money five = Money.franck(5);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(five.times(2)).isEqualTo(Money.franck(10));
        softAssertions.assertThat(five.times(3)).isEqualTo(Money.franck(15));
        softAssertions.assertThat(five).isNotEqualTo(Money.franck(123));
        softAssertions.assertAll();
    }

    @Test
    void equals_DollarNotEqualsToFranck() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(Money.dollar(2)).isNotEqualTo(Money.franck(2));
        softAssertions.assertThat(Money.dollar(2)).isNotEqualTo(Money.franck(5));
        softAssertions.assertAll();
    }

    @Test
    void equals_WhenSuperClassWithTheSameCurrencyAsChildClass_CompareCurrencyNotClasses() {
        assertEquals(Money.franck(10), new Money(10, "CHF"));
    }

    @Test
    void add_WhenGivenTheSameCurrency_SimpleAdd() {
        Money dollars = Money.dollar(5);

        assertEquals(Money.dollar(10), dollars.plus(Money.dollar(5)));
    }

    @Test
    void add_WhenGivenDifferentCurrency_SumExpressionFromBank() {
        Money dollar = Money.dollar(5);
        Expression sum = new Sum(dollar, dollar);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    void add_ReturnSumObject() {
        Money dollar = Money.dollar(5);
        Sum sum = new Sum(dollar, dollar);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(dollar).isEqualTo(sum.augend);
        softAssertions.assertThat(dollar).isEqualTo(sum.addend);
        softAssertions.assertAll();
    }

    @Test
    void testReduceMoney() {
        Bank bank = new Bank();
        Money money = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), money);
    }

    @Test
    void testIdentityRate() {
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test
    void reduceMoneyDifferentCurrency() {
        Expression fiveDollars = Money.dollar(5);
        Expression tenFrancs = Money.franck(10);
        var bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        var result = bank.reduce(fiveDollars.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);
    }

}
