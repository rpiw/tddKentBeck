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

    Money multiply(int i) {
        return new Money(amount * i, currencyCode);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }


    public Expression add(Money money) {
        Expression result;
        if (money.currencyCode.equals(currencyCode)) {
            result = new Money(amount + money.amount, currencyCode);
        } else {
            result = new Sum(this, money);
        }
        return result;
    }



    @Override
    public Money reduce(Bank bank, String targetCurrency) {
        var rate = bank.rate(currencyCode, targetCurrency);
        return new Money(amount / rate, targetCurrency);
    }
}
