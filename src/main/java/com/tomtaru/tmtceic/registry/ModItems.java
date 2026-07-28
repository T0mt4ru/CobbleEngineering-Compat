package com.tomtaru.tmtceic.registry;

import com.tomtaru.tmtceic.Tmtceic;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItems {
    public static void register() {
    }

    public static final DeferredItem<Item> ALUMINUM_POKEBALL_FRAME  = Tmtceic.ITEMS.registerSimpleItem("aluminum_pokeball_frame");
    public static final DeferredItem<Item> NETHERITE_POKEBALL_FRAME = Tmtceic.ITEMS.registerSimpleItem("netherite_pokeball_frame");
    public static final DeferredItem<Item> MOLD_POKEBALL_FRAME      = Tmtceic.ITEMS.registerSimpleItem("mold_pokeball_frame");
    public static final DeferredItem<Item> MOON_STONE_DUST          = Tmtceic.ITEMS.registerSimpleItem("moon_stone_dust");
    public static final DeferredItem<Item> SHINY_STONE_DUST         = Tmtceic.ITEMS.registerSimpleItem("shiny_stone_dust");
    public static final DeferredItem<Item> SUN_STONE_DUST           = Tmtceic.ITEMS.registerSimpleItem("sun_stone_dust");


}