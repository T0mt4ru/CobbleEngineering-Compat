package com.tomtaru.tmtceic.datagen;

import com.tomtaru.tmtceic.Tmtceic;
import com.tomtaru.tmtceic.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Tmtceic.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ALUMINUM_POKEBALL_FRAME.getId().getPath());
        simpleItem(ModItems.NETHERITE_POKEBALL_FRAME.getId().getPath());
        simpleItem(ModItems.MOLD_POKEBALL_FRAME.getId().getPath());
        simpleItem(ModItems.MOON_STONE_DUST.getId().getPath());
        simpleItem(ModItems.SHINY_STONE_DUST.getId().getPath());
        simpleItem(ModItems.SUN_STONE_DUST.getId().getPath());
    }

    private void simpleItem(String name) {
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + name));
    }
}