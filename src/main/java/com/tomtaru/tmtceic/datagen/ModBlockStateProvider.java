package com.tomtaru.tmtceic.datagen;

import com.tomtaru.tmtceic.Tmtceic;
import com.tomtaru.tmtceic.registry.ModAprigels;
import com.tomtaru.tmtceic.registry.ModMedicinals;
import com.tomtaru.tmtceic.registry.SimpleFluidRegistrar;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.minecraft.data.PackOutput;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Tmtceic.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        ModelFile aprigelModel = models()
                .getBuilder("block/aprigel_fluid")
                .texture("particle", ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "block/aprigel_still"))
                .texture("all", ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "block/aprigel_still"))
                .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/cube_all")));

        for (ModAprigels.AprigelEntry entry : ModAprigels.entries()) {
            registerLiquidBlock(entry.block().get(), aprigelModel);
        }

        for (SimpleFluidRegistrar.Entry entry : ModMedicinals.entries()) {
            ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "block/" + entry.name() + "_still");
            ModelFile model = models()
                    .getBuilder("block/" + entry.name() + "_fluid")
                    .texture("particle", texture)
                    .texture("all", texture)
                    .parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/cube_all")));
            registerLiquidBlock(entry.block().get(), model);
        }
    }

    private void registerLiquidBlock(Block block, ModelFile model) {
        var builder = getVariantBuilder(block);
        for (int level = 0; level <= 15; level++) {
            builder.partialState()
                    .with(LiquidBlock.LEVEL, level)
                    .setModels(new ConfiguredModel(model));
        }
    }
}