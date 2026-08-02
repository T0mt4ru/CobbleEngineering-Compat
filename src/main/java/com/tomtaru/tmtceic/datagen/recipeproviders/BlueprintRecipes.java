package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.BlueprintCraftingRecipe;
import blusunrize.immersiveengineering.api.crafting.IngredientWithSize;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import blusunrize.immersiveengineering.common.register.IEItems;
import com.cobblemon.mod.common.CobblemonItems;

import com.tomtaru.tmtceic.Tmtceic;
import com.tomtaru.tmtceic.registry.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;

import net.minecraft.world.item.crafting.Ingredient;


import java.util.List;

public class BlueprintRecipes {

    public static void build(RecipeOutput output) {

        generateBlueprintRecipe(
                output,
                new TagOutput(ModItems.MOLD_POKEBALL_FRAME, 1),
                List.of(
                        new IngredientWithSize(Ingredient.of(TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath("c", "plates/steel"))), 3),
                        new IngredientWithSize(Ingredient.of(IEItems.Tools.WIRECUTTER.get()), 1)
                        ),
                "molds",
                "mold_pokeball"
        );

        for (String colour : Dexes.APRIDEX) {

            ResourceLocation ballID = ResourceLocation.fromNamespaceAndPath("cobblemon", Dexes.APRICORN_TO_ANCIENTBALL.get(colour) + "_ball");
            TagOutput ballItem = new TagOutput(BuiltInRegistries.ITEM.get(ballID), 4);

            ResourceLocation apricornID = ResourceLocation.fromNamespaceAndPath("cobblemon",  colour + "_apricorn");
            List<IngredientWithSize> ingredients = List.of(
                    new IngredientWithSize(Ingredient.of(BuiltInRegistries.ITEM.get(apricornID)), 2),
                    new IngredientWithSize(Ingredient.of(CobblemonItems.TUMBLESTONE), 2),
                    new IngredientWithSize(Ingredient.of(ItemTags.BUTTONS),1)
            );

            generateBlueprintRecipe(
                    output,
                    ballItem,
                    ingredients,
                    "ancient_pokeballs",
                    Dexes.APRICORN_TO_ANCIENTBALL.get(colour) + "_ball"

            );
        }

        for (Dexes.AncientSkyDex ball : Dexes.ANCIENTSKYDEX) {

            TagOutput ballItem = new TagOutput(ball.ball(), 4);

            List<IngredientWithSize> ingredients = List.of(
                    new IngredientWithSize(Ingredient.of(CobblemonItems.WHITE_APRICORN), 1),
                    new IngredientWithSize(Ingredient.of(CobblemonItems.BLUE_APRICORN), 1),
                    new IngredientWithSize(Ingredient.of(CobblemonItems.SKY_TUMBLESTONE), 2),
                    new IngredientWithSize(Ingredient.of(TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath("c", "ingots/" + ball.ingot()))), 1)
                    );
            generateBlueprintRecipe(
                    output,
                    ballItem,
                    ingredients,
                    "ancient_light_balls",
                    BuiltInRegistries.ITEM.getKey(ball.ball()).getPath())
            ;
        }

        for (Dexes.AncientBlackDex ball : Dexes.ANCIENTBLACKDEX) {

            ResourceLocation ballID = ResourceLocation.fromNamespaceAndPath("cobblemon", "ancient_" + ball.name() + "_ball");
            TagOutput ballItem = new TagOutput(BuiltInRegistries.ITEM.get(ballID), 4);

            List<IngredientWithSize> ingredients = List.of(
                    new IngredientWithSize(Ingredient.of(CobblemonItems.BLACK_APRICORN), 2),
                    new IngredientWithSize(Ingredient.of(CobblemonItems.SKY_TUMBLESTONE), 2),
                    new IngredientWithSize(Ingredient.of(TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath("c", "ingots/" + ball.ingot()))), 1)
            );
            generateBlueprintRecipe(
                    output,
                    ballItem,
                    ingredients,
                    "ancient_heavy_balls",
                    "ancient_" + ball.name() + "_ball"
            );
        }
    }

    private static void generateBlueprintRecipe(RecipeOutput blueprintOutput, TagOutput outputItem, List<IngredientWithSize> inputItems, String category, String recipeName) {

        BlueprintCraftingRecipe recipe = new BlueprintCraftingRecipe(
                category,
                outputItem,
                inputItems
        );

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "blueprint/" + recipeName);
        blueprintOutput.accept(id, recipe, null);
    }
}