package reactions;

import substances.Substance;

public class ReactionResult {
    private Substance[] results;
    private ReactionType reaction;

    private ReactionReferences reactionReferences = new ReactionReferences();

    public ReactionResult(Substance[] results, ReactionType reaction) {
        this.reaction = reaction;
        this.results = results;
    }

    public Substance[] getResults() { return results; }
    public ReactionType getReaction() { return reaction; }
}
