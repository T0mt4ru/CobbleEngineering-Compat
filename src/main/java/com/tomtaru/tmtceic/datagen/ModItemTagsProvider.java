package com.tomtaru.tmtceic.datagen;

import com.tomtaru.tmtceic.Tmtceic;
import com.tomtaru.tmtceic.datagen.recipeproviders.Dexes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(PackOutput output,
                               CompletableFuture<HolderLookup.Provider> lookupProvider,
                               CompletableFuture<TagsProvider.TagLookup<Block>> blockTags,
                               ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Tmtceic.MODID, existingFileHelper);
    }

    public static final Map<String, TagKey<Item>> DT_APRICORN_TAGS = new HashMap<>();

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        TagKey<Item> richSoilCompat = TagKey.create(Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "compat/rich_soil"));

        tag(richSoilCompat).addOptional(ResourceLocation.fromNamespaceAndPath("farmersdelight", "rich_soil"));

        for (String apricorn : Dexes.APRIDEX) {
            TagKey<Item> tag = TagKey.create(Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "compat/" + apricorn + "_dt_apricorn"));

            DT_APRICORN_TAGS.put(apricorn, tag);

        tag(tag).addOptional(
                ResourceLocation.fromNamespaceAndPath("dtcobblemon", apricorn + "_apricorn_seed")
        );
        }
    }
}