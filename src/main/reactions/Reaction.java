package main.reactions;

import main.substances.Substance;

public class Reaction {
    final private Class<? extends Substance> reactant;
    final private ReactionType[] reactionType;
    final private ReactionCondition[] conditions;

    final private Class<? extends Substance>[] results;
    final private double temperatureChange;

    public Reaction(Class<? extends Substance> reactant, ReactionType[] reactionType, Class<? extends Substance>[] results, double temperatureChange, ReactionCondition[] conditions) {
        this.reactant = reactant;
        this.reactionType = reactionType;
        this.results = results;
        this.temperatureChange = temperatureChange;
        this.conditions = conditions;
    }

    public Class<? extends Substance> reactant() { return reactant; }
    public ReactionType[] type() { return reactionType; }
    public ReactionCondition[] conditions() { return conditions; }

    public Class<? extends Substance>[] results() { return results; }
    public double temperatureChange() { return temperatureChange; }
}
