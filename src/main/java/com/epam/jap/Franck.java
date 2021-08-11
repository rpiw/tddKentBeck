package com.epam.jap;

/**
 * @author Radoslaw Piwowarski
 */
class Franck extends Money{

    Franck(int i) {
        amount = i;
        currencyCode = "CHF";
    }

    @Override
    Franck multiply(int i) {
        return new Franck(amount * i);
    }
}
