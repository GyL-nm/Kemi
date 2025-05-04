package reactions;

import substances.Substance;

public class ElectrolysisReaction extends Reaction {
    Class<? extends Substance> facilitator;

    public ElectrolysisReaction(Class<? extends Substance> facilitator, Class<? extends Substance>[] results, double temperatureChange, ReactionCondition[] conditions) {
        super(new ReactionType[]{ReactionType.ELECTROLYSIS}, results, temperatureChange, conditions);
        this.facilitator = facilitator;
    }

    public Class<? extends Substance> facilitator() {
        return facilitator;
    }
}
