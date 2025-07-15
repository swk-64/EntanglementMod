package com.entanglement.entanglementmod.entity.PelmenKing;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.entity.animation.json.AnimationHolder;

import static com.entanglement.entanglementmod.Entanglement.MODID;

public class PelmenKingModel extends EntityModel<PelmenKingRenderState> {

    private final ModelPart pelmen;
    private final ModelPart crown;

    public static final AnimationHolder PELMEN_UNIVERSAL_ANIMATION =
            Model.getAnimation(ResourceLocation.fromNamespaceAndPath(MODID, "neoforge/animations/entity/pelmen_universal.json"));

    private final KeyframeAnimation universal;

    public PelmenKingModel(ModelPart root) {
        super(root);

        this.pelmen = root.getChild("pelmen");
        this.crown = root.getChild("crown");


        this.universal = PELMEN_UNIVERSAL_ANIMATION.get().bake(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot();

        PartDefinition pelmen = root.addOrReplaceChild("pelmen", CubeListBuilder.create().texOffs(0, 19).addBox(-6.0F, -5.5F, -6.0F, 12.0F, 11.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-8.0F, -1.5F, -8.0F, 16.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 42).addBox(-4.0F, -6.5F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(32, 42).addBox(-4.0F, 5.5F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.5F, 0.0F));

        PartDefinition crown = root.addOrReplaceChild("crown", CubeListBuilder.create().texOffs(24, 51).addBox(-3.0F, -2.2F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(48, 19).addBox(-5.0F, 0.8F, 5.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(48, 22).addBox(-5.0F, 0.8F, -6.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(48, 37).addBox(1.0F, -0.2F, 5.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(48, 35).addBox(-4.0F, -0.2F, 5.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 51).addBox(-3.0F, -2.2F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 51).addBox(2.0F, -2.2F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(48, 33).addBox(1.0F, -0.2F, -6.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 51).addBox(2.0F, -2.2F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(48, 31).addBox(-4.0F, -0.2F, -6.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.2F, 0.0F));

        PartDefinition cube_r1 = crown.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(48, 51).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 51).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -0.2F, 2.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r2 = crown.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(52, 51).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 51).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -0.2F, -3.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r3 = crown.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(44, 51).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 51).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -0.2F, -3.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r4 = crown.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(40, 51).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(48, 39).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -0.2F, 2.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r5 = crown.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(48, 28).addBox(-5.0F, -2.0F, -1.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 2.8F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r6 = crown.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(48, 25).addBox(-5.0F, -2.0F, 0.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 2.8F, 0.0F, 0.0F, 1.5708F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(PelmenKingRenderState state) {
        super.setupAnim(state);
        this.universal.applyStatic();
    }
}
