package com.otakusaikou.tour14.util;

import com.otakusaikou.tour14.Tour14;
import com.otakusaikou.tour14.blocks.FancyBakedModel;
import com.otakusaikou.tour14.blocks.ModBlocks;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Tour14.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventsHandler {
    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre event) {
        if (!event.getMap().getBasePath().equals("textures")) {
            return;
        }
        event.addSprite(new ResourceLocation(Tour14.MODID, "block/fancy_block"));
    }

    @SubscribeEvent
    public static void onModelBake(ModelBakeEvent event) {
        event.getModelRegistry().put(new ModelResourceLocation(ModBlocks.fancyBlock.getRegistryName(), ""),
                new FancyBakedModel(DefaultVertexFormats.BLOCK));
        event.getModelRegistry().put(new ModelResourceLocation(ModBlocks.fancyBlock.getRegistryName(), "inventory"),
                new FancyBakedModel(DefaultVertexFormats.ITEM));
    }
}
