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

import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleFluidRegistrar {

    public record Entry(
            String name,
            DeferredHolder<FluidType, FluidType> type,
            DeferredHolder<Fluid, BaseFlowingFluid.Source> source,
            DeferredHolder<Fluid, BaseFlowingFluid.Flowing> flowing,
            DeferredBlock<AprigelBlock> block,
            int tint
    ) {}

    private final DeferredRegister<FluidType> fluidTypes;
    private final DeferredRegister<Fluid> fluids;
    private final Map<String, Entry> entries = new LinkedHashMap<>();

    public SimpleFluidRegistrar(DeferredRegister<FluidType> fluidTypes, DeferredRegister<Fluid> fluids) {
        this.fluidTypes = fluidTypes;
        this.fluids = fluids;
    }

    public Entry register(String name) {
        return register(name, 0xFFFFFFFF); // no tint by default - texture carries the color
    }

    public Entry register(String name, int tint) {
        DeferredHolder<FluidType, FluidType> type = fluidTypes.register(name, () -> new FluidType(
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
                fluids.register(name, () -> new BaseFlowingFluid.Source(propertiesFor(name)));
        DeferredHolder<Fluid, BaseFlowingFluid.Flowing> flowing =
                fluids.register("flowing_" + name, () -> new BaseFlowingFluid.Flowing(propertiesFor(name)));

        DeferredBlock<AprigelBlock> block =
                Tmtceic.BLOCKS.register(name, () -> new AprigelBlock(() -> source.get()));

        Entry entry = new Entry(name, type, source, flowing, block, tint);
        entries.put(name, entry);
        return entry;
    }

    private BaseFlowingFluid.Properties propertiesFor(String name) {
        return new BaseFlowingFluid.Properties(
                () -> entries.get(name).type().get(),
                () -> entries.get(name).source().get(),
                () -> entries.get(name).flowing().get())
                .explosionResistance(100f)
                .block(() -> entries.get(name).block().get());
    }

    public java.util.Collection<Entry> entries() {
        return entries.values();
    }
}