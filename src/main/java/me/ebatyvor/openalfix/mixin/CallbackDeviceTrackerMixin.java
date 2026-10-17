package me.ebatyvor.openalfix.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "com.mojang.blaze3d.audio.CallbackDeviceTracker", remap = false)
public class CallbackDeviceTrackerMixin {
    @Inject(method = "isSupported", at = @At("HEAD"), cancellable = true, remap = false)
    private void zalith$disableSystemEvents(long device, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
