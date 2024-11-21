package reactions;

import substances.SubstanceProperties;

public class ResultInfo {
    final private ReactionType[] reactionType;
    final private SubstanceProperties[] results;

    public ResultInfo(ReactionType[] reactionType, SubstanceProperties[] results) {
        this.reactionType = reactionType;
        this.results = results;
    }

    public ReactionType[] getType() { return reactionType; }
    public SubstanceProperties[] getResults() { return results; }
}
