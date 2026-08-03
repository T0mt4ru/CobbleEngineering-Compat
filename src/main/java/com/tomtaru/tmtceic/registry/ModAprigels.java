package com.tomtaru.tmtceic.registry;

import com.tomtaru.tmtceic.Tmtceic;
import com.tomtaru.tmtceic.block.AprigelBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class ModAprigels {

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, Tmtceic.MODID);
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(Registries.FLUID, Tmtceic.MODID);

    public record AprigelEntry(
            DeferredHolder<FluidType, FluidType> type,
            DeferredHolder<Fluid, BaseFlowingFluid.Source> source,
            DeferredHolder<Fluid, BaseFlowingFluid.Flowing> flowing,
            DeferredBlock<AprigelBlock> block,
            int tint
    ) {}

    private static final Map<String, AprigelEntry> ENTRIES = new LinkedHashMap<>();

    // ARGB ints - alpha first byte must be FF or it renders invisible/transparent
    // public static final AprigelEntry APRIGEL        = register("aprigel", 0xFFFFFFFF);
    public static final AprigelEntry RED_APRIGEL        = register("red_aprigel",       0xFFE22D24);
    public static final AprigelEntry YELLOW_APRIGEL     = register("yellow_aprigel",    0xFFE5A817);
    public static final AprigelEntry GREEN_APRIGEL      = register("green_aprigel",     0xFF35A310);
    public static final AprigelEntry BLUE_APRIGEL       = register("blue_aprigel",      0xFF186EE5);
    public static final AprigelEntry PINK_APRIGEL       = register("pink_aprigel",      0xFFDF5291);
    public static final AprigelEntry WHITE_APRIGEL      = register("white_aprigel",     0xFFDEDEE2);
    public static final AprigelEntry BLACK_APRIGEL      = register("black_aprigel",     0xFF3D4353);
    public static final AprigelEntry STELLAR_APRIGEL    = register("stellar_aprigel",   0xFF6F2DA8);

    public static Collection<AprigelEntry> entries() {
        return ENTRIES.values();
    }

    private static AprigelEntry register(String name, int tint) {
        DeferredHolder<FluidType, FluidType> type = FLUID_TYPES.register(name, () -> new FluidType(
                FluidType.Properties.create()
                        .fallDistanceModifier(0F)
                        .canExtinguish(true)
                        .supportsBoating(true)
                        .canHydrate(true)
                        .motionScale(0.007D)
                        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                        .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                        .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)
        ));

        DeferredHolder<Fluid, BaseFlowingFluid.Source> source =
                FLUIDS.register(name, () -> new BaseFlowingFluid.Source(propertiesFor(name)));
        DeferredHolder<Fluid, BaseFlowingFluid.Flowing> flowing =
                FLUIDS.register("flowing_" + name, () -> new BaseFlowingFluid.Flowing(propertiesFor(name)));

        DeferredBlock<AprigelBlock> block =
                Tmtceic.BLOCKS.register(name, () -> new AprigelBlock(() -> source.get()));

        AprigelEntry entry = new AprigelEntry(type, source, flowing, block, tint);
        ENTRIES.put(name, entry);
        return entry;
    }


    private static BaseFlowingFluid.Properties propertiesFor(String name) {
        return new BaseFlowingFluid.Properties(
                () -> ENTRIES.get(name).type().get(),
                () -> ENTRIES.get(name).source().get(),
                () -> ENTRIES.get(name).flowing().get())
                .explosionResistance(100f)
                .block(() -> ENTRIES.get(name).block().get());
    }
}