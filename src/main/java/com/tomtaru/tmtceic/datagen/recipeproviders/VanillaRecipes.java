package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.EnumMetals;
import blusunrize.immersiveengineering.api.crafting.BlueprintCraftingRecipe;
import blusunrize.immersiveengineering.common.register.IEItems;
import com.cobblemon.mod.common.CobblemonItems;
import com.tomtaru.tmtceic.Tmtceic;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class VanillaRecipes {

    public static void build(RecipeOutput output) {

        ItemStack ancientBallBlueprint = BlueprintCraftingRecipe.getTypedBlueprint("ancient_pokeballs");

        TagKey<Item> apricornsTag = TagKey.create(Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath("cobblemon", "apricorns"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ancientBallBlueprint)
                .pattern(" A ")
                .pattern("DDD")
                .pattern("PPP")
                .define('A', Ingredient.of(apricornsTag))
                .define('D', Items.BLUE_DYE)
                .define('P', Items.PAPER)
                .unlockedBy("has_apricorn", InventoryChangeTrigger.TriggerInstance.hasItems(CobblemonItems.RED_APRICORN))
                .save(output, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "blueprint_item/ancient_pokeballs_blueprint"));

        //ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.SLIME_BALL)
        //        .requires(Items.LIME_DYE)
        //        .requires(vectorwing.farmersdelight.common.registry.ModItems.WHEAT_DOUGH.get())
        //        .unlockedBy("has_wheat_dough", InventoryChangeTrigger.TriggerInstance.hasItems(vectorwing.farmersdelight.common.registry.ModItems.WHEAT_DOUGH.get()))
        //        .save(output);
    }
}