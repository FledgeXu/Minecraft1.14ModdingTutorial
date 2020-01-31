package com.otakusaikou.tour14.util;

import com.otakusaikou.tour14.blocks.ModBlocks;
import com.otakusaikou.tour14.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler {
    @SubscribeEvent
    public static void onBlocksRegistry(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(ModBlocks.obsidianBlock);
    }
    @SubscribeEvent
    public static void onItemsRegistry(RegistryEvent.Register<Item> event){
        event.getRegistry().register(ModItems.obsidianIngot);
        event.getRegistry().register(new BlockItem(ModBlocks.obsidianBlock, new Item.Properties())
                .setRegistryName(ModBlocks.obsidianBlock.getRegistryName())
        );
    }
}
