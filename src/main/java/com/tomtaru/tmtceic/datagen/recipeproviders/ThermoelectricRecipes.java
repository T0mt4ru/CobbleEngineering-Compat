package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.energy.ThermoelectricSource;
import com.tomtaru.tmtceic.Tmtceic;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ThermoelectricRecipes {

    public static void build(RecipeOutput output) {

        generateThermoelectricSource(
                output,
                BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("cobblemon", "fire_stone_block")),
                1000,
                "fire_stone_block"
        );

        generateThermoelectricSource(
                output,
                BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("cobblemon", "ice_stone_block")),
                150,
                "ice_stone_block"
        );

        generateThermoelectricSource(
                output,
                BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("cobblemon", "sun_stone_block")),
                1700,
                "sun_stone_block"
        );

        generateThermoelectricSource(
                output,
                BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("cobblemon", "water_stone_block")),
                350,
                "water_stone_block"
        );
    }

    /**
     *
     * @param sourceRecipe  - recipe output.
     * @param sourceBlock   - source of the temperature as a blocktag.
     * @param temperature   - temperature, in Kelvin as integer
     * @param recipeName    - name for the recipe
     */
    public static void generateThermoelectricSource(RecipeOutput sourceRecipe, Block sourceBlock, int temperature, String recipeName) {

        ThermoelectricSource recipe = new ThermoelectricSource(sourceBlock, temperature);

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "thermoelectric/" + recipeName);
        sourceRecipe.accept(id, recipe, null);
    }

}
