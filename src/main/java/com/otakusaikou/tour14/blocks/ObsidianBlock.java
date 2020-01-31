package com.otakusaikou.tour14.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ObsidianBlock extends Block {
    public ObsidianBlock() {
        super(Properties.create(Material.ROCK)
                .harvestLevel(3)
                .sound(SoundType.STONE)
                .hardnessAndResistance(5f)
        );
        this.setRegistryName("obsidian_block");
    }
}
