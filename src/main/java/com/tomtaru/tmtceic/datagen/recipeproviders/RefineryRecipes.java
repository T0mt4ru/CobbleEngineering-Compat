package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.RefineryRecipe;
import com.tomtaru.tmtceic.Tmtceic;
import com.tomtaru.tmtceic.registry.ModAprigels;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import java.util.Optional;

public class RefineryRecipes {

    public static void build(RecipeOutput output) {

        var aprigelSubstrate = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "aprigels/all_aprigels"));

        generateRefineryRecipe(output,
                ModAprigels.STELLAR_APRIGEL.source().get(),
                1,
                FluidIngredient.tag(aprigelSubstrate),
                1,
                Optional.empty(),
                Optional.empty(),
                Ingredient.of(Tags.Items.NETHER_STARS),
                1600,
                "stellar_aprigel"
        );

    }

    /**
     *
     * @param refinedOutput     - recipeOutput.
     * @param fluidProduct      - fluid being produced.
     * @param productAmount     - amount of fluid being produced.
     * @param fluidSubstrate    - base fluid to be used.
     * @param substrateAmount   - amount of base fluid to be used.
     * @param fluidReactant     - optional fluid to be added.
     * @param reactantAmount    - amount of optional fluid to be added.
     * @param catalyst          - optional catalyst to be used.
     * @param energy            - energy a single operation uses.
     * @param recipeName        - identifier for this recipe.
     */
    private static void generateRefineryRecipe(RecipeOutput refinedOutput,Fluid fluidProduct, int productAmount, FluidIngredient fluidSubstrate, int substrateAmount, Optional<Fluid> fluidReactant, Optional<Integer> reactantAmount, Ingredient catalyst, int energy, String recipeName) {

        FluidStack outputFluid = new FluidStack(fluidProduct, productAmount);

        SizedFluidIngredient input0 = new SizedFluidIngredient(fluidSubstrate, substrateAmount);

        Optional<SizedFluidIngredient> input1 = fluidReactant.map(fluid -> SizedFluidIngredient.of(fluid, reactantAmount.orElseThrow(() ->
                new IllegalArgumentException("reactantAmount must be present when fluidReactant is present for recipe: " + recipeName)))
        );

        RefineryRecipe recipe = new RefineryRecipe(
                outputFluid,
                input0,
                input1,
                catalyst,
                energy
        );

            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "refinery/" + recipeName);
            refinedOutput.accept(id, recipe, null);
    }
}
