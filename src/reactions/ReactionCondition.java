package reactions;

import java.util.concurrent.locks.Condition;

public class ReactionCondition {
    ConditionType condition;

    double conditionValue;
    public ReactionCondition(ConditionType condition, double conditionValue) {
        this.condition = condition;
        this.conditionValue = conditionValue;
    }

    public boolean condition(double a) {
        if (condition == ConditionType.GREATER_THAN) { return a > conditionValue; }
        if (condition == ConditionType.LESSER_THAN) { return a < conditionValue; }
        if (condition == ConditionType.EQUAL) { return a == conditionValue; }
        return false;
    }
}
