package ml.pluto7073.space_climate.mixin;

import ml.pluto7073.space_climate.SpaceClimate;
import ml.pluto7073.space_climate.SpaceTags;
import net.environmentz.init.EffectInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import toughasnails.api.potion.TANEffects;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    @Shadow
    public abstract ItemStack getItemBySlot(EquipmentSlot slot);

    @Shadow
    public abstract boolean addEffect(MobEffectInstance effect);

    private LivingEntityMixin(EntityType<?> variant, Level world) {
        super(variant, world);
    }

    @Inject(at = @At("HEAD"), method = "tick")
    private void spaceClimate$AddClemencyEffect(CallbackInfo ci) {
        if (getItemBySlot(EquipmentSlot.HEAD).is(SpaceTags.INSULATING_ARMOR) && getItemBySlot(EquipmentSlot.CHEST).is(SpaceTags.INSULATING_ARMOR)
                && getItemBySlot(EquipmentSlot.LEGS).is(SpaceTags.INSULATING_ARMOR) && getItemBySlot(EquipmentSlot.FEET).is(SpaceTags.INSULATING_ARMOR)) {
            SpaceClimate.addEffect((LivingEntity) (Entity) this);
        }
    }

}
