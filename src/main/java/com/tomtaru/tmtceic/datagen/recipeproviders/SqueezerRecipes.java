package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.IngredientWithSize;
import blusunrize.immersiveengineering.api.crafting.SqueezerRecipe;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import com.tomtaru.tmtceic.Tmtceic;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;


import java.util.List;

public class SqueezerRecipes {

    public static void build(RecipeOutput output) {
        var energyStandard = 3200;

        List<TMTSqueezing> squeezerRecipes = List.of(
                //new TMTSqueezing(
                //        new IngredientWithSize(Ingredient.of(Items.MELON), 1),
                //        melonJuice, 450,
                //        TagOutput.EMPTY,
                //        energyStandard*2,
                //        "melon_juice_from_melon_block"
                //)
        );

        for (TMTSqueezing recipe : squeezerRecipes) {
            generateSqueezerRecipe(output, recipe);
        }
    }

    private static void generateSqueezerRecipe(RecipeOutput output, TMTSqueezing data) {
        Fluid fluid = BuiltInRegistries.FLUID.get(data.fluidId());
        FluidStack fluidOutput = new FluidStack(fluid, data.fluidAmount());

        SqueezerRecipe recipe = new SqueezerRecipe(fluidOutput, data.itemOutput(), data.input(), data.energy());

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "squeezer/" + data.recipeName());
        output.accept(id, recipe, null);
    }

    private record TMTSqueezing(
            IngredientWithSize input,
            ResourceLocation fluidId, int fluidAmount,
            TagOutput itemOutput,
            int energy,
            String recipeName
    ) {}
}