package jap;

/**
 * @author Radoslaw Piwowarski
 */
class Dollar extends Money {

    Dollar (int i, String currency) {
        super(i, currency);
    }

    @Override
    Dollar multiply(int i) {
        return Money.dollar(amount * i);
    }

}
