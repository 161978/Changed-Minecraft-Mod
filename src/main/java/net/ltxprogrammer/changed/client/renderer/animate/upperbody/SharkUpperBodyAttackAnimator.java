package net.ltxprogrammer.changed.client.renderer.animate.upperbody;

import net.ltxprogrammer.changed.client.renderer.animate.HumanoidAnimator;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.UseItemMode;
import net.ltxprogrammer.changed.item.SpecializedAnimations;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import org.jetbrains.annotations.NotNull;

public class SharkUpperBodyAttackAnimator<T extends ChangedEntity, M extends EntityModel<T>> extends AbstractUpperBodyAnimator<T, M> {
    public SharkUpperBodyAttackAnimator(ModelPart head, ModelPart torso, ModelPart leftArm, ModelPart rightArm) {
        super(head, torso, leftArm, rightArm);
    }

    @Override
    public HumanoidAnimator.AnimateStage preferredStage() {
        return HumanoidAnimator.AnimateStage.ATTACK;
    }

    @Override
    public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        rightArm.yRot = 0.0F;
        leftArm.yRot = 0.0F;
        if (entity.getItemUseMode() != UseItemMode.NORMAL)
            return;

        boolean mainHandRight = entity.getMainArm() == HumanoidArm.RIGHT;
        if (entity.isUsingItem()) {
            boolean usingMainHand = entity.getUsedItemHand() == InteractionHand.MAIN_HAND;
            if (usingMainHand == mainHandRight) {
                this.poseRightArm(entity);
            } else {
                this.poseLeftArm(entity);
            }
        } else {
            boolean twoHanded = mainHandRight ? core.leftArmPose.isTwoHanded() : core.rightArmPose.isTwoHanded();
            if (mainHandRight != twoHanded) {
                this.poseLeftArm(entity);
                this.poseRightArm(entity);
            } else {
                this.poseRightArm(entity);
                this.poseLeftArm(entity);
            }
        }

        this.setupAttackAnimation(entity, ageInTicks);
    }
}
