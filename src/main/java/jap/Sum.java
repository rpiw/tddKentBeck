package jap;

/**
 * @author Radoslaw Piwowarski
 */
class Sum implements Expression {


    final Expression augend;
    final Expression addend;

    Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }


    @Override
    public Money reduce(Bank bank, String targetCurrency) {
        int amount = addend.reduce(bank, targetCurrency).amount +
                augend.reduce(bank, targetCurrency).amount;
        return new Money(amount, targetCurrency);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }
}
