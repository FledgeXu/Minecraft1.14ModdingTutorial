package com.otakusaikou.tour14.util;

import com.otakusaikou.tour14.blocks.FilterBlock;
import com.otakusaikou.tour14.blocks.ModBlocks;
import com.otakusaikou.tour14.gui.ModGuiContainerType;
import com.otakusaikou.tour14.items.ModItems;
import com.otakusaikou.tour14.tileentities.ModTileEntitiesType;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler {
    @SubscribeEvent
    public static void onBlocksRegistry(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(ModBlocks.obsidianBlock);
        event.getRegistry().register(ModBlocks.counterBlock);
        event.getRegistry().register(ModBlocks.filterBlock);

    }
    @SubscribeEvent
    public static void onItemsRegistry(RegistryEvent.Register<Item> event){
        event.getRegistry().register(ModItems.obsidianIngot);
        event.getRegistry().register(new BlockItem(ModBlocks.obsidianBlock, new Item.Properties().group(Utils.itemGroup))
                .setRegistryName(ModBlocks.obsidianBlock.getRegistryName())
        );
        event.getRegistry().register(new BlockItem(ModBlocks.counterBlock, new Item.Properties().group(Utils.itemGroup))
            .setRegistryName(ModBlocks.counterBlock.getRegistryName())
        );
        event.getRegistry().register(new BlockItem(ModBlocks.filterBlock, new Properties().group(Utils.itemGroup))
            .setRegistryName(ModBlocks.filterBlock.getRegistryName())
        );
    }
    @SubscribeEvent
    public static void onTileEntitiesRegistry(RegistryEvent.Register<TileEntityType<?>> event) {
        event.getRegistry().register(ModTileEntitiesType.counterBlockTileEntityType);
        event.getRegistry().register(ModTileEntitiesType.filterBlockTileEntityType);
    }
    @SubscribeEvent
    public static void onContainerRegistry(RegistryEvent.Register<ContainerType<?>> event){
        event.getRegistry().register(ModGuiContainerType.filterBlockContainerType);
    }

}
