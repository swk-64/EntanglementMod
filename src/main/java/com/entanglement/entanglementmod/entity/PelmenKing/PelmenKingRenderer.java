package com.entanglement.entanglementmod.entity.PelmenKing;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.entanglement.entanglementmod.Entanglement.MODID;
import static com.entanglement.entanglementmod.Entanglement.PELMEN_AND_CROWN_LAYER;

public class PelmenKingRenderer extends MobRenderer<PelmenKing, PelmenKingRenderState, PelmenKingModel> {
    // In our constructor, we just forward to super.
    public PelmenKingRenderer(EntityRendererProvider.Context context) {
        // For LivingEntityRenderer, the super constructor requires a "base" model and a shadow radius to be supplied.
        super(context, new PelmenKingModel(context.bakeLayer(PELMEN_AND_CROWN_LAYER)), 0.5f);
        // Add the layer. Get the EntityModelSet from the context. For the purpose of the example,
        // we ignore that the render layer renders the "base" model, this would be a different model in practice.
    }
    // Tell the render engine how to create a new entity render state.
    @Override
    public PelmenKingRenderState createRenderState() {
        return new PelmenKingRenderState();
    }

    @Override
    public void extractRenderState(PelmenKing entity, PelmenKingRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);

    }

    // Update the render state by copying the needed values from the passed entity to the passed state.
    // Both Entity and EntityRenderState may be replaced with more concrete types,
    // based on the generic types that have been passed to the supertype.
    @Override
    public void render(PelmenKingRenderState state, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        super.render(state, poseStack, bufferSource, packedLight);

    }

    @Override
    public ResourceLocation getTextureLocation(PelmenKingRenderState state) {
        return ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/pelmen_king/pelmen_king.png"); // ??? reads data from
    }
}