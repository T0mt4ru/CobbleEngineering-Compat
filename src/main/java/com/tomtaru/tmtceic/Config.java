package com.tomtaru.tmtceic;


import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = Tmtceic.MODID)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue EXPERT_MODE = BUILDER
            .comment("Enables Expert Mode. Expert Mode disables regular crafting of pokeballs!")
            .define("expertMode", false);

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean expertMode;


    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        if (event.getConfig().getSpec() == SPEC) {
            expertMode = EXPERT_MODE.get();
        }
    }
}