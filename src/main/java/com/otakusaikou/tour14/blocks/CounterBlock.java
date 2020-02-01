package com.otakusaikou.tour14.blocks;

import com.otakusaikou.tour14.tilesentities.CounterBlockTileEntity;
import com.otakusaikou.tour14.tilesentities.ModTileEntitiesType;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class CounterBlock extends Block {
  public CounterBlock() {
    super(Properties.create(Material.ROCK)
        .harvestLevel(3)
        .sound(SoundType.STONE)
        .hardnessAndResistance(5f)
    );
    this.setRegistryName("counter_block");
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
  protected void fillStateContainer(Builder<net.minecraft.block.Block, BlockState> builder) {
    builder.add(BlockStateProperties.FACING);
  }

  @Override
  public boolean hasTileEntity(BlockState state) {
    return true;
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return ModTileEntitiesType.counterBlockTileEntityType.create();
  }

  @Override
  public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos,
      PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    if(!worldIn.isRemote){
      if(hit.getFace()==state.getBlockState().get(BlockStateProperties.FACING)){
        int counter;
        if(hit.getHitVec().y-hit.getPos().getY()>0.5F){
          counter = getTE(worldIn, pos).increase();
        }else{
          counter = getTE(worldIn, pos).decrease();
        }
        TranslationTextComponent translationTextComponent = new TranslationTextComponent("message.tour14.counter", counter);
        translationTextComponent.getStyle().setColor(TextFormatting.BLUE);
        player.sendStatusMessage(translationTextComponent,false);
      }
    }
    return true;
  }
  private CounterBlockTileEntity getTE(World world, BlockPos pos){
    return (CounterBlockTileEntity)world.getTileEntity(pos);
  }
}

