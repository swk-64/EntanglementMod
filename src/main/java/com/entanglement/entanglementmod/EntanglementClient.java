package com.entanglement.entanglementmod;

import com.entanglement.entanglementmod.entity.PelmenKing.PelmenKingModel;
import com.entanglement.entanglementmod.entity.PelmenKing.PelmenKingRenderer;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;


// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = Entanglement.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = Entanglement.MODID, value = Dist.CLIENT)
public class EntanglementClient {
    public EntanglementClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        Entanglement.LOGGER.info("MODDED CLIENT SETUP");
        Entanglement.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent // on the mod event bus only on the physical client
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        // Add our layer here.
        event.registerLayerDefinition(Entanglement.PELMEN_AND_CROWN_LAYER, PelmenKingModel::createBodyLayer); // ??? initially there was unexisting ".add" method ???
    }
    @SubscribeEvent // on the mod event bus only on the physical client
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Entanglement.PELMEN_KING_ENTITY.get(), PelmenKingRenderer::new);
    }


}
