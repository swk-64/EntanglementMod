package com.entanglement.entanglementmod.entity;

import com.entanglement.entanglementmod.Entanglement;
import com.entanglement.entanglementmod.entity.custom.PelmenKingEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Entanglement.MODID);

    public static final Supplier<EntityType<PelmenKingEntity>> PELMENKING =
            ENTITY_TYPES.register(
                    "pelmen_king",
                    () -> EntityType.Builder.of(PelmenKingEntity::new, MobCategory.CREATURE)
                    .sized(1.0f, 1.0f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE,
                            ResourceLocation.fromNamespaceAndPath(Entanglement.MODID, "pelmen_king")
                    ))
            );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
