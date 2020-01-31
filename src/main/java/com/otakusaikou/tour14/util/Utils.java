package com.otakusaikou.tour14.util;

import com.otakusaikou.tour14.items.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Utils {
    public static ItemGroup itemGroup = new ItemGroup("tour14") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.obsidianIngot);
        }
    };
}
