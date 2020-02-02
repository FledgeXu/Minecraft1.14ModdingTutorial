package com.otakusaikou.tour14.tileentities;

import com.otakusaikou.tour14.gui.FilterBlockContainer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class FilterBlockTileEntity extends TileEntity implements INamedContainerProvider {

  private LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);

  public FilterBlockTileEntity() {
    super(ModTileEntitiesType.filterBlockTileEntityType);
  }

  @Override
  public void read(CompoundNBT compound) {
    handler.ifPresent(h->{
      CompoundNBT filterCompound = compound.getCompound("item");
      ((INBTSerializable<CompoundNBT>)h).deserializeNBT(filterCompound);
    });
    super.read(compound);
  }

  @Override
  public CompoundNBT write(CompoundNBT compound) {
    handler.ifPresent(h->{
      CompoundNBT filterCompound = ((INBTSerializable<CompoundNBT>)h).serializeNBT();
      compound.put("item", filterCompound);
    });
    return super.write(compound);
  }

  private IItemHandler createHandler() {
    ItemStackHandler handler = new ItemStackHandler() {
      @Override
      public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
        return stack.getItem() == Items.DIAMOND;
      }

      @Nonnull
      @Override
      public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
        if (stack.getItem() != Items.DIAMOND) {
          return stack;
        }
        return super.insertItem(slot, stack, simulate);
      }
    };
    handler.setSize(1);
    return handler;
  }

  @Nonnull
  @Override
  public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
    if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
      return handler.cast();
    }
    return super.getCapability(cap, side);
  }

  @Override
  public ITextComponent getDisplayName() {
    return new TranslationTextComponent("name.tour14.filter",getType().getRegistryName().getPath());
  }

  @Nullable
  @Override
  public Container createMenu(int i, PlayerInventory playerInventory,
      PlayerEntity playerEntity) {
    return new FilterBlockContainer(i,world,pos,playerInventory,playerEntity);
  }
}
