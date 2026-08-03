package com.tomtaru.tmtceic.datagen;

import com.tomtaru.tmtceic.datagen.recipeproviders.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        VanillaRecipes.build(output);
        FermenterRecipes.build(output);
        MixerRecipes.build(output);
        BottlingMachineRecipes.build(output);
        ClocheRecipes.build(output);
        CrusherRecipes.build(output);
        MetalPressRecipes.build(output);
        SawmillRecipes.build(output);
        SqueezerRecipes.build(output);
        BlueprintRecipes.build(output);
        ThermoelectricRecipes.build(output);
        RefineryRecipes.build(output);
    }
}