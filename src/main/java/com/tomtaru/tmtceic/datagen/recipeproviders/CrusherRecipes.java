package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.CrusherRecipe;
import blusunrize.immersiveengineering.api.crafting.StackWithChance;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import com.tomtaru.tmtceic.Tmtceic;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class CrusherRecipes {

    private static final float chanceGuaranteed = 1.0F;
    private static final float chanceLow = 0.25F;
    private static final float chanceMedium = 0.5F;
    private static final float chanceHigh = 0.75F;

    private static final int energyStone= 6000;
    private static final int energyDeepslate = (int) Math.floor(energyStone * 1.25);

    private static final List<StackWithChance> noSecondaries = List.of();

    public static void build(RecipeOutput output) {

        for ( String evoStone : Dexes.EVOLUTIONSTONEDEX ) {

            ResourceLocation stoneOreID = ResourceLocation.fromNamespaceAndPath("cobblemon",  evoStone + "_stone_ore");
            Ingredient stoneOreItem = Ingredient.of(BuiltInRegistries.ITEM.get(stoneOreID));

            ResourceLocation deepslateOreID = ResourceLocation.fromNamespaceAndPath("cobblemon", "deepslate_" + evoStone + "_stone_ore");
            Ingredient deepslateOreItem = Ingredient.of(BuiltInRegistries.ITEM.get(deepslateOreID));

            ResourceLocation stoneID = ResourceLocation.fromNamespaceAndPath("cobblemon", evoStone + "_stone");
            TagOutput stoneItem = new TagOutput(BuiltInRegistries.ITEM.get(stoneID), 2);

            List<StackWithChance> secondaryStoneItems = List.of(
                    new StackWithChance(new TagOutput(BuiltInRegistries.ITEM.get(stoneID), 1), chanceLow)
            );
            List<StackWithChance> secondaryDeepslateItems = List.of(
                    new StackWithChance(new TagOutput(BuiltInRegistries.ITEM.get(stoneID), 1), chanceMedium)
            );

            if (evoStone.equals("moon")) {

                Ingredient stoneItemInput = Ingredient.of(BuiltInRegistries.ITEM.get(stoneID));

                ResourceLocation dripstoneOreID = ResourceLocation.fromNamespaceAndPath("cobblemon", "dripstone_" + evoStone + "_stone_ore");
                Ingredient dripstoneOreItem = Ingredient.of(BuiltInRegistries.ITEM.get(dripstoneOreID));

                List<StackWithChance> secondaryDripstoneItems = List.of(
                        new StackWithChance(new TagOutput(BuiltInRegistries.ITEM.get(stoneID), 1), chanceHigh)
                );

                ResourceLocation dustID = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, evoStone + "_stone_dust");
                TagOutput dustItem  = new TagOutput(BuiltInRegistries.ITEM.get(dustID), 2);

                generateCrusherRecipe(output, dripstoneOreItem, stoneItem, energyStone, secondaryDripstoneItems, "dripstone_" + evoStone + "_stone_ore");
                generateCrusherRecipe(output, stoneItemInput, dustItem, energyStone, noSecondaries, evoStone + "_stone_to_dust");
            }

            if (evoStone.equals("sun")) {

                Ingredient stoneItemInput = Ingredient.of(BuiltInRegistries.ITEM.get(stoneID));

                ResourceLocation terracottaOreID = ResourceLocation.fromNamespaceAndPath("cobblemon", "terracotta_" + evoStone + "_stone_ore");
                Ingredient terracottaOreItem = Ingredient.of(BuiltInRegistries.ITEM.get(terracottaOreID));

                List<StackWithChance> secondaryTerracottaItems = List.of(
                        new StackWithChance(new TagOutput(BuiltInRegistries.ITEM.get(stoneID), 1), chanceHigh)
                );

                ResourceLocation dustID = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, evoStone + "_stone_dust");
                TagOutput dustItem  = new TagOutput(BuiltInRegistries.ITEM.get(dustID), 2);

                generateCrusherRecipe(output, terracottaOreItem, stoneItem, energyStone, secondaryTerracottaItems, "terracotta_" + evoStone + "_stone_ore");
                generateCrusherRecipe(output, stoneItemInput, dustItem, energyStone, noSecondaries, evoStone + "_stone_to_dust");
            }

            if (evoStone.equals("fire")) {

                Ingredient stoneItemInput = Ingredient.of(BuiltInRegistries.ITEM.get(stoneID));

                ResourceLocation netherOreID = ResourceLocation.fromNamespaceAndPath("cobblemon", "nether_" + evoStone + "_stone_ore");
                Ingredient netherOreItem = Ingredient.of(BuiltInRegistries.ITEM.get(netherOreID));

                List<StackWithChance> secondaryNetherItems = List.of(
                        new StackWithChance(new TagOutput(BuiltInRegistries.ITEM.get(stoneID), 1), chanceHigh)
                );

                TagOutput dustItem = new TagOutput(Items.BLAZE_POWDER, 2) ;

                generateCrusherRecipe(output, netherOreItem, stoneItem, energyStone, secondaryNetherItems, "nether_" + evoStone + "_stone_ore");
                generateCrusherRecipe(output, stoneItemInput, dustItem, energyStone, noSecondaries, evoStone + "_stone_to_dust");
            }

            if (evoStone.equals("shiny")) {

                Ingredient stoneItemInput = Ingredient.of(BuiltInRegistries.ITEM.get(stoneID));

                ResourceLocation dustID = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, evoStone + "_stone_dust");
                TagOutput dustItem = new TagOutput(BuiltInRegistries.ITEM.get(dustID), 2);

                generateCrusherRecipe(output, stoneItemInput, dustItem, energyStone, noSecondaries, evoStone + "_stone_to_dust");
            }

            if (evoStone.equals("water")) {

                Ingredient stoneItemInput = Ingredient.of(BuiltInRegistries.ITEM.get(stoneID));

                TagOutput dustItem = new TagOutput(Items.GHAST_TEAR, 2);

                generateCrusherRecipe(output, stoneItemInput, dustItem, energyStone, noSecondaries, evoStone + "_stone_to_tear");
            }

            generateCrusherRecipe(output, stoneOreItem, stoneItem, energyStone, secondaryStoneItems, evoStone + "_stone_ore");
            generateCrusherRecipe(output, deepslateOreItem, stoneItem, energyDeepslate, secondaryDeepslateItems, "deepslate_"  + evoStone + "_stone_ore");
        }

        for (Dexes.TumbleCrystalDex crystalEntry : Dexes.TUMBLECRYSTALDEX) {

            TagOutput resultItem = new TagOutput(crystalEntry.result(), crystalEntry.yield());

            generateCrusherRecipe(output, Ingredient.of(crystalEntry.crystal()), resultItem, energyStone, noSecondaries, BuiltInRegistries.ITEM.getKey(crystalEntry.crystal()).getPath());
        }
    }

    private static void generateCrusherRecipe(RecipeOutput recipeOutput, Ingredient input, TagOutput output, int energy, List<StackWithChance> secondaryOutputs,  String recipeName) {
        CrusherRecipe recipe = new CrusherRecipe(
                output,
                input,
                energy,
                secondaryOutputs
        );

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "crusher/" + recipeName);
        recipeOutput.accept(id, recipe, null);
    }
}