package com.otakusaikou.tour14.tilesentities;

import com.otakusaikou.tour14.blocks.ModBlocks;
import net.minecraft.tileentity.TileEntityType;

public class ModTileEntitiesType {
  public static TileEntityType<?> counterBlockTileEntityType =
      TileEntityType.Builder.create(CounterBlockTileEntity::new, ModBlocks.counterBlock)
          .build(null)
          .setRegistryName(ModBlocks.counterBlock.getRegistryName());
}
