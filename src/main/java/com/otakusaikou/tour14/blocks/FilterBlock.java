package com.otakusaikou.tour14.blocks;

import com.otakusaikou.tour14.tileentities.ModTileEntitiesType;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class FilterBlock extends Block {
  public FilterBlock() {
    super(Properties.create(Material.ROCK)
        .harvestLevel(3)
        .sound(SoundType.STONE)
        .hardnessAndResistance(5f)
    );
    this.setRegistryName("filter_block");
  }


  @Override
  public void onBlockPlacedBy(
      World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
    if (placer != null) {
      worldIn.setBlockState(pos,
          state.with(BlockStateProperties.FACING, getFacingFromEntity(pos, placer)), 2);
    }
  }

  public static Direction getFacingFromEntity(BlockPos clickedBlock, LivingEntity entity) {
    Vec3d vec = entity.getPositionVec();
    return Direction.getFacingFromVector(
        (float) (vec.x - clickedBlock.getX()),
        (float) (vec.y - clickedBlock.getY()),
        (float) (vec.z - clickedBlock.getZ())
    );
  }

  @Override
  protected void fillStateContainer(Builder<Block, BlockState> builder) {
    builder.add(BlockStateProperties.FACING);
  }

  @Override
  public boolean hasTileEntity(BlockState state) {
    return true;
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return ModTileEntitiesType.filterBlockTileEntityType.create();
  }
}
