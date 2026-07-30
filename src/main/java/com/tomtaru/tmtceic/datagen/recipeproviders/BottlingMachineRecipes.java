package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.BottlingMachineRecipe;
import blusunrize.immersiveengineering.api.crafting.IngredientWithSize;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import blusunrize.immersiveengineering.api.crafting.TagOutputList;
import com.tomtaru.tmtceic.Tmtceic;

import com.tomtaru.tmtceic.registry.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

import java.util.List;

public class BottlingMachineRecipes {

    public static final IngredientWithSize containerBottle = new IngredientWithSize(Ingredient.of(Items.GLASS_BOTTLE), 1);
    public static final IngredientWithSize frameAluminum = new IngredientWithSize(Ingredient.of(ModItems.ALUMINUM_POKEBALL_FRAME.get()), 1);
    public static final IngredientWithSize frameNetherite = new IngredientWithSize(Ingredient.of(ModItems.NETHERITE_POKEBALL_FRAME.get()), 1);
    
    public static final int fluidAmountQuarterBucket = 250;

    public static void build(RecipeOutput output) {

        for (String potion : Dexes.POTIONDEX) {

            ResourceLocation potionItemID = ResourceLocation.fromNamespaceAndPath("cobblemon", potion);
            List<TagOutput> potionItem = List.of(new TagOutput(BuiltInRegistries.ITEM.get(potionItemID)));

            ResourceLocation potionFluidID = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, potion);
            SizedFluidIngredient potionFluid = SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(potionFluidID), fluidAmountQuarterBucket);

            generateBottlingRecipe(output, potionItem, containerBottle, potionFluid, potion);
        }
    }

    /**
     *
     * @param bottlingOutput
     * @param outputItems
     * @param containerItem
     * @param inputFluid
     * @param recipeName
     */

    private static void generateBottlingRecipe(RecipeOutput bottlingOutput, List<TagOutput> outputItems, IngredientWithSize containerItem, SizedFluidIngredient inputFluid, String recipeName) {
        BottlingMachineRecipe recipe = new BottlingMachineRecipe(
                new TagOutputList(outputItems),
                containerItem,
                inputFluid
        );

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "bottling/" + recipeName + "_in_bottling_machine");
        bottlingOutput.accept(id, recipe, null);
    }
}