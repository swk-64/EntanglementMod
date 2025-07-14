package com.entanglement.entanglementmod.event;

import com.entanglement.entanglementmod.Entanglement;
import com.entanglement.entanglementmod.entity.ModEntities;
import com.entanglement.entanglementmod.entity.client.PelmenKingModel;
import com.entanglement.entanglementmod.entity.custom.PelmenKingEntity;
import com.google.common.eventbus.Subscribe;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = Entanglement.MODID)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PelmenKingModel.LAYER_LOCATION, PelmenKingModel::createBodyLayer);


    }
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.PELMENKING.get(), PelmenKingEntity.createAttributes().build());
    }
}
