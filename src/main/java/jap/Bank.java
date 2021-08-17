package jap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Radoslaw Piwowarski
 */
class Bank {

    private Map<Pair, Integer> rates = new HashMap<>();

    public Money reduce(Expression source, String currency) {
        if (source instanceof Money money) {
            return money;
        }
        Sum sum = (Sum) source;
        return sum.reduce(this, currency);
    }

    void addRate(String source, String target, int rate) {
        rates.put(new Pair(source, target), rate);
    }

    int rate(String source, String targetCurrency) {
        int rate;
        if (source.equals(targetCurrency)) {
            rate = 1;
        } else {
            rate = rates.get(new Pair(source, targetCurrency));
        }
        return rate;
    }
}
