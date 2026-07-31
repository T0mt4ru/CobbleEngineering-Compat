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
    public static final int fluidAmountEighthBucket = 125;


    public static void build(RecipeOutput output) {

        for (String potion : Dexes.POTIONDEX) {

            ResourceLocation potionItemID = ResourceLocation.fromNamespaceAndPath("cobblemon", potion);
            List<TagOutput> potionItem = List.of(new TagOutput(BuiltInRegistries.ITEM.get(potionItemID)));

            ResourceLocation potionFluidID = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, potion);
            SizedFluidIngredient potionFluid = SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(potionFluidID), fluidAmountQuarterBucket);

            generateBottlingRecipe(output, potionItem, containerBottle, potionFluid, "potions/" + potion);
        }

        for (String ball : Dexes.APRIDEX) {
            ResourceLocation ballItemID = ResourceLocation.fromNamespaceAndPath("cobblemon", Dexes.APRICORN_TO_BALL.get(ball) + "_ball");
            List<TagOutput> ballItem = List.of(new TagOutput(BuiltInRegistries.ITEM.get(ballItemID)));

            ResourceLocation aprigelID = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, ball + "_aprigel");
            SizedFluidIngredient aprigel = SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(aprigelID), fluidAmountEighthBucket);

            generateBottlingRecipe(output, ballItem, frameAluminum, aprigel, "balls/" + Dexes.APRICORN_TO_BALL.get(ball) + "_ball_from_frame");
        }

        for (String ball : Dexes.ADVANCEDBALLDEX) {
            ResourceLocation ballItemID = ResourceLocation.fromNamespaceAndPath("cobblemon", ball + "_ball");
            List<TagOutput> ballItem = List.of(new TagOutput(BuiltInRegistries.ITEM.get(ballItemID)));

            ResourceLocation frameID = ResourceLocation.fromNamespaceAndPath("cobblemon", Dexes.ADVANCEDBALL_TO_FRAME.get(ball) + "_ball");
            IngredientWithSize frameItem = new IngredientWithSize(Ingredient.of(BuiltInRegistries.ITEM.get(frameID)), 1);

            ResourceLocation aprigelID = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID,  Dexes.ADVANCEDBALL_TO_SPRAY.get(ball) + "_aprigel");
            SizedFluidIngredient aprigel = SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(aprigelID), fluidAmountEighthBucket);

            generateBottlingRecipe(output, ballItem, frameItem, aprigel, "balls/"+ ball + "_ball_from_" + Dexes.ADVANCEDBALL_TO_FRAME.get(ball));
        }
    }

    /**
     *
     * @param bottlingOutput    - recipeoutput
     * @param outputItems       - output of the bottler, as a list, even o single items.
     * @param containerItem     - Item to be used as a "container"
     * @param inputFluid        - What fluid do we use?
     * @param recipeName        - What do we call this recipe?
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