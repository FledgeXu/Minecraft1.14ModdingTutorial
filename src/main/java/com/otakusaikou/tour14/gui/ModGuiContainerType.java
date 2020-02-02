package com.otakusaikou.tour14.gui;

import com.otakusaikou.tour14.Tour14;
import com.otakusaikou.tour14.blocks.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.DistExecutor;

public class ModGuiContainerType {

  public static ContainerType<?> filterBlockContainerType =
      IForgeContainerType.create((wordId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        return new FilterBlockContainer(
            wordId,
            Tour14.proxy.getClientWorld(),
            pos,
            inv,
            Tour14.proxy.getClientPlayer()
        );
      }).setRegistryName(ModBlocks.filterBlock.getRegistryName());
}
