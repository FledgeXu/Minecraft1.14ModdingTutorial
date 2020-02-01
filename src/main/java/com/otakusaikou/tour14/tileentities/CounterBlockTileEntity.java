package com.otakusaikou.tour14.tileentities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;

public class CounterBlockTileEntity extends TileEntity {
  private int counter=0;
  public int increase(){
    counter++;
    markDirty();
    return counter;
  }
  public int decrease(){
    counter--;
    markDirty();
    return counter;
  }

  @Override
  public void read(CompoundNBT compound) {
    super.read(compound);
    counter= compound.getInt("counter");
  }

  @Override
  public CompoundNBT write(CompoundNBT compound) {
    compound.putInt("counter",counter);
    super.write(compound);
    return compound;
  }

  public CounterBlockTileEntity() {
    super(ModTileEntitiesType.counterBlockTileEntityType);
  }
}
