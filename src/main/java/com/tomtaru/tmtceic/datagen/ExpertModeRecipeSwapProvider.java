package com.tomtaru.tmtceic.datagen;

import com.cobblemon.mod.common.CobblemonItems;
import com.tomtaru.tmtceic.datagen.recipeproviders.Dexes;
import com.tomtaru.tmtceic.datagen.recipeproviders.ExpertModeRecipeSwap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ExpertModeRecipeSwapProvider implements DataProvider {

    private final PackOutput packOutput;

    public ExpertModeRecipeSwapProvider(PackOutput packOutput) {
        this.packOutput = packOutput;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        List<CompletableFuture<?>> futures = new ArrayList<>();

        for (Dexes.AllPokeBalls entry : Dexes.ALLPOKEBALLDEX) {
            String path = BuiltInRegistries.ITEM.getKey(entry.pokeballs()).getPath();
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath("cobblemon", path);
            futures.add(ExpertModeRecipeSwap.apply(cache, packOutput, CobblemonItems.class, id));
        }

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }

    @Override
    public String getName() {
        return "tmtceic Expert Mode Recipe Swap";
    }
}