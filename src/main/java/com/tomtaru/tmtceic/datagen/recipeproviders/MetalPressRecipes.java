package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.IngredientWithSize;
import blusunrize.immersiveengineering.api.crafting.MetalPressRecipe;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import blusunrize.immersiveengineering.common.register.IEItems;
import com.tomtaru.tmtceic.Tmtceic;
import com.tomtaru.tmtceic.registry.ModItems;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;


import java.util.List;

import static net.minecraft.world.item.Items.*;
import static net.minecraft.world.item.crafting.Ingredient.of;


public class MetalPressRecipes {

    public static void build(RecipeOutput output) {

        var energyStandard = 3200;
//        var moldAluminum = ModItems.ALUMINUM_POKEBALL_FRAME.get();

        List<TMTPressing> pressRecipes = List.of(
                //new TMTPressing(
                //        new IngredientWithSize(of(ModItems.APPLE_PIE.get()), 1), moldUnpacking,
                //        new TagOutput(ModItems.APPLE_PIE_SLICE.get(), 4),
                //        energyStandard,"apple_pie_slice_in_metalpress"
                //)

        );

        for (TMTPressing recipe : pressRecipes) {
            generateMetalPressRecipe(output, recipe);
        }
    }

    private static void generateMetalPressRecipe(RecipeOutput output, TMTPressing data) {
        MetalPressRecipe recipe = new MetalPressRecipe(
                data.output(),
                data.input(),
                data.mold(),
                data.energy()
        );

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "metalpress/" + data.recipeName());
        output.accept(id, recipe, null);
    }

    private record TMTPressing(
            IngredientWithSize input,
            Item mold,
            TagOutput output,
            int energy,
            String recipeName
    ) {}
}