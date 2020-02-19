package com.otakusaikou.tour14.tileentities;

import com.otakusaikou.tour14.blocks.ModBlocks;
import net.minecraft.tileentity.TileEntityType;

public class ModTileEntitiesType {
    public static TileEntityType<?> counterBlockTileEntityType =
            TileEntityType.Builder.create(CounterBlockTileEntity::new, ModBlocks.counterBlock)
                    .build(null)
                    .setRegistryName(ModBlocks.counterBlock.getRegistryName());
    public static TileEntityType<?> filterBlockTileEntityType =
            TileEntityType.Builder.create(FilterBlockTileEntity::new, ModBlocks.filterBlock)
                    .build(null)
                    .setRegistryName(ModBlocks.filterBlock.getRegistryName());
    public static TileEntityType<?> fancyBlockTileEntityType =
            TileEntityType.Builder.create(FancyBlockTileEntity::new, ModBlocks.fancyBlock)
                    .build(null)
                    .setRegistryName(ModBlocks.fancyBlock.getRegistryName());
}
