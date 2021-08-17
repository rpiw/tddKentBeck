package jap;

/**
 * @author Radoslaw Piwowarski
 */
class Sum implements Expression {
    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    Money augend;
    Money addend;

    @Override
    public Money reduce(Bank bank, String targetCurrency) {
        int amount = addend.reduce(bank, targetCurrency).amount +
                augend.reduce(bank, targetCurrency).amount;
        return new Money(amount, targetCurrency);
    }
}
