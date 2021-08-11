package jap;

import java.util.Objects;

/**
 * @author Radoslaw Piwowarski
 */
abstract class Money {
    protected int amount;
    protected String currencyCode;

    static Dollar dollar(int i) {
        return new Dollar(i, "USD");
    }

    static Franck franck(int i) {
        return new Franck(i, "CHF");
    }

    Money (int i, String currency) {
        amount = i;
        currencyCode = currency;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    abstract Money multiply(int i);

    String currency() {
        return currencyCode;
    }
}
