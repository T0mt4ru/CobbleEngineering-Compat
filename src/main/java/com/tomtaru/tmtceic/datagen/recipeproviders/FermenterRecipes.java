package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.FermenterRecipe;
import blusunrize.immersiveengineering.api.crafting.IngredientWithSize;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import com.tomtaru.tmtceic.Tmtceic;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;

import java.util.List;

public class FermenterRecipes {

    public static void build(RecipeOutput output) {
        var fluidEthanol = ResourceLocation.fromNamespaceAndPath("immersiveengineering", "ethanol");
        var energyStandard = 6400;
        var energyMultiplier = 2;

        List<TMTFermenting> fermenterRecipes = List.of(
                //new TMTFermenting(
                //        Ingredient.of(ModItems.WHEAT_FLOUR.get()), 1,
                //        fluidEthanol, 80,
                //        energyStandard, "ethanol_from_wheat_flour"
                //)
        );

        for (TMTFermenting recipe : fermenterRecipes) {
            generateFermenterRecipe(output, recipe);
        }
    }

    private static void generateFermenterRecipe(RecipeOutput output, TMTFermenting data) {
        Fluid fluid = BuiltInRegistries.FLUID.get(data.fluidId());
        FluidStack fluidOutput = new FluidStack(fluid, data.fluidAmount());
        IngredientWithSize input = new IngredientWithSize(data.input(), data.count());

        FermenterRecipe recipe = new FermenterRecipe(fluidOutput, TagOutput.EMPTY, input, data.energy());

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "fermenter/" + data.recipeName());
        output.accept(id, recipe, null);
    }

    private record TMTFermenting(Ingredient input, int count, ResourceLocation fluidId, int fluidAmount, int energy, String recipeName) {}
}