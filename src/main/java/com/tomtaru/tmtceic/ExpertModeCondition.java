package com.tomtaru.tmtceic;

import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.conditions.ICondition;

public class ExpertModeCondition implements ICondition {
    public static final ExpertModeCondition INSTANCE = new ExpertModeCondition();


    public static final MapCodec<ExpertModeCondition> CODEC = MapCodec.unit(INSTANCE);

    private ExpertModeCondition() {}

    @Override
    public boolean test(IContext context) {
        return Config.expertMode;
    }

    @Override
    public MapCodec<? extends ICondition> codec() {
        return CODEC;
    }
}