package com.epam.jap;

import java.util.Objects;

/**
 * @author Radoslaw Piwowarski
 */
class Franck {
    private final int amount;

    public Franck(int i) {
        amount = i;
    }

    public Franck multiply(int i) {
        return new Franck(amount * i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Franck franck = (Franck) o;
        return amount == franck.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
