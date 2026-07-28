package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.CrusherRecipe;
import blusunrize.immersiveengineering.api.crafting.StackWithChance;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import com.tomtaru.tmtceic.Tmtceic;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;


import java.util.List;

public class CrusherRecipes {

    public static void build(RecipeOutput output) {

        var energyBlock = 1600;
        var energySingle = energyBlock / 8;
        var chanceGuaranteed = 1.0F;

        List<TMTCrushing> crusherRecipes = List.of(
                //new TMTCrushing(
                //        Ingredient.of(ModItems.RICE_BALE.get()),
                //        new TagOutput(ModItems.RICE.get(), 9),energyBlock,
                //        List.of(
                //                new StackWithChance(new TagOutput(ModItems.STRAW.get(), 5),chanceGuaranteed),
                //                new StackWithChance(new TagOutput(ModItems.STRAW.get(), 4), 0.25F)
                //        ),
                //        "rice_from_bale"
                //)
        );

        for (TMTCrushing recipe : crusherRecipes) {
            generateCrusherRecipe(output, recipe);
        }
    }

    private static void generateCrusherRecipe(RecipeOutput output, TMTCrushing data) {
        CrusherRecipe recipe = new CrusherRecipe(
                data.output(),
                data.input(),
                data.energy(),
                data.secondaryOutputs()
        );

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "crusher/" + data.recipeName());
        output.accept(id, recipe, null);
    }

    private record TMTCrushing(
            Ingredient input,
            TagOutput output,
            int energy,
            List<StackWithChance> secondaryOutputs,
            String recipeName
    ) {}
}