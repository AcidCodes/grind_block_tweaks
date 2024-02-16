package com.gillie.grind_block_tweaks.block;

import com.gillie.grind_block_tweaks.GrindBlockTweaks;
import com.gillie.grind_block_tweaks.item.ModCreativeModeTab;
import com.gillie.grind_block_tweaks.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    //Create Register for Blocks
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GrindBlockTweaks.MOD_ID);


    //Register The Grind Block
    public static final RegistryObject<Block> GRINDBLOCK = registerBlock("the_grind_block",
            () ->  new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops()), ModCreativeModeTab.GBT_TAB);

    //Register Allthemodium Forge Casing
    public static final RegistryObject<Block> ACASING = registerBlock("allthemodium_forge_casing",
            () ->  new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops()), ModCreativeModeTab.GBT_TAB);

    //Register Unobtainium Forge Casing
    public static final RegistryObject<Block> UCASING = registerBlock("unobtainium_forge_casing",
            () ->  new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops()), ModCreativeModeTab.GBT_TAB);

    //Register Vibranium Forge Casing
    public static final RegistryObject<Block> VCASING = registerBlock("vibranium_forge_casing",
            () ->  new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops()), ModCreativeModeTab.GBT_TAB);


    //Create RegistryObject for the Block
    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    //Create RegistryObject for the Block Item
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
