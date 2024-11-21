package reactions;

import substances.SubstanceProperties;

import java.util.HashMap;

public class ReactionReferences extends HashMap<ReactionPair, ResultInfo> {


    ReactionReferences() {
        this.put(new ReactionPair(  SubstanceProperties.CHLORINE,
                                    SubstanceProperties.HYDROGEN, null),
                new ResultInfo(
                        new ReactionType[]{ ReactionType.REDOX,
                                            ReactionType.SYNTHESIS},
                        new SubstanceProperties[]{SubstanceProperties.HYDROCHLORIC_ACID_LIQUID}));

        this.put(new ReactionPair(  SubstanceProperties.HYDROGEN,
                                    SubstanceProperties.OXYGEN, null),
                new ResultInfo(
                        new ReactionType[]{ ReactionType.REDOX,
                                            ReactionType.SYNTHESIS},
                        new SubstanceProperties[]{SubstanceProperties.WATER }));

        this.put(new ReactionPair(  SubstanceProperties.HYDROGEN,
                                    SubstanceProperties.OXYGEN, null),
                new ResultInfo(
                        new ReactionType[]{ ReactionType.REDOX,
                                            ReactionType.SYNTHESIS},
                        new SubstanceProperties[]{SubstanceProperties.WATER }));
    }
}

