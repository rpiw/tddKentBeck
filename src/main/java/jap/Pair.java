package jap;

import java.util.Objects;

/**
 * @author Radoslaw Piwowarski
 */
class Pair {
    private final String source;
    private final String target;


    Pair(String source, String target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(source, pair.source) && Objects.equals(target, pair.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target);
    }
}
