package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.IngredientWithSize;
import blusunrize.immersiveengineering.api.crafting.MixerRecipe;
import com.cobblemon.mod.common.CobblemonItems;
import com.tomtaru.tmtceic.Tmtceic;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

import java.util.List;

public class MixerRecipes {

    public static void build(RecipeOutput output) {

        var waterBase = TagKey.create(Registries.FLUID, ResourceLocation.tryParse("water"));
        var medicinalBrewBase = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "bases/medicinal_brew"));
        var energyStandard = 3200;

        List<TMTMixing> mixerRecipes = List.of(
                new TMTMixing(
                        List.of(new IngredientWithSize(Ingredient.of(CobblemonItems.MEDICINAL_LEEK), 1)),
                        waterBase, 1000,
                        ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "medicinal_brew"), 1000,
                        energyStandard,"medicinal_brew"
                ),
                new TMTMixing(
                        List.of(new IngredientWithSize(Ingredient.of(CobblemonItems.ORAN_BERRY),1)),
                        medicinalBrewBase, 1000,
                        ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "potion"), 1000,
                        energyStandard, "potion"
                ),
                new TMTMixing(
                        List.of(new IngredientWithSize(Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("cobblemon", "super_potion_ingredients"))))),
                        TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "potions/potion")), 1000,
                        ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "super_potion"), 1000,
                        energyStandard, "super_potion"
                ),
                new TMTMixing(
                        List.of(new IngredientWithSize(Ingredient.of(CobblemonItems.SITRUS_BERRY), 1)),
                        medicinalBrewBase, 1000,
                        ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "hyper_potion"), 1000,
                        energyStandard, "hyper_potion"
                ),
                new TMTMixing(
                        List.of(new IngredientWithSize(Ingredient.of(CobblemonItems.HOPO_BERRY), 1)),
                        medicinalBrewBase, 1000,
                        ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "elixir"), 1000,
                        energyStandard, "elixir"
                ),
                new TMTMixing(
                        List.of(new IngredientWithSize(Ingredient.of(CobblemonItems.LEPPA_BERRY), 1)),
                        medicinalBrewBase, 1000,
                        ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "ether"), 1000,
                        energyStandard, "ether"
                ),
                new TMTMixing(
                        List.of(new IngredientWithSize(Ingredient.of(CobblemonItems.VIVICHOKE), 1)),
                        TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "potions/hyper_potion")), 1000,
                        ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "max_potion"), 1000,
                        energyStandard, "max_potion"
                ),
                new TMTMixing(
                        List.of(new IngredientWithSize(Ingredient.of(CobblemonItems.PECHA_BERRY), 1)),
                        waterBase, 1000,
                        ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "antidote"), 1000,
                        energyStandard, "antidote"
                ),
                new TMTMixing(
                        List.of(new IngredientWithSize(Ingredient.of(CobblemonItems.CHESTO_BERRY), 1)),
                        waterBase, 1000,
                        ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "awakening"), 1000,
                        energyStandard, "awakening"
                ),
                new TMTMixing(
                        List.of(new IngredientWithSize(Ingredient.of(CobblemonItems.RAWST_BERRY), 1)),
                        waterBase, 1000,
                        ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "burn_heal"), 1000,
                        energyStandard, "burn_heal"
                ),
                new TMTMixing(
                        List.of(new IngredientWithSize(Ingredient.of(CobblemonItems.ASPEAR_BERRY), 1)),
                        waterBase, 1000,
                        ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "ice_heal"), 1000,
                        energyStandard, "ice_heal"
                ),
                new TMTMixing(
                        List.of(new IngredientWithSize(Ingredient.of(CobblemonItems.CHERI_BERRY), 1)),
                        waterBase, 1000,
                        ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "paralyze_heal"), 1000,
                        energyStandard, "paralyze_heal"
                ),
                new TMTMixing(
                        List.of(new IngredientWithSize(Ingredient.of(CobblemonItems.LUM_BERRY), 1)),
                        waterBase, 1000,
                        ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "full_heal"), 1000,
                        energyStandard, "full_heal"
                ),
                new TMTMixing(
                        List.of(new IngredientWithSize(Ingredient.of(CobblemonItems.PEP_UP_FLOWER), 1)),
                        TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "full_heal_ingredients")), 1000,
                        ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "full_heal"), 1000,
                        energyStandard, "full_heal_from_restoratives"
                ),
                new TMTMixing(
                        List.of(new IngredientWithSize(Ingredient.of(CobblemonItems.LUM_BERRY), 1)),
                        TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "potions/max_potion")), 1000,
                        ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "full_restore"), 1000,
                        energyStandard, "full_restore"
                ),
                new TMTMixing(
                        List.of(new IngredientWithSize(Ingredient.of(CobblemonItems.PEP_UP_FLOWER), 1)),
                        TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "pp_restores/ether")), 1000,
                        ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "max_ether"), 1000,
                        energyStandard, "max_ether"
                ),
                new TMTMixing(
                        List.of(new IngredientWithSize(Ingredient.of(CobblemonItems.PEP_UP_FLOWER), 1)),
                        TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "pp_restores/elixir")), 1000,
                        ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "max_elixir"), 1000,
                        energyStandard, "max_elixir"
                ),
                new TMTMixing(
                        List.of(new IngredientWithSize(Ingredient.of(CobblemonItems.PETAYA_BERRY), 1)),
                        TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "potions/potion")), 1000,
                        ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "throat_spray"), 1000,
                        energyStandard, "throat_spray"
                )
        );

        for (TMTMixing recipe : mixerRecipes) {
            generateMixerRecipe(output, recipe);
        }
    }

    private static void generateMixerRecipe(RecipeOutput output, TMTMixing data) {
        Fluid outputFluid = BuiltInRegistries.FLUID.get(data.fluidOutputId());
        FluidStack fluidOutput = new FluidStack(outputFluid, data.fluidOutputAmount());

        SizedFluidIngredient fluidInput = SizedFluidIngredient.of(data.fluidInputTag(), data.fluidInputAmount());

        MixerRecipe recipe = new MixerRecipe(fluidOutput, fluidInput, data.itemInputs(), data.energy());

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "mixer/" + data.recipeName() + "_in_mixer");
        output.accept(id, recipe, null);
    }

    /**
     *
     * @param itemInputs
     * @param fluidInputTag
     * @param fluidInputAmount
     * @param fluidOutputId
     * @param fluidOutputAmount
     * @param energy
     * @param recipeName
     */
    private record TMTMixing(
            List<IngredientWithSize> itemInputs,
            TagKey<Fluid> fluidInputTag, int fluidInputAmount,
            ResourceLocation fluidOutputId, int fluidOutputAmount,
            int energy, String recipeName
    ) {}
}