package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.common.register.IEItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

public class VanillaRecipes {
    public static void build(RecipeOutput output) {
        //ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STEEL_KNIFE.get())
        //        .pattern(" I ")
        //        .pattern(" S ")
        //        .define('I', IEItems.Metals.INGOTS.get(EnumMetals.STEEL))
        //        .define('S', Items.STICK)
        //        .unlockedBy("has_steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(IEItems.Metals.INGOTS.get(EnumMetals.STEEL)))
        //        .save(output);
//
        //ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.SLIME_BALL)
        //        .requires(Items.LIME_DYE)
        //        .requires(vectorwing.farmersdelight.common.registry.ModItems.WHEAT_DOUGH.get())
        //        .unlockedBy("has_wheat_dough", InventoryChangeTrigger.TriggerInstance.hasItems(vectorwing.farmersdelight.common.registry.ModItems.WHEAT_DOUGH.get()))
        //        .save(output);
    }
}