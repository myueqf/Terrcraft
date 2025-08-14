package io.github.myueqf.mixin;

import net.minecraft.world.border.WorldBorder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldBorder.class)
public class XwX {
    @Inject(method = "getBoundNorth", at = @At("RETURN"), cancellable = true)
    private void getBoundNorth(CallbackInfoReturnable<Double> cir) {
        cir.setReturnValue(0.0);
    }

    @Inject(method = "getBoundSouth", at = @At("RETURN"), cancellable = true)
    private void getBoundSouth(CallbackInfoReturnable<Double> cir) {
        cir.setReturnValue(16.0);
    }
}
