package reactions;

import substances.Substance;

public class Reaction {
    final private ReactionType[] reactionType;
    final private ReactionCondition[] conditions;

    final private Class<? extends Substance>[] results;
    final private double temperatureChange;

    public Reaction(ReactionType[] reactionType, Class<? extends Substance>[] results, double temperatureChange, ReactionCondition[] conditions) {
        this.reactionType = reactionType;
        this.results = results;
        this.temperatureChange = temperatureChange;
        this.conditions = conditions;
    }

    public ReactionCondition[] conditions() { return conditions; }

    public Class<? extends Substance>[] results() { return results; }

    public double temperatureChange() { return temperatureChange; }
}
