package reactions;

import substances.Substance;

public class PhaseChange extends Reaction {
    Class<? extends Substance> reactant;

    public PhaseChange(Class<? extends Substance> reactant, ReactionType[] reactionType, Class<? extends Substance>[] results, double temperatureChange, ReactionCondition[] conditions) {
        super(reactionType, results, temperatureChange, conditions);
        this.reactant = reactant;
    }

    public Class<? extends Substance> reactant() { return reactant; }
}
