package com.otakusaikou.tour14.gui;

import com.otakusaikou.tour14.blocks.ModBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class FilterBlockContainer extends Container {

  private TileEntity tileEntity;
  private PlayerEntity playerEntity;
  private IItemHandler playerInventory;
  public FilterBlockContainer(int id, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity playerEntity) {
    super(ModGuiContainerType.filterBlockContainerType, id);
    tileEntity = world.getTileEntity(pos);
    this.tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
    this.playerEntity = playerEntity;
    this.playerInventory = new InvWrapper(playerInventory);
    tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
      addSlot(new SlotItemHandler(h, 0, 64, 24));
    });
    layoutPlayerInventorySlots(10, 70);
  }


  @Override
  public boolean canInteractWith(PlayerEntity playerIn) {
    return isWithinUsableDistance(IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos()), playerEntity, ModBlocks.filterBlock);
  }

  private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
    for (int i = 0 ; i < amount ; i++) {
      addSlot(new SlotItemHandler(handler, index, x, y));
      x += dx;
      index++;
    }
    return index;
  }

  private int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
      for (int j = 0 ; j < verAmount ; j++) {
        index = addSlotRange(handler, index, x, y, horAmount, dx);
        y += dy;
      }
      return index;
  }

  private void layoutPlayerInventorySlots(int leftCol, int topRow) {
    // Player inventory
    addSlotBox(playerInventory, 9, leftCol, topRow, 9, 18, 3, 18);

    // Hotbar
    topRow += 58;
    addSlotRange(playerInventory, 0, leftCol, topRow, 9, 18);
  }
}
