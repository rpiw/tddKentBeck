package jap;

/**
 * @author Radoslaw Piwowarski
 */
interface Expression {
    Money reduce(Bank bank, String targetCurrency);
}
