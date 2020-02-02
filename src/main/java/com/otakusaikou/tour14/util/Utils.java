package com.otakusaikou.tour14.util;

import com.otakusaikou.tour14.items.ModItems;
import com.otakusaikou.tour14.proxy.ClientProxy;
import com.otakusaikou.tour14.proxy.IProxy;
import com.otakusaikou.tour14.proxy.ServerProxy;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.DistExecutor;

public class Utils {
    public static ItemGroup itemGroup = new ItemGroup("tour14") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.obsidianIngot);
        }
    };
}
