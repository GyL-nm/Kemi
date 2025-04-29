package main.reactions;

public enum ConditionType {
    GREATER_THAN,
    LESSER_THAN,
    EQUAL;

    public boolean condition(double a, double b) {
        if (this == GREATER_THAN) { return a > b; }
        if (this == LESSER_THAN) { return a < b; }
        if (this == EQUAL) { return a == b; }
        return false;
    }
}
