package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.BottlingMachineRecipe;
import blusunrize.immersiveengineering.api.crafting.IngredientWithSize;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import blusunrize.immersiveengineering.api.crafting.TagOutputList;
import com.cobblemon.mod.common.CobblemonItems;
import com.tomtaru.tmtceic.Tmtceic;

import net.minecraft.core.registries.BuiltInRegistries;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

import java.util.List;

public class BottlingMachineRecipes {

    public static void build(RecipeOutput output) {

        var fluidAmount = 250;

        List<TMTBottling> bottlingRecipes = List.of(
                new TMTBottling(
                        new IngredientWithSize(Ingredient.of(Items.GLASS_BOTTLE), 1),
                        SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "potion")), fluidAmount),
                        List.of(new TagOutput(CobblemonItems.POTION)),
                        "potion"
                ),
                new TMTBottling(
                        new IngredientWithSize(Ingredient.of(Items.GLASS_BOTTLE), 1),
                        SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "super_potion")), fluidAmount),
                        List.of(new TagOutput(CobblemonItems.SUPER_POTION)),
                        "super_potion"
                ),
                new TMTBottling(
                        new IngredientWithSize(Ingredient.of(Items.GLASS_BOTTLE), 1),
                        SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "hyper_potion")), fluidAmount),
                        List.of(new TagOutput(CobblemonItems.HYPER_POTION)),
                        "hyper_potion"
                ),
                new TMTBottling(
                        new IngredientWithSize(Ingredient.of(Items.GLASS_BOTTLE), 1),
                        SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "max_potion")), fluidAmount),
                        List.of(new TagOutput(CobblemonItems.MAX_POTION)),
                        "max_potion"
                ),
                new TMTBottling(
                        new IngredientWithSize(Ingredient.of(Items.GLASS_BOTTLE), 1),
                        SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "ether")), fluidAmount),
                        List.of(new TagOutput(CobblemonItems.ETHER)),
                        "ether"
                ),
                new TMTBottling(
                        new IngredientWithSize(Ingredient.of(Items.GLASS_BOTTLE), 1),
                        SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "max_ether")), fluidAmount),
                        List.of(new TagOutput(CobblemonItems.MAX_ETHER)),
                        "max_ether"
                ),
                new TMTBottling(
                        new IngredientWithSize(Ingredient.of(Items.GLASS_BOTTLE), 1),
                        SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "elixir")), fluidAmount),
                        List.of(new TagOutput(CobblemonItems.ELIXIR)),
                        "elixir"
                ),
                new TMTBottling(
                        new IngredientWithSize(Ingredient.of(Items.GLASS_BOTTLE), 1),
                        SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "max_elixir")), fluidAmount),
                        List.of(new TagOutput(CobblemonItems.MAX_ELIXIR)),
                        "max_elixir"
                ),
                new TMTBottling(
                        new IngredientWithSize(Ingredient.of(Items.GLASS_BOTTLE), 1),
                        SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "antidote")), fluidAmount),
                        List.of(new TagOutput(CobblemonItems.ANTIDOTE)),
                        "antidote"
                ),
                new TMTBottling(
                        new IngredientWithSize(Ingredient.of(Items.GLASS_BOTTLE), 1),
                        SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "awakening")), fluidAmount),
                        List.of(new TagOutput(CobblemonItems.AWAKENING)),
                        "awakening"
                ),
                new TMTBottling(
                        new IngredientWithSize(Ingredient.of(Items.GLASS_BOTTLE), 1),
                        SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "paralyze_heal")), fluidAmount),
                        List.of(new TagOutput(CobblemonItems.PARALYZE_HEAL)),
                        "paralyze_heal"
                ),
                new TMTBottling(
                        new IngredientWithSize(Ingredient.of(Items.GLASS_BOTTLE), 1),
                        SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "burn_heal")), fluidAmount),
                        List.of(new TagOutput(CobblemonItems.BURN_HEAL)),
                        "burn_heal"
                ),
                new TMTBottling(
                        new IngredientWithSize(Ingredient.of(Items.GLASS_BOTTLE), 1),
                        SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "ice_heal")), fluidAmount),
                        List.of(new TagOutput(CobblemonItems.ICE_HEAL)),
                        "ice_heal"
                ),
                new TMTBottling(
                        new IngredientWithSize(Ingredient.of(Items.GLASS_BOTTLE), 1),
                        SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "full_heal")), fluidAmount),
                        List.of(new TagOutput(CobblemonItems.FULL_HEAL)),
                        "full_heal"
                ),
                new TMTBottling(
                        new IngredientWithSize(Ingredient.of(Items.GLASS_BOTTLE), 1),
                        SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "full_restore")), fluidAmount),
                        List.of(new TagOutput(CobblemonItems.FULL_RESTORE)),
                        "full_restore"
                ),
                new TMTBottling(
                        new IngredientWithSize(Ingredient.of(Items.GLASS_BOTTLE), 1),
                        SizedFluidIngredient.of(BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "throat_spray")), fluidAmount),
                        List.of(new TagOutput(CobblemonItems.THROAT_SPRAY)),
                        "throat_spray"
                )

        );

        for (TMTBottling recipe : bottlingRecipes) {
            generateBottlingRecipe(output, recipe);
        }
    }

    private static void generateBottlingRecipe(RecipeOutput output, TMTBottling data) {
        BottlingMachineRecipe recipe = new BottlingMachineRecipe(
                new TagOutputList(data.outputs()),
                data.input(),
                data.fluidInput()
        );

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "bottling/" + data.recipeName() + "_in_bottling_machine");
        output.accept(id, recipe, null);
    }

    private record TMTBottling(
            IngredientWithSize input,
            SizedFluidIngredient fluidInput,
            List<TagOutput> outputs,
            String recipeName
    ) {}
}