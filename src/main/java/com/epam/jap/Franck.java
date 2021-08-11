package com.epam.jap;

/**
 * @author Radoslaw Piwowarski
 */
class Franck extends Money{

    public Franck(int i) {
        amount = i;
    }

    public Franck multiply(int i) {
        return new Franck(amount * i);
    }
}
