package com.otakusaikou.tour14.items;

import com.otakusaikou.tour14.util.Utils;
import net.minecraft.item.Item;

public class ObsidianIngot extends Item {
    public ObsidianIngot() {
        super(new Properties().group(Utils.itemGroup));
        this.setRegistryName("obsidian_ingot");
    }
}
