package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.IngredientWithSize;
import blusunrize.immersiveengineering.api.crafting.SqueezerRecipe;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import com.cobblemon.mod.common.CobblemonItems;
import com.tomtaru.tmtceic.Tmtceic;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;


import java.util.ArrayList;
import java.util.List;

public class SqueezerRecipes {

    public static final int energyStandard = 3200;

    private static final String[] APRIGELDEX = {
            "red", "yellow", "blue", "black", "pink", "green", "white"
    };

    private record TMTSqueezing(
            IngredientWithSize input,
            ResourceLocation fluidID, int fluidAmount,
            TagOutput itemOutput,
            int energy,
            String recipeName
    ) {}
    public static void build(RecipeOutput output) {

        for (String aprigel : APRIGELDEX) {
            ResourceLocation apricornID = ResourceLocation.fromNamespaceAndPath("cobblemon", aprigel + "_apricorn");
            ResourceLocation aprigelID = ResourceLocation.fromNamespaceAndPath("tmtceic", aprigel + "_aprigel");
            ResourceLocation dyeID = ResourceLocation.fromNamespaceAndPath("minecraft", aprigel +"_dye");

            TMTSqueezing recipe = new TMTSqueezing(
                    new IngredientWithSize(Ingredient.of(BuiltInRegistries.ITEM.get(apricornID)), 1),
                            aprigelID, 250,
                            new TagOutput(new IngredientWithSize(Ingredient.of(BuiltInRegistries.ITEM.get(dyeID)), 1)),
                            energyStandard,
                            aprigel + "_aprigel"
            );

            generateSqueezerRecipe(output, recipe);
        }
    }

    private static void generateSqueezerRecipe(RecipeOutput output, TMTSqueezing data) {
        Fluid fluid = BuiltInRegistries.FLUID.get(data.fluidID());
        FluidStack fluidOutput = new FluidStack(fluid, data.fluidAmount());

        SqueezerRecipe recipe = new SqueezerRecipe(fluidOutput, data.itemOutput(), data.input(), data.energy());

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "squeezer/" + data.recipeName());
        output.accept(id, recipe, null);
    }


}