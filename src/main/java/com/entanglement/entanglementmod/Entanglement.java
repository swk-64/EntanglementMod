package com.entanglement.entanglementmod;

import com.entanglement.entanglementmod.entity.PelmenKing.PelmenKing;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Entanglement.MODID)
public class Entanglement {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "entanglement";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();


//    // Create a Deferred Register to hold Blocks which will all be registered under the "entanglement" namespace
//    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);


    public static final DeferredRegister.Entities ENTITY_TYPES = DeferredRegister.createEntities(MODID);

    public static final Supplier<EntityType<PelmenKing>> PELMEN_KING_ENTITY =
            ENTITY_TYPES.registerEntityType("pelmen_king", PelmenKing::new, MobCategory.MONSTER);


    public static final ModelLayerLocation PELMEN_AND_CROWN_LAYER = new ModelLayerLocation(
            // Should be the name of the entity this layer belongs to.
            // May be more generic if this layer can be used on multiple entities.
            ResourceLocation.fromNamespaceAndPath(MODID, "pelmen_king"),
            // The name of the layer itself. Should be main for the entity's base model,
            // and a more descriptive name (e.g. "wings") for more specific layers.
            "main"
    );


    // Create a Deferred Register to hold Items which will all be registered under the "entanglement" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<Item> PELMEN_KING_SPAWN_EGG = ITEMS.registerItem(
            "pelmen_king_summon_egg",
            properties -> new SpawnEggItem(
                    PELMEN_KING_ENTITY.get(),
                    properties
            )
//            Item::new, // The factory that the properties will be passed into.
//            new Item.Properties() // The properties to use.
    );

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Entanglement(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading


        //modEventBus.addListener(this::commonSetup);

//        // Register the Deferred Register to the mod event bus so blocks get registered
//        BLOCKS.register(modEventBus);


        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);


        ENTITY_TYPES.register(modEventBus);

//        // Register the Deferred Register to the mod event bus so tabs get registered
//        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (Entanglement) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        //modEventBus.addListener(this::createDefaultAttributes);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us

        //modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

//    private void commonSetup(FMLCommonSetupEvent event) {
//        // Some common setup code
//        LOGGER.info("HELLO FROM COMMON SETUP");
//
//        if (Config.LOG_DIRT_BLOCK.getAsBoolean()) {
//            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
//        }
//
//        LOGGER.info("{}{}", Config.MAGIC_NUMBER_INTRODUCTION.get(), Config.MAGIC_NUMBER.getAsInt());
//
//        Config.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
//    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(PELMEN_KING_SPAWN_EGG);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    @EventBusSubscriber(modid = Entanglement.MODID)
    public static class CommonModEventHandler {
        @SubscribeEvent // on the mod event bus
        public static void createDefaultAttributes(EntityAttributeCreationEvent event) {
            event.put(PELMEN_KING_ENTITY.get(),
                    Monster.createMonsterAttributes()
                            .build()
            );
        }
    }
}
