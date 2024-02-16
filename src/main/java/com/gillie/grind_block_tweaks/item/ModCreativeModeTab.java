package com.gillie.grind_block_tweaks.item;

import com.gillie.grind_block_tweaks.block.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab GBT_TAB = (new CreativeModeTab("gbt_tab") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.GRINDBLOCK.get());
        }

        public boolean hasSearchBar() {
            return true;
        }

        public int getSearchbarWidth() {
            return 89;
        }

    }).setBackgroundImage(new ResourceLocation("textures/gui/container/creative_inventory/tab_item_search.png")).hideTitle();
}
