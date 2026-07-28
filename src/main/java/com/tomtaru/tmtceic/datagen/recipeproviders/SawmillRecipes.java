package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.SawmillRecipe;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import blusunrize.immersiveengineering.api.crafting.TagOutputList;
import com.tomtaru.tmtceic.Tmtceic;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class SawmillRecipes {

    public static void build(RecipeOutput output) {
        var energyStandard = 1600;

        List<TMTSawing> sawmillRecipes = List.of(
                //new TMTSawing(
                //        Ingredient.of(ModItems.ACACIA_CABINET.get()),
                //        new TagOutput(Items.ACACIA_SLAB, 3),
                //        TagOutput.EMPTY,
                //        TagOutputList.EMPTY,
                //        new TagOutputList(new TagOutput(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "dusts/wood")))),
                //        energyStandard,"acacia_cabinet_sawing"
                //)
        );

        for (TMTSawing recipe : sawmillRecipes) {
            generateSawmillRecipe(output, recipe);
        }
    }

    private static void generateSawmillRecipe(RecipeOutput output, TMTSawing data) {
        SawmillRecipe recipe = new SawmillRecipe(
                data.output(),
                data.stripped(),
                data.input(),
                data.energy(),
                data.secondaryStripping(),
                data.secondaryOutputs()
        );

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "sawmill/" + data.recipeName());
        output.accept(id, recipe, null);
    }

    /**
     *
     * @param input Input Item
     * @param output Output Item
     * @param stripped Stripped output item
     * @param secondaryStripping Output when stripping
     * @param secondaryOutputs Secondary Output
     * @param energy energy amount
     * @param recipeName recipe name
     */
    private record TMTSawing(
            Ingredient input,
            TagOutput output,
            TagOutput stripped,
            TagOutputList secondaryStripping,
            TagOutputList secondaryOutputs,
            int energy,
            String recipeName
    ) {}
}