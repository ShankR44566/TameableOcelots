package com.shankr44566.tameableocelots.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(OcelotEntity.class)
public abstract class OcelotEntityMixin extends AnimalEntity {

    protected OcelotEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!this.isTamed() && (stack.isOf(Items.COD) || stack.isOf(Items.SALMON))) {
            if (!player.getAbilities().creativeMode) {
                stack.decrement(1);
            }

            if (!this.getWorld().isClient) {
                this.setOwner(player);
                this.setTamed(true);
                this.getWorld().sendEntityStatus(this, (byte) 7); // hearts
            }

            return ActionResult.SUCCESS;
        }

        return super.interactMob(player, hand);
    }
}
