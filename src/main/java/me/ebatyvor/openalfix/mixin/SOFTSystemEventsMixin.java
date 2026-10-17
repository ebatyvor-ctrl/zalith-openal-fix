package me.ebatyvor.openalfix.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "org.lwjgl.openal.SOFTSystemEvents", remap = false)
public class SOFTSystemEventsMixin {
    @Inject(method = "alcEventIsSupportedSOFT(I)Z", at = @At("HEAD"), cancellable = true, remap = false)
    private static void zalith$safeAlcEvent1(int eventType, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }

    @Inject(method = "alcEventIsSupportedSOFT(II)Z", at = @At("HEAD"), cancellable = true, remap = false)
    private static void zalith$safeAlcEvent2(int eventType, int deviceType, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
