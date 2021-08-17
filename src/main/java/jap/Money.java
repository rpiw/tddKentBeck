package jap;

import java.util.Objects;

/**
 * @author Radoslaw Piwowarski
 */
class Money implements Expression {
    protected int amount;
    protected String currencyCode;

    static Money dollar(int i) {
        return new Money(i, "USD");
    }

    static Money franck(int i) {
        return new Money(i, "CHF");
    }

    Money(int i, String currency) {
        amount = i;
        currencyCode = currency;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Money money = (Money) o;
        return amount == money.amount && money.currencyCode.equals(currencyCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }


    @Override
    public Money reduce(Bank bank, String targetCurrency) {
        var rate = bank.rate(currencyCode, targetCurrency);
        return new Money(amount / rate, targetCurrency);
    }

    @Override
    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currencyCode);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }
}
