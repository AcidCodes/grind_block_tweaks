package com.gillie.grind_block_tweaks.event;

import com.gillie.grind_block_tweaks.GrindBlockTweaks;
import com.gillie.grind_block_tweaks.fluid.ModFluids;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = GrindBlockTweaks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModFluids.ENCHANT_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.LIQUID_ENCHANT.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.LIQUID_ENCHANT_FLOWING.get(), RenderType.translucent());
    }
}
