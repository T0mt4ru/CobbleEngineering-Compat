package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.BlueprintCraftingRecipe;
import com.cobblemon.mod.common.CobblemonItems;
import com.tomtaru.tmtceic.Tmtceic;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class VanillaRecipes {

    public static void build(RecipeOutput output) {

        ItemStack ancientBallBlueprint = BlueprintCraftingRecipe.getTypedBlueprint("ancient_pokeballs");
        ItemStack ancientLightBallBlueprint = BlueprintCraftingRecipe.getTypedBlueprint("ancient_light_balls");
        ItemStack ancientHeavyBallBlueprint = BlueprintCraftingRecipe.getTypedBlueprint("ancient_heavy_balls");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ancientBallBlueprint)
                .pattern(" T ")
                .pattern("DDD")
                .pattern("PPP")
                .define('T', Ingredient.of(CobblemonItems.TUMBLESTONE))
                .define('D', Items.BLUE_DYE)
                .define('P', Items.PAPER)
                .unlockedBy("has_tumblestone", InventoryChangeTrigger.TriggerInstance.hasItems(CobblemonItems.TUMBLESTONE))
                .save(output, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "blueprint_item/ancient_pokeballs_blueprint"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ancientLightBallBlueprint)
                .pattern(" S ")
                .pattern("DDD")
                .pattern("PPP")
                .define('S', Ingredient.of(CobblemonItems.SKY_TUMBLESTONE))
                .define('D', Items.BLUE_DYE)
                .define('P', Items.PAPER)
                .unlockedBy("has_sky_tumblestone", InventoryChangeTrigger.TriggerInstance.hasItems(CobblemonItems.SKY_TUMBLESTONE))
                .save(output, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "blueprint_item/ancient_light_balls_blueprint"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ancientHeavyBallBlueprint)
                .pattern(" B ")
                .pattern("DDD")
                .pattern("PPP")
                .define('B', Ingredient.of(CobblemonItems.BLACK_TUMBLESTONE))
                .define('D', Items.BLUE_DYE)
                .define('P', Items.PAPER)
                .unlockedBy("has_black_tumblestone", InventoryChangeTrigger.TriggerInstance.hasItems(CobblemonItems.BLACK_TUMBLESTONE))
                .save(output, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "blueprint_item/ancient_heavy_balls_blueprint"));

        //ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.SLIME_BALL)
        //        .requires(Items.LIME_DYE)
        //        .requires(vectorwing.farmersdelight.common.registry.ModItems.WHEAT_DOUGH.get())
        //        .unlockedBy("has_wheat_dough", InventoryChangeTrigger.TriggerInstance.hasItems(vectorwing.farmersdelight.common.registry.ModItems.WHEAT_DOUGH.get()))
        //        .save(output);
    }
}