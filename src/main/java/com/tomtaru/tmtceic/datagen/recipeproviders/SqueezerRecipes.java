package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.IngredientWithSize;
import blusunrize.immersiveengineering.api.crafting.SqueezerRecipe;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import com.tomtaru.tmtceic.Tmtceic;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.fluids.FluidStack;

public class SqueezerRecipes {

    private static final int energyStandard = 3200;
    private static final int fluidAmountEighthBucket = 125;

    public static void build(RecipeOutput output) {

        for (String aprigel : Dexes.APRIDEX) {

            ResourceLocation apricornID = ResourceLocation.fromNamespaceAndPath("cobblemon", aprigel + "_apricorn");
            IngredientWithSize apricornItem = new IngredientWithSize(Ingredient.of(BuiltInRegistries.ITEM.get(apricornID)), 1);

            ResourceLocation aprigelID = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, aprigel + "_aprigel");
            FluidStack aprigelFluid = new FluidStack(BuiltInRegistries.FLUID.get(aprigelID), fluidAmountEighthBucket);

            ResourceLocation dyeID = ResourceLocation.fromNamespaceAndPath("minecraft", aprigel +"_dye");
            TagOutput dyeItem = new TagOutput(BuiltInRegistries.ITEM.get(dyeID));

            String recipeName = aprigel + "_aprigel";

            generateSqueezerRecipe(output, apricornItem, aprigelFluid, dyeItem, energyStandard, recipeName);
        }

        for (String mint : Dexes.MINTDEX) {

            ResourceLocation seedID = ResourceLocation.fromNamespaceAndPath("cobblemon", mint + "_mint_seeds");
            IngredientWithSize seedItem = new IngredientWithSize(Ingredient.of(BuiltInRegistries.ITEM.get(seedID)), 1);

            ResourceLocation plantoilID = ResourceLocation.fromNamespaceAndPath("immersiveengineering", "plantoil");
            FluidStack plantoilFluid = new FluidStack(BuiltInRegistries.FLUID.get(plantoilID), 80);

            String recipeName = "plantoil_from_" +  mint + "_mint_seeds";

            generateSqueezerRecipe(output, seedItem, plantoilFluid, TagOutput.EMPTY, energyStandard, recipeName);
        }
    }

    private static void generateSqueezerRecipe(RecipeOutput recipeOutput, IngredientWithSize inputItem, FluidStack outputFluid, TagOutput outputItem, int energy, String recipeName) {

        SqueezerRecipe recipe = new SqueezerRecipe(
                outputFluid,
                outputItem,
                inputItem,
                energy
        );

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "squeezer/" + recipeName);
        recipeOutput.accept(id, recipe, null);
    }


}