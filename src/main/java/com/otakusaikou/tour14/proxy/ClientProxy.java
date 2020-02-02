package com.otakusaikou.tour14.proxy;

import com.otakusaikou.tour14.blocks.FilterBlock;
import com.otakusaikou.tour14.blocks.ModBlocks;
import com.otakusaikou.tour14.gui.FilterBlockContainer;
import com.otakusaikou.tour14.gui.FilterBlockScreen;
import com.otakusaikou.tour14.gui.ModGuiContainerType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.world.World;

public class ClientProxy implements IProxy {

  @Override
  public void init() {
    ScreenManager.registerFactory((ContainerType<FilterBlockContainer>)ModGuiContainerType.filterBlockContainerType,FilterBlockScreen::new);
  }

  @Override
  public World getClientWorld() {
    return Minecraft.getInstance().world;
  }

  @Override
  public PlayerEntity getClientPlayer() {
    return Minecraft.getInstance().player;
  }
}
