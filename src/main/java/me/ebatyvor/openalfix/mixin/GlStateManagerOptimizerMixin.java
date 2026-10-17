package me.ebatyvor.openalfix.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "com.mojang.blaze3d.platform.GlStateManager", remap = false)
public class GlStateManagerOptimizerMixin {
    @Inject(method = "_glFinish()V", at = @At("HEAD"), cancellable = true, remap = false)
    private static void zalith$skipPipelineStallGlFinish(CallbackInfo ci) {
        ci.cancel();
    }
}
