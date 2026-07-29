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
import net.minecraft.world.item.crafting.Ingredient;


import java.util.List;

import static net.minecraft.world.item.Items.*;
import static net.minecraft.world.item.crafting.Ingredient.of;


public class MetalPressRecipes {

    public static final int energyStandard = 3200;

    public static final IngredientWithSize frameAluminum = new IngredientWithSize(Ingredient.of(ModItems.ALUMINUM_POKEBALL_FRAME.get()), 1);
    public static final IngredientWithSize frameNetherite = new IngredientWithSize(Ingredient.of(ModItems.NETHERITE_POKEBALL_FRAME.get()), 1);
    public static final Item moldPokeball = ModItems.MOLD_POKEBALL_FRAME.get();

    private record TMTPressing(
            IngredientWithSize input,
            Item mold,
            TagOutput output,
            int energy,
            String recipeName
    ) {}
    public static void build(RecipeOutput output) {



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


}