package com.tomtaru.tmtceic.block;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class AprigelBlock extends LiquidBlock {
    public AprigelBlock(Supplier<? extends FlowingFluid> fluidSupplier) {
        super(fluidSupplier.get(), BlockBehaviour.Properties.of()
                .mapColor(MapColor.WATER)
                .strength(100f)
                .noCollission()
                .noLootTable()
                .liquid()
                .pushReaction(PushReaction.DESTROY)
                .sound(SoundType.EMPTY)
                .replaceable());
    }
}