package jap;

/**
 * @author Radoslaw Piwowarski
 */
class Franck extends Money{

    Franck (int i, String currency) {
        super(i, currency);
    }

    @Override
    Franck multiply(int i) {
        return Money.franck(amount * i);
    }
}
