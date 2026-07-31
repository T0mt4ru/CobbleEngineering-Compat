package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.BlueprintCraftingRecipe;
import blusunrize.immersiveengineering.api.crafting.IngredientWithSize;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import blusunrize.immersiveengineering.common.register.IEItems;
import com.tomtaru.tmtceic.Tmtceic;
import com.tomtaru.tmtceic.registry.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
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