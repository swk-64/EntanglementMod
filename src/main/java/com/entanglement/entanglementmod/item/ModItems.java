package com.entanglement.entanglementmod.item;

import com.entanglement.entanglementmod.Entanglement;
import com.entanglement.entanglementmod.entity.ModEntities;
import com.entanglement.entanglementmod.entity.custom.PelmenKingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.armadillo.Armadillo;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;

import static net.minecraft.world.item.Items.registerItem;

public class ModItems {


    public static final EntityType<PelmenKingEntity> PELMENKING = register(
            "pelmen_king", EntityType.Builder.of(PelmenKingEntity::new, MobCategory.CREATURE).sized(1F, 1F).clientTrackingRange(10)
    );


    public static final DeferredItem<Item> Pelmen_King_SPAWN_EGG = Entanglement.ITEMS.registerItem("pelmen_king_spawn_egg", properties -> new SpawnEggItem(ModEntities.PELMENKING, properties))


}
