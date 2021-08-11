package com.epam.jap;

import java.util.Objects;

/**
 * @author Radoslaw Piwowarski
 */
abstract class Money {
    protected int amount;

    public static Dollar dollar(int i) {
        return new Dollar(i);
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

    public abstract Money multiply(int i);
}
