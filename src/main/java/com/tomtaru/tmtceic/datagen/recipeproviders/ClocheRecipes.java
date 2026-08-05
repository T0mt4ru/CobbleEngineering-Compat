package com.tomtaru.tmtceic.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.ClocheRecipe;
import blusunrize.immersiveengineering.api.crafting.StackWithChance;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import blusunrize.immersiveengineering.client.utils.ClocheRenderFunctions;
import com.tomtaru.tmtceic.Tmtceic;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;

import java.util.List;

public class ClocheRecipes {

    private static final FluidIngredient fluidWater = FluidIngredient.tag(TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath("c", "water")));
    private static final FluidIngredient fluidLava = FluidIngredient.tag(TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath("c", "lava")));

    private static final Ingredient soilDirt = Ingredient.of(Items.DIRT);
    private static final Ingredient soilRich = Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "compat/rich_soil")));
    private static final Ingredient soilMagma = Ingredient.of(Items.MAGMA_BLOCK);
    private static final Ingredient soilStone = Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "stones")));
    private static final Ingredient soilWater = Ingredient.of(Items.WATER_BUCKET);

    private static final int timeStandard = 1600;
    private static final int timeHalved = timeStandard / 2;
    private static final int timeDoubled = timeStandard * 2;

    private static final float chanceGuaranteed = 1.0f;
    private static final float chanceHigh = 0.75f;
    private static final float chanceMedium = 0.5f;
    private static final float chanceLow = 0.25f;

    public enum RenderType
    {
        GENERIC,
        CROP
    }

    // The "Miscdex", lists all non-groupable crops in a record.
    private record MiscCrop(
            String nameSpace,
            String cropItemID,
            String seedItemID,
            String renderBlockID,
            RenderType renderType,
            List<StackWithChance> outputs,
            int time,
            Ingredient soilID,
            String soilLabel,
            boolean supportsRichSoil
    ) {}

    private static final List<MiscCrop> MISCDEX = List.of(
            new MiscCrop(
                    "cobblemon",
                    "vivichoke",
                    "vivichoke_seeds",
                    "vivichoke_seeds",
                    RenderType.CROP,
                    List.of(
                            new StackWithChance(new TagOutput(
                                    BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("cobblemon", "vivichoke")), 1),
                                    chanceGuaranteed),
                            new StackWithChance(new TagOutput(
                                    BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("cobblemon","vivichoke_seeds")), 1),
                                    chanceLow)
                    ),
                    timeDoubled,
                    soilDirt, "dirt",
                    true
            ),
            new MiscCrop(
                    "cobblemon",
                    "pep_up_flower",
                    "revival_herb",
                    "revival_herb",
                    RenderType.CROP,
                    List.of(
                            new StackWithChance(new TagOutput(
                                    BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("cobblemon", "pep_up_flower")), 1),
                                    chanceGuaranteed),
                            new StackWithChance(new TagOutput(
                                    BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("cobblemon", "revival_herb")), 1),
                                    chanceGuaranteed)
                    ),
                    timeStandard,
                    soilDirt, "dirt",
                    true
            ),
            new MiscCrop(
                    "cobblemon",
                    "hearty_grains",
                    "hearty_grains",
                    "hearty_grains",
                    RenderType.CROP,
                    List.of(
                            new StackWithChance(new TagOutput(
                                    BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("cobblemon", "hearty_grains")), 3),
                                    chanceGuaranteed),
                            new StackWithChance( new TagOutput(
                                    BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("cobblemon", "hearty_grains")), 1),
                                    chanceLow)
                    ),
                    timeStandard,
                    soilDirt, "dirt",
                    true
            ),
            new MiscCrop(
                    "cobblemon",
                    "galarica_nuts",
                    "galarica_nuts",
                    "galarica_nut_bush",
                    RenderType.CROP,
                    List.of(
                            new StackWithChance(new TagOutput(
                                    BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("cobblemon", "galarica_nuts")), 1),
                                    chanceGuaranteed)
                    ),
                    timeStandard,
                    soilDirt, "dirt",
                    true
            ),
            new MiscCrop(
                    "cobblemon",
                    "big_root",
                    "big_root",
                    "big_root",
                    RenderType.GENERIC,
                    List.of(
                            new StackWithChance(new TagOutput(
                                    BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("cobblemon", "big_root")), 1),
                                    chanceGuaranteed)
                    ),
                    timeHalved,
                    soilStone, "stone",
                    false
            ),
            new MiscCrop(
                    "cobblemon",
                    "energy_root",
                    "energy_root",
                    "energy_root",
                    RenderType.GENERIC,
                    List.of(
                            new StackWithChance(new TagOutput(
                                    BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("cobblemon", "energy_root")), 1),
                                    chanceGuaranteed)
                    ),
                    timeHalved,
                    soilStone, "stone",
                    false
            ),
            new MiscCrop(
                    "cobblemon",
                    "medicinal_leek",
                    "medicinal_leek",
                    "medicinal_leek",
                    RenderType.CROP,
                    List.of(
                            new StackWithChance(new TagOutput(
                                    BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("cobblemon", "medicinal_leek")), 4),
                                    chanceGuaranteed),
                            new StackWithChance(new TagOutput(
                                    BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("cobblemon", "medicinal_leek")), 1),
                                    chanceLow)

                    ),
                    timeStandard,
                    soilWater, "water",
                    false
            )
    );


    private static void registerCropCloche(
            RecipeOutput output, RecipeOutput farmersdelightOutput,
            String recipeGroup, MiscCrop crop
    ) {
        Item seedItem = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(crop.nameSpace(), crop.seedItemID()));
        Block renderBlock = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(crop.nameSpace(), crop.renderBlockID()));

        ClocheRecipe dirtRecipe = new ClocheRecipe(
                crop.outputs(),
                Ingredient.of(seedItem),
                crop.soilID(),
                crop.time(),
                fluidWater,
                switch (crop.renderType) {
                    case CROP ->
                        new ClocheRenderFunctions.RenderFunctionCrop(renderBlock);

                    case GENERIC ->
                        new ClocheRenderFunctions.RenderFunctionGeneric(renderBlock);

                }
        );
        output.accept(
                ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "cloche/" + recipeGroup + "/" + crop.cropItemID() + "_on_"+ crop.soilLabel()),
                dirtRecipe, null
        );

        if (crop.supportsRichSoil()) {
            ClocheRecipe richRecipe = new ClocheRecipe(
                    crop.outputs(),
                    Ingredient.of(seedItem),
                    soilRich,
                    crop.time() / 2,
                    fluidWater,
                    switch (crop.renderType) {
                        case CROP ->
                                new ClocheRenderFunctions.RenderFunctionCrop(renderBlock);

                        case GENERIC ->
                                new ClocheRenderFunctions.RenderFunctionGeneric(renderBlock);

                    }
            );
            farmersdelightOutput.accept(
                    ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "cloche/" + recipeGroup + "/" + crop.cropItemID() + "_on_rich_soil"),
                    richRecipe, null
            );
        }
    }

    public static void build(RecipeOutput output) {

        RecipeOutput farmersdelightOutput = output.withConditions(new ModLoadedCondition("farmersdelight"));
        RecipeOutput dynamictreescobblemonOutput = output.withConditions(new ModLoadedCondition("dtcobblemon"));

        for (Dexes.BerryDex  berry : Dexes.BERRYDEX) {

            List<StackWithChance> outputs = List.of(
                    new StackWithChance(new TagOutput(berry.berryItem(), 3), chanceGuaranteed),
                    new StackWithChance(new TagOutput(berry.berryItem(), 1), chanceLow)
            );

            ClocheRecipe recipe = new ClocheRecipe(
                    outputs,
                    Ingredient.of(berry.berryItem()),
                    soilDirt,
                    timeStandard,
                    fluidWater,
                    new ClocheRenderFunctions.RenderFunctionCrop(berry.berryBlock())
            );

            output.accept(ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID,"cloche/berries/" + BuiltInRegistries.ITEM.getKey(berry.berryItem()).getPath() + "_on_dirt"), recipe, null);

            ClocheRecipe farmersdelightRecipe = new ClocheRecipe(
                    outputs,
                    Ingredient.of(berry.berryItem()),
                    soilRich,
                    timeHalved,
                    fluidWater,
                    new ClocheRenderFunctions.RenderFunctionCrop(berry.berryBlock())
            );

            farmersdelightOutput.accept(ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID,"cloche/berries/" + BuiltInRegistries.ITEM.getKey(berry.berryItem()).getPath() + "_on_rich_soil"), farmersdelightRecipe, null);

        }
        // for-loop dealing with Mintdex.
        for (String mintColour : Dexes.MINTDEX) {
            ResourceLocation mintSeedID = ResourceLocation.fromNamespaceAndPath("cobblemon", mintColour + "_mint_seeds");
            ResourceLocation mintCropID = ResourceLocation.fromNamespaceAndPath("cobblemon", mintColour + "_mint");
            ResourceLocation mintLeafID = ResourceLocation.fromNamespaceAndPath("cobblemon", mintColour + "_mint_leaf");

            Item seedItem = BuiltInRegistries.ITEM.get(mintSeedID);
            Block seedBlock = BuiltInRegistries.BLOCK.get(mintCropID);
            Item leafItem = BuiltInRegistries.ITEM.get(mintLeafID);

            List<StackWithChance> outputs = List.of(
                    new StackWithChance(new TagOutput(leafItem, 3), chanceGuaranteed),
                    new StackWithChance(new TagOutput(seedItem, 1), chanceLow)
            );

            ClocheRecipe recipe = new ClocheRecipe(
                    outputs,
                    Ingredient.of(seedItem),
                    soilDirt,
                    timeStandard,
                    fluidWater,
                    new ClocheRenderFunctions.RenderFunctionCrop(seedBlock)
            );

            ClocheRecipe farmersdelightRecipe = new ClocheRecipe(
                    outputs,
                    Ingredient.of(seedItem),
                    soilRich,
                    timeHalved,
                    fluidWater,
                    new ClocheRenderFunctions.RenderFunctionCrop(seedBlock)
            );

            ResourceLocation recipeID = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "cloche/mints/" + mintColour + "_mint_on_dirt");
            output.accept(recipeID, recipe, null);

            ResourceLocation farmersdelightRecipeID = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "cloche/mints/" + mintColour + "_mint_on_rich_soil");
            farmersdelightOutput.accept(farmersdelightRecipeID, farmersdelightRecipe, null);
        }

        // for-loop dealing with Tumbledex.
        for (String tumbleType : Dexes.TUMBLEDEX) {
            ResourceLocation tumbleID = ResourceLocation.fromNamespaceAndPath("cobblemon", tumbleType + "tumblestone");
            ResourceLocation tumbleSmallBudID = ResourceLocation.fromNamespaceAndPath("cobblemon", "small_budding_" + tumbleType + "tumblestone");
            ResourceLocation tumbleMediumBudID = ResourceLocation.fromNamespaceAndPath("cobblemon", "medium_budding_" + tumbleType + "tumblestone");
            ResourceLocation tumbleLargeBudID = ResourceLocation.fromNamespaceAndPath("cobblemon", "large_budding_" + tumbleType + "tumblestone");
            ResourceLocation tumbleClusterID = ResourceLocation.fromNamespaceAndPath("cobblemon", tumbleType + "tumblestone_cluster");

            Item seedItem = BuiltInRegistries.ITEM.get(tumbleID);
            Block clusterBlock = BuiltInRegistries.BLOCK.get(tumbleClusterID);
            Item smallBudItem = BuiltInRegistries.ITEM.get(tumbleSmallBudID);
            Item mediumBudItem = BuiltInRegistries.ITEM.get(tumbleMediumBudID);
            Item largeBudItem = BuiltInRegistries.ITEM.get(tumbleLargeBudID);
            Item clusterItem = BuiltInRegistries.ITEM.get(tumbleClusterID);

            List<StackWithChance> outputs = List.of(
                    new StackWithChance(new TagOutput(smallBudItem, 1), chanceGuaranteed),
                    new StackWithChance(new TagOutput(mediumBudItem, 1), chanceHigh),
                    new StackWithChance(new TagOutput(largeBudItem, 1), chanceMedium),
                    new StackWithChance(new TagOutput(clusterItem, 1), chanceLow)
            );

            ClocheRecipe recipe = new ClocheRecipe(
                    outputs,
                    Ingredient.of(seedItem),
                    soilMagma,
                    timeDoubled,
                    fluidLava,
                    new ClocheRenderFunctions.RenderFunctionGeneric(clusterBlock)
            );

            ResourceLocation recipeID = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "cloche/tumblestones/" + tumbleType + "tumblestone_on_magma");
            output.accept(recipeID, recipe, null);
        }

        // for-loop dealing with the apridex
        for (String apricornName : Dexes.APRIDEX) {
            ResourceLocation apricornSproutID = ResourceLocation.fromNamespaceAndPath("cobblemon", apricornName + "_apricorn_seed");
            ResourceLocation apricornFruitID = ResourceLocation.fromNamespaceAndPath("cobblemon", apricornName + "_apricorn");
            ResourceLocation apricornSaplingID = ResourceLocation.fromNamespaceAndPath("cobblemon", apricornName + "_apricorn_sapling");

            Item apricornSprout = BuiltInRegistries.ITEM.get(apricornSproutID);
            TagKey<Item> dtapricornSprout = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "compat/" + apricornName + "_dt_apricorn"));
            Block apricornBlock = BuiltInRegistries.BLOCK.get(apricornSaplingID);
            Item apricornFruit = BuiltInRegistries.ITEM.get(apricornFruitID);

            List<StackWithChance> outputs = List.of(
                    new StackWithChance(new TagOutput(apricornFruit, 1), chanceGuaranteed),
                    new StackWithChance(new TagOutput(apricornSprout, 1), 0.1F)
            );

            List<StackWithChance> dtOutputs = List.of(
                    new  StackWithChance(new TagOutput(apricornFruit, 1), chanceGuaranteed),
                    new StackWithChance(new TagOutput(dtapricornSprout, 1), 0.1F)
            );

            ClocheRecipe recipe = new ClocheRecipe(
                    outputs,
                    Ingredient.of(apricornSprout),
                    soilDirt,
                    timeDoubled,
                    fluidWater,
                    new ClocheRenderFunctions.RenderFunctionGeneric(apricornBlock)
            );

            ClocheRecipe dtRecipe = new ClocheRecipe(
                    dtOutputs,
                    Ingredient.of(dtapricornSprout),
                    soilDirt,
                    timeDoubled,
                    fluidWater,
                    new ClocheRenderFunctions.RenderFunctionGeneric(apricornBlock)
            );

            ResourceLocation recipeID = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "cloche/apricorns/" + apricornName + "_apricorn_on_dirt");
            output.accept(recipeID, recipe, null);

            ResourceLocation dtRecipeID = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "cloche/apricorns/" + apricornName + "_dt_apricorn_on_dirt");
            dynamictreescobblemonOutput.accept(dtRecipeID, dtRecipe, null);

            ClocheRecipe farmersdelightRecipe = new ClocheRecipe(
                    outputs,
                    Ingredient.of(apricornSprout),
                    soilRich,
                    timeStandard,
                    fluidWater,
                    new ClocheRenderFunctions.RenderFunctionGeneric(apricornBlock)
            );

            ClocheRecipe dtFarmersdelightRecipe = new ClocheRecipe(
                    dtOutputs,
                    Ingredient.of(dtapricornSprout),
                    soilRich,
                    timeStandard,
                    fluidWater,
                    new ClocheRenderFunctions.RenderFunctionGeneric(apricornBlock)
            );

            ResourceLocation farmersdelightRecipeID = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "cloche/apricorns/" + apricornName + "_apricorn_on_rich_soil");
            farmersdelightOutput.accept(farmersdelightRecipeID, farmersdelightRecipe, null);

            ResourceLocation dtFarmersdelightRecipeID = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "cloche/apricorns/" + apricornName + "_dt_apricorn_on_rich_soil");
            dynamictreescobblemonOutput.accept(dtFarmersdelightRecipeID, dtFarmersdelightRecipe, null);
        }

        for (MiscCrop crop : MISCDEX) {
            registerCropCloche(output, farmersdelightOutput, "misc", crop);
        }

    }
}