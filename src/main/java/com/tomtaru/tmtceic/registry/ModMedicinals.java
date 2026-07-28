package com.tomtaru.tmtceic.registry;

import com.tomtaru.tmtceic.Tmtceic;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Collection;

public class ModMedicinals {

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, Tmtceic.MODID);
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(Registries.FLUID, Tmtceic.MODID);

    private static final SimpleFluidRegistrar REGISTRAR = new SimpleFluidRegistrar(FLUID_TYPES, FLUIDS);

    public static final SimpleFluidRegistrar.Entry ANTIDOTE         = REGISTRAR.register("antidote");
    public static final SimpleFluidRegistrar.Entry AWAKENING        = REGISTRAR.register("awakening");
    public static final SimpleFluidRegistrar.Entry BURN_HEAL        = REGISTRAR.register("burn_heal");
    public static final SimpleFluidRegistrar.Entry ELIXIR           = REGISTRAR.register("elixir");
    public static final SimpleFluidRegistrar.Entry ETHER            = REGISTRAR.register("ether");
    public static final SimpleFluidRegistrar.Entry FULL_HEAL        = REGISTRAR.register("full_heal");
    public static final SimpleFluidRegistrar.Entry FULL_RESTORE     = REGISTRAR.register("full_restore");
    public static final SimpleFluidRegistrar.Entry HYPER_POTION     = REGISTRAR.register("hyper_potion");
    public static final SimpleFluidRegistrar.Entry ICE_HEAL         = REGISTRAR.register("ice_heal");
    public static final SimpleFluidRegistrar.Entry MAX_ELIXIR       = REGISTRAR.register("max_elixir");
    public static final SimpleFluidRegistrar.Entry MAX_ETHER        = REGISTRAR.register("max_ether");
    public static final SimpleFluidRegistrar.Entry MAX_POTION       = REGISTRAR.register("max_potion");
    public static final SimpleFluidRegistrar.Entry MEDICINAL_BREW   = REGISTRAR.register("medicinal_brew");
    public static final SimpleFluidRegistrar.Entry PARALYZE_HEAL    = REGISTRAR.register("paralyze_heal");
    public static final SimpleFluidRegistrar.Entry POTION           = REGISTRAR.register("potion");
    public static final SimpleFluidRegistrar.Entry SUPER_POTION     = REGISTRAR.register("super_potion");
    public static final SimpleFluidRegistrar.Entry THROAT_SPRAY     = REGISTRAR.register("throat_spray");

    public static Collection<SimpleFluidRegistrar.Entry> entries() {
        return REGISTRAR.entries();
    }
}