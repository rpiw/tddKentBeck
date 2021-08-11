package com.epam.jap;

/**
 * @author Radoslaw Piwowarski
 */
class Dollar extends Money {

    public Dollar(int i) {
        amount = i;
    }

    public Dollar multiply(int i) {
        return new Dollar(amount * i);
    }

}
