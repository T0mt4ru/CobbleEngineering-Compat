package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.IngredientWithSize;
import blusunrize.immersiveengineering.api.crafting.MetalPressRecipe;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import com.tomtaru.tmtceic.Tmtceic;
import com.tomtaru.tmtceic.registry.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

public class MetalPressRecipes {

    public static final int energyStandard = 3200;

    public static final Item moldPokeball = ModItems.MOLD_POKEBALL_FRAME.get();

    public static void build(RecipeOutput output) {

        for (String colour : Dexes.APRIDEX) {
            ResourceLocation apricornID = ResourceLocation.fromNamespaceAndPath("cobblemon", colour + "_apricorn");
            Item apricornItem = BuiltInRegistries.ITEM.get(apricornID);
            IngredientWithSize apricorn = new IngredientWithSize(Ingredient.of(apricornItem), 1);

            ResourceLocation pokeballID = ResourceLocation.fromNamespaceAndPath("cobblemon",   Dexes.APRICORN_TO_BALL.get(colour) + "_ball");
            TagOutput pokeball = new TagOutput(BuiltInRegistries.ITEM.get(pokeballID));
            String recipeName = Dexes.APRICORN_TO_BALL.get(colour) + "_ball_in_metalpress";

            generateMetalPressRecipe(output, pokeball, apricorn, moldPokeball, energyStandard, recipeName);
        }

        generateMetalPressRecipe(
                output,
                new TagOutput(ModItems.ALUMINUM_POKEBALL_FRAME, 1),
                new IngredientWithSize(Ingredient.of(TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath("c", "ingots/aluminum"))), 1),
                moldPokeball,
                energyStandard,
                "aluminum_pokeball_frame"
                );

        generateMetalPressRecipe(
                output,
                new TagOutput(ModItems.NETHERITE_POKEBALL_FRAME, 1),
                new IngredientWithSize(Ingredient.of(TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath("c", "ingots/netherite"))), 1),
                moldPokeball,
                energyStandard,
                "netherite_pokeball_frame"
        );
    }

    private static void generateMetalPressRecipe(RecipeOutput pressRecipe, TagOutput outputItem, IngredientWithSize inputItem, Item moldItem, int energy, String recipeName ) {
        MetalPressRecipe recipe = new MetalPressRecipe(
                outputItem,
                inputItem,
                moldItem,
                energy
        );

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "metalpress/" + recipeName);
        pressRecipe.accept(id, recipe, null);
    }


}