package com.epam.jap;

/**
 * @author Radoslaw Piwowarski
 */
class Dollar extends Money {

    Dollar(int i) {
        amount = i;
    }

    @Override
    Dollar multiply(int i) {
        return new Dollar(amount * i);
    }

}
