package com.epam.jap;

import java.util.Objects;

/**
 * @author Radoslaw Piwowarski
 */
class Dollar {
    private final int amount;

    public Dollar(int i) {
        amount = i;
    }

    public Dollar multiply(int i) {
        return new Dollar(amount * i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dollar dollar = (Dollar) o;
        return amount == dollar.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
