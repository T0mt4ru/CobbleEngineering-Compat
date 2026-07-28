package com.tomtaru.tmtceic;

import com.mojang.logging.LogUtils;
import com.tomtaru.tmtceic.registry.ModAprigels;
import com.tomtaru.tmtceic.registry.ModItems;
import com.tomtaru.tmtceic.registry.ModMedicinals;
import com.tomtaru.tmtceic.registry.SimpleFluidRegistrar;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

@Mod(Tmtceic.MODID)
public class Tmtceic {
    // Define mod id
    public static final String MODID = "tmtceic";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    // Create a Deferred Register to hold Items
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    // Create a Deferred Register to hold CreativeModeTabs
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public Tmtceic(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);


        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        ModAprigels.FLUIDS.register(modEventBus);
        ModAprigels.FLUID_TYPES.register(modEventBus);
        ModMedicinals.FLUIDS.register(modEventBus);
        ModMedicinals.FLUID_TYPES.register(modEventBus);
        ModItems.register();


        CREATIVE_MODE_TABS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Tomtaru's Cobblemon & Immersive Engineering Tweaks Loaded!");
        LOGGER.info("That is such an unneeded lengthy name, isn't it?");
    }


    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ALUMINUM_POKEBALL_FRAME);
            event.accept(ModItems.NETHERITE_POKEBALL_FRAME);
            event.accept(ModItems.MOLD_POKEBALL_FRAME);
            event.accept(ModItems.MOON_STONE_DUST);
            event.accept(ModItems.SUN_STONE_DUST);
            event.accept(ModItems.SHINY_STONE_DUST);
        }

        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            //event.accept(ModItems.WHEAT_FLOUR);
        }

    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }

    @EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerFluidTypeExtensions(RegisterClientExtensionsEvent event) {
            for (ModAprigels.AprigelEntry entry : ModAprigels.entries()) {
                FluidTexture(event, entry.type(), "block/aprigel_still", "block/apple_cider_flow", entry.tint());
            }

            for (SimpleFluidRegistrar.Entry entry : ModMedicinals.entries()) {
                FluidTexture(event, entry.type(),
                        "block/" + entry.name() + "_still",
                        "block/" + entry.name() + "_flow",
                        0xFFFFFFFF); // no tint, unique texture per potion
            }
        }

        private static void FluidTexture(RegisterClientExtensionsEvent event, DeferredHolder<FluidType, FluidType> type,
                                         String stillPath, String flowPath, int tint) {
            event.registerFluidType(new IClientFluidTypeExtensions() {
                private final ResourceLocation still = ResourceLocation.fromNamespaceAndPath(MODID, stillPath);
                private final ResourceLocation flow = ResourceLocation.fromNamespaceAndPath(MODID, flowPath);
                @Override public ResourceLocation getStillTexture() { return still; }
                @Override public ResourceLocation getFlowingTexture() { return flow; }
                @Override public int getTintColor() { return tint; }
            }, type.get());
        }
    }
}
