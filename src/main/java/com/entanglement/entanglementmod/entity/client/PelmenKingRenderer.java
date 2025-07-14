package com.entanglement.entanglementmod.entity.client;

import com.entanglement.entanglementmod.Entanglement;
import com.entanglement.entanglementmod.entity.custom.PelmenKingEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.CreeperRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.Creeper;

public class PelmenKingRenderer extends MobRenderer<PelmenKingEntity, PelmenKingRenderState, PelmenKingModel> {
    private static final ResourceLocation PELMEN_KING_LOCATION = ResourceLocation.fromNamespaceAndPath(Entanglement.MODID, "textures/pelmen_king/pelmen_king_universal.png");

    public PelmenKingRenderer(EntityRendererProvider.Context context) {

        super(context, new PelmenKingModel(context.bakeLayer(PelmenKingModel.LAYER_LOCATION)), 1F);
    }

    public ResourceLocation getTextureLocation(PelmenKingRenderState renderState) {
        return PELMEN_KING_LOCATION;
    }

    public PelmenKingRenderState createRenderState() {
        return new PelmenKingRenderState();
    }

    protected void scale(PelmenKingRenderState renderState, PoseStack poseStack) {
        poseStack.scale(1f, 1f, 1f);
    }

    public void extractRenderState(PelmenKingEntity entity, PelmenKingRenderState renderState, float partialTick) {
        super.extractRenderState(entity, renderState, partialTick);
    }
}
