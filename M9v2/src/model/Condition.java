package model;

/**
 * Created by Daniel_RICE on 21/10/2016.
 */
public enum Condition {
    SAFE("Safe"), TREATABLE("Treatable"), UNSAFE("Unsafe");

    private final String condition;

    Condition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public String toString() {
        return condition;
    }
}

