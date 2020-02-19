package com.otakusaikou.tour14.blocks;

import com.otakusaikou.tour14.Tour14;
import com.otakusaikou.tour14.tileentities.FancyBlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class FancyBlock extends Block {
    //private final VoxelShape shape = VoxelShapes.create(.2, .2, .2, .8, .8, .8);
    public FancyBlock() {
        super(Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(2.0f)
        );
        setRegistryName("fancy_block");
    }
//
//    @Override
//    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
//        return shape;
//    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new FancyBlockTileEntity();
    }

//    @Override
//    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
//        if(!worldIn.isRemote){
//            TileEntity te = worldIn.getTileEntity(pos);
//            if(te instanceof FancyBlockTileEntity) {
//                BlockPos testPost = new BlockPos(pos.getX()-1, pos.getY(),pos.getX());
//                BlockState mimicState = worldIn.getBlockState(pos);
//                ((FancyBlockTileEntity) te).setMimic(mimicState);
//            }
//        }
//        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
//    }
//
    @Override
    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
        ItemStack item = player.getHeldItem(hand);
        if (!item.isEmpty() && item.getItem() instanceof BlockItem) {
            if (!world.isRemote) {
                TileEntity te = world.getTileEntity(pos);
                if (te instanceof FancyBlockTileEntity) {
                    BlockState mimicState = ((BlockItem) item.getItem()).getBlock().getDefaultState();
                    ((FancyBlockTileEntity) te).setMimic(mimicState);
                }
            }
            return true;
        }
        return super.onBlockActivated(state, world, pos, player, hand, result);
    }
}
