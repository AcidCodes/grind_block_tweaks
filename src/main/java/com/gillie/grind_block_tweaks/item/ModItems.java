package com.gillie.grind_block_tweaks.item;

import cofh.core.item.ItemCoFH;
import cofh.core.util.helpers.AugmentDataHelper;
import cofh.lib.util.DeferredRegisterCoFH;
import cofh.thermal.lib.item.AugmentItem;
import com.gillie.grind_block_tweaks.GrindBlockTweaks;
import com.gillie.grind_block_tweaks.fluid.ModFluids;
import com.gillie.grind_block_tweaks.item.custom.CustomAugmentItem;
import com.gillie.grind_block_tweaks.item.custom.GuardianKillItem;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static cofh.lib.util.constants.NBTTags.*;
import static cofh.thermal.lib.common.ThermalFlags.*;

public class ModItems {
    //Create register for Items
    public static final DeferredRegisterCoFH<Item> ITEMS =
            DeferredRegisterCoFH.create(ForgeRegistries.ITEMS, GrindBlockTweaks.MOD_ID);

    public static Rarity line_rarity = Rarity.create("lime", ChatFormatting.GREEN);


    //Register Insanium Egg
    public static final RegistryObject<Item> IEGG = ITEMS.register("insanium_egg",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.GBT_TAB)));

    //Register Machinium Ingot
    public static final RegistryObject<Item> MACHINIUM = ITEMS.register("machinium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.GBT_TAB)));

    //Register Multium Ingot
    public static final RegistryObject<Item> MULTIUM = ITEMS.register("multium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.GBT_TAB)));

    //Register Chaos Guardian Deleter
    public static final RegistryObject<Item> GUARDIAN_DELETER = ITEMS.register("chaos_guardian_deleter",
            () -> new GuardianKillItem(new Item.Properties().tab(ModCreativeModeTab.GBT_TAB)));

    //Register Flask of Infinity
    public static final RegistryObject<Item> INFINITY_SINGULARITY = ITEMS.register("flask_of_infinity",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.GBT_TAB).rarity(Rarity.EPIC)));

    //Register Ultimate Components
    public static final RegistryObject<ItemCoFH> ULTIMATE_COMPONENTS = ITEMS.register("ultimate_components", () -> new CustomAugmentItem(new Item.Properties().rarity(line_rarity).tab(ModCreativeModeTab.GBT_TAB).rarity(Rarity.EPIC),
            AugmentDataHelper.builder()
                    .type(TAG_AUGMENT_TYPE_UPGRADE)
                    .mod(TAG_AUGMENT_BASE_MOD, 10.0F)
                    .build()).setShowInGroups(getFlag(FLAG_UPGRADE_AUGMENTS)));

    //Register Ultimate Flux Linkage Amplifier
    public static final RegistryObject<Item> ULTIMATE_AMPLIFIER = ITEMS.register("ultimate_machine_speed_augment", () -> new AugmentItem(new Item.Properties().rarity(line_rarity).tab(ModCreativeModeTab.GBT_TAB).rarity(Rarity.EPIC),
            AugmentDataHelper.builder()
                    .type(TAG_AUGMENT_TYPE_MACHINE)
                    .mod(TAG_AUGMENT_MACHINE_POWER, 2.0F)
                    .mod(TAG_AUGMENT_MACHINE_ENERGY, 0.9F)
                    .build()).setShowInGroups(getFlag(FLAG_MACHINE_AUGMENTS)));


    //Register Buckets for Fluids
    public static final RegistryObject<Item> ENCHANT_BUCKET = ITEMS.register("liquid_enchant_bucket",
            () -> new BucketItem(ModFluids.LIQUID_ENCHANT, new Item.Properties().tab(ModCreativeModeTab.GBT_TAB).stacksTo(1)));
    public static final RegistryObject<Item> SOURCE_BUCKET = ITEMS.register("liquid_source_bucket",
            () -> new BucketItem(ModFluids.LIQUID_SOURCE, new Item.Properties().tab(ModCreativeModeTab.GBT_TAB).stacksTo(1)));
    public static final RegistryObject<Item> CALC_BUCKET = ITEMS.register("liquid_calculation_bucket",
            () -> new BucketItem(ModFluids.LIQUID_CALC, new Item.Properties().tab(ModCreativeModeTab.GBT_TAB).stacksTo(1)));
    public static final RegistryObject<Item> ENGI_BUCKET = ITEMS.register("liquid_engineering_bucket",
            () -> new BucketItem(ModFluids.LIQUID_ENGI, new Item.Properties().tab(ModCreativeModeTab.GBT_TAB).stacksTo(1)));
    public static final RegistryObject<Item> LOGI_BUCKET = ITEMS.register("liquid_logic_bucket",
            () -> new BucketItem(ModFluids.LIQUID_LOGI, new Item.Properties().tab(ModCreativeModeTab.GBT_TAB).stacksTo(1)));
    public static final RegistryObject<Item> PARA_BUCKET = ITEMS.register("liquid_parallel_bucket",
            () -> new BucketItem(ModFluids.LIQUID_PARA, new Item.Properties().tab(ModCreativeModeTab.GBT_TAB).stacksTo(1)));
    public static final RegistryObject<Item> MDIAMOND_BUCKET = ITEMS.register("liquified_mana_diamond_bucket",
            () -> new BucketItem(ModFluids.LIQUID_MDIAMOND, new Item.Properties().tab(ModCreativeModeTab.GBT_TAB).stacksTo(1)));
    public static final RegistryObject<Item> DRAGONSTONE_BUCKET = ITEMS.register("liquified_dragonstone_bucket",
            () -> new BucketItem(ModFluids.LIQUID_DRAGONSTONE, new Item.Properties().tab(ModCreativeModeTab.GBT_TAB).stacksTo(1)));
    public static final RegistryObject<Item> MPEARL_BUCKET = ITEMS.register("liquifacted_mana_pearl_bucket",
            () -> new BucketItem(ModFluids.LIQUID_MPEARL, new Item.Properties().tab(ModCreativeModeTab.GBT_TAB).stacksTo(1)));
    public static final RegistryObject<Item> PDUST_BUCKET = ITEMS.register("liquifacted_pixie_dust_bucket",
            () -> new BucketItem(ModFluids.LIQUID_PDUST, new Item.Properties().tab(ModCreativeModeTab.GBT_TAB).stacksTo(1)));


    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
