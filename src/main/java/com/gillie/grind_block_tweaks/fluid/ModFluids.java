package com.gillie.grind_block_tweaks.fluid;

import com.gillie.grind_block_tweaks.GrindBlockTweaks;
import com.gillie.grind_block_tweaks.block.ModBlocks;
import com.gillie.grind_block_tweaks.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    //Define Variables for Texture Resource Locations
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");
    public static final ResourceLocation MOLTEN_STILL_RL = new ResourceLocation("grind_block_tweaks", "block/molten_still");
    public static final ResourceLocation MOLTEN_FLOW_RL = new ResourceLocation("grind_block_tweaks", "block/molten_flow");
    public static final ResourceLocation CALC_STILL_RL = new ResourceLocation("grind_block_tweaks", "block/liquid_calculation_still");
    public static final ResourceLocation CALC_FLOW_RL = new ResourceLocation("grind_block_tweaks", "block/liquid_calculation_flow");
    public static final ResourceLocation ENGI_STILL_RL = new ResourceLocation("grind_block_tweaks", "block/liquid_engineering_still");
    public static final ResourceLocation ENGI_FLOW_RL = new ResourceLocation("grind_block_tweaks", "block/liquid_engineering_flow");
    public static final ResourceLocation LOGI_STILL_RL = new ResourceLocation("grind_block_tweaks", "block/liquid_logic_still");
    public static final ResourceLocation LOGI_FLOW_RL = new ResourceLocation("grind_block_tweaks", "block/liquid_logic_flow");
    public static final ResourceLocation PARA_STILL_RL = new ResourceLocation("grind_block_tweaks", "block/liquid_parallel_still");
    public static final ResourceLocation PARA_FLOW_RL = new ResourceLocation("grind_block_tweaks", "block/liquid_parallel_flow");


    //Create the register for Fluids
    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, GrindBlockTweaks.MOD_ID);

    //Register Liquid Enchant
    public static final RegistryObject<FlowingFluid> LIQUID_ENCHANT
            = FLUIDS.register("liquid_enchant", () -> new ForgeFlowingFluid.Source(ModFluids.ENCHANT_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIQUID_ENCHANT_FLOWING
            = FLUIDS.register("liquid_enchant_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.ENCHANT_PROPERTIES));


    public static final ForgeFlowingFluid.Properties ENCHANT_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIQUID_ENCHANT.get(), () -> LIQUID_ENCHANT_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.WATER_AMBIENT).overlay(WATER_OVERLAY_RL)
            .color(0xaaff4cfc)).slopeFindDistance(1).levelDecreasePerBlock(1)
            .block(() -> ModFluids.ENCHANT_BLOCK.get()).bucket(() -> ModItems.ENCHANT_BUCKET.get());

    public static final RegistryObject<LiquidBlock> ENCHANT_BLOCK = ModBlocks.BLOCKS.register("liquid_enchant_block",
            () -> new LiquidBlock(() -> ModFluids.LIQUID_ENCHANT.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f).noDrops()));


    //Register Liquid Source
    public static final RegistryObject<FlowingFluid> LIQUID_SOURCE
            = FLUIDS.register("liquid_source", () -> new ForgeFlowingFluid.Source(ModFluids.SOURCE_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIQUID_SOURCE_FLOWING
            = FLUIDS.register("liquid_source_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.SOURCE_PROPERTIES));


    public static final ForgeFlowingFluid.Properties SOURCE_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIQUID_SOURCE.get(), () -> LIQUID_SOURCE_FLOWING.get(), FluidAttributes.builder(MOLTEN_STILL_RL, MOLTEN_FLOW_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.LAVA_AMBIENT)
            .color(0xaaff00e1)).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> ModFluids.SOURCE_BLOCK.get()).bucket(() -> ModItems.SOURCE_BUCKET.get());

    public static final RegistryObject<LiquidBlock> SOURCE_BLOCK = ModBlocks.BLOCKS.register("liquid_source_block",
            () -> new LiquidBlock(() -> ModFluids.LIQUID_SOURCE.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f).noDrops()));


    //Register Liquid Calculation Processor
    public static final RegistryObject<FlowingFluid> LIQUID_CALC
            = FLUIDS.register("liquid_calculation", () -> new ForgeFlowingFluid.Source(ModFluids.CALC_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIQUID_CALC_FLOWING
            = FLUIDS.register("liquid_calculation_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.CALC_PROPERTIES));


    public static final ForgeFlowingFluid.Properties CALC_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIQUID_CALC.get(), () -> LIQUID_CALC_FLOWING.get(), FluidAttributes.builder(CALC_STILL_RL, CALC_FLOW_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.LAVA_AMBIENT))
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> ModFluids.CALC_BLOCK.get()).bucket(() -> ModItems.CALC_BUCKET.get());

    public static final RegistryObject<LiquidBlock> CALC_BLOCK = ModBlocks.BLOCKS.register("liquid_calculation_block",
            () -> new LiquidBlock(() -> ModFluids.LIQUID_CALC.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f).noDrops()));


    //Register Liquid Engineering Processor
    public static final RegistryObject<FlowingFluid> LIQUID_ENGI
            = FLUIDS.register("liquid_engineering", () -> new ForgeFlowingFluid.Source(ModFluids.ENGI_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIQUID_ENGI_FLOWING
            = FLUIDS.register("liquid_engineering_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.ENGI_PROPERTIES));


    public static final ForgeFlowingFluid.Properties ENGI_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIQUID_ENGI.get(), () -> LIQUID_ENGI_FLOWING.get(), FluidAttributes.builder(ENGI_STILL_RL, ENGI_FLOW_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.LAVA_AMBIENT))
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> ModFluids.ENGI_BLOCK.get()).bucket(() -> ModItems.ENGI_BUCKET.get());

    public static final RegistryObject<LiquidBlock> ENGI_BLOCK = ModBlocks.BLOCKS.register("liquid_engineering_block",
            () -> new LiquidBlock(() -> ModFluids.LIQUID_ENGI.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f).noDrops()));


    //Register Liquid Logic Processor
    public static final RegistryObject<FlowingFluid> LIQUID_LOGI
            = FLUIDS.register("liquid_logic", () -> new ForgeFlowingFluid.Source(ModFluids.LOGI_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIQUID_LOGI_FLOWING
            = FLUIDS.register("liquid_logic_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.LOGI_PROPERTIES));


    public static final ForgeFlowingFluid.Properties LOGI_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIQUID_LOGI.get(), () -> LIQUID_LOGI_FLOWING.get(), FluidAttributes.builder(LOGI_STILL_RL, LOGI_FLOW_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.LAVA_AMBIENT))
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> ModFluids.LOGI_BLOCK.get()).bucket(() -> ModItems.LOGI_BUCKET.get());

    public static final RegistryObject<LiquidBlock> LOGI_BLOCK = ModBlocks.BLOCKS.register("liquid_logic_block",
            () -> new LiquidBlock(() -> ModFluids.LIQUID_LOGI.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f).noDrops()));


    //Register Liquid Parallel Processor
    public static final RegistryObject<FlowingFluid> LIQUID_PARA
            = FLUIDS.register("liquid_parallel", () -> new ForgeFlowingFluid.Source(ModFluids.PARA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIQUID_PARA_FLOWING
            = FLUIDS.register("liquid_parallel_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.PARA_PROPERTIES));


    public static final ForgeFlowingFluid.Properties PARA_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIQUID_PARA.get(), () -> LIQUID_PARA_FLOWING.get(), FluidAttributes.builder(PARA_STILL_RL, PARA_FLOW_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.LAVA_AMBIENT))
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> ModFluids.PARA_BLOCK.get()).bucket(() -> ModItems.PARA_BUCKET.get());

    public static final RegistryObject<LiquidBlock> PARA_BLOCK = ModBlocks.BLOCKS.register("liquid_parallel_block",
            () -> new LiquidBlock(() -> ModFluids.LIQUID_PARA.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f).noDrops()));


    //Register Liquified Mana Diamond
    public static final RegistryObject<FlowingFluid> LIQUID_MDIAMOND
            = FLUIDS.register("liquified_mana_diamond", () -> new ForgeFlowingFluid.Source(ModFluids.MDIAMOND_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIQUID_MDIAMOND_FLOWING
            = FLUIDS.register("liquified_mana_diamond_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.MDIAMOND_PROPERTIES));


    public static final ForgeFlowingFluid.Properties MDIAMOND_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIQUID_MDIAMOND.get(), () -> LIQUID_MDIAMOND_FLOWING.get(), FluidAttributes.builder(MOLTEN_STILL_RL, MOLTEN_FLOW_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.LAVA_AMBIENT)
            .color(0xaa42d7f5)).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> ModFluids.MDIAMOND_BLOCK.get()).bucket(() -> ModItems.MDIAMOND_BUCKET.get());

    public static final RegistryObject<LiquidBlock> MDIAMOND_BLOCK = ModBlocks.BLOCKS.register("liquified_mana_diamond_block",
            () -> new LiquidBlock(() -> ModFluids.LIQUID_MDIAMOND.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f).noDrops()));


    //Register Liquified Dragonstone
    public static final RegistryObject<FlowingFluid> LIQUID_DRAGONSTONE
            = FLUIDS.register("liquified_dragonstone", () -> new ForgeFlowingFluid.Source(ModFluids.DRAGONSTONE_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIQUID_DRAGONSTONE_FLOWING
            = FLUIDS.register("liquified_dragonstone_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.DRAGONSTONE_PROPERTIES));


    public static final ForgeFlowingFluid.Properties DRAGONSTONE_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIQUID_DRAGONSTONE.get(), () -> LIQUID_DRAGONSTONE_FLOWING.get(), FluidAttributes.builder(MOLTEN_STILL_RL, MOLTEN_FLOW_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.LAVA_AMBIENT)
            .color(0xaaf542f2)).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> ModFluids.DRAGONSTONE_BLOCK.get()).bucket(() -> ModItems.DRAGONSTONE_BUCKET.get());

    public static final RegistryObject<LiquidBlock> DRAGONSTONE_BLOCK = ModBlocks.BLOCKS.register("liquified_dragonstone_block",
            () -> new LiquidBlock(() -> ModFluids.LIQUID_DRAGONSTONE.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f).noDrops()));


    //Register Liquifacted Mana Pearl
    public static final RegistryObject<FlowingFluid> LIQUID_MPEARL
            = FLUIDS.register("liquifacted_mana_pearl", () -> new ForgeFlowingFluid.Source(ModFluids.MPEARL_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIQUID_MPEARL_FLOWING
            = FLUIDS.register("liquifacted_mana_pearl_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.MPEARL_PROPERTIES));


    public static final ForgeFlowingFluid.Properties MPEARL_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIQUID_MPEARL.get(), () -> LIQUID_MPEARL_FLOWING.get(), FluidAttributes.builder(MOLTEN_STILL_RL, MOLTEN_FLOW_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.LAVA_AMBIENT)
            .color(0xaa42aaf5)).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> ModFluids.MPEARL_BLOCK.get()).bucket(() -> ModItems.MPEARL_BUCKET.get());

    public static final RegistryObject<LiquidBlock> MPEARL_BLOCK = ModBlocks.BLOCKS.register("liquifacted_mana_pearl_block",
            () -> new LiquidBlock(() -> ModFluids.LIQUID_MPEARL.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f).noDrops()));


    //Register Liquifacted Pixie Dust
    public static final RegistryObject<FlowingFluid> LIQUID_PDUST
            = FLUIDS.register("liquifacted_pixie_dust", () -> new ForgeFlowingFluid.Source(ModFluids.PDUST_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LIQUID_PDUST_FLOWING
            = FLUIDS.register("liquifacted_pixie_dust_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.PDUST_PROPERTIES));


    public static final ForgeFlowingFluid.Properties PDUST_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LIQUID_PDUST.get(), () -> LIQUID_PDUST_FLOWING.get(), FluidAttributes.builder(MOLTEN_STILL_RL, MOLTEN_FLOW_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.LAVA_AMBIENT)
            .color(0xaada42f5)).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> ModFluids.PDUST_BLOCK.get()).bucket(() -> ModItems.PDUST_BUCKET.get());

    public static final RegistryObject<LiquidBlock> PDUST_BLOCK = ModBlocks.BLOCKS.register("liquifacted_pixie_dust_block",
            () -> new LiquidBlock(() -> ModFluids.LIQUID_PDUST.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f).noDrops()));

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
