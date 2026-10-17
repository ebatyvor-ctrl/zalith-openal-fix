package me.ebatyvor.openalfix.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "com.mojang.blaze3d.systems.RenderSystem", remap = false)
public class RenderSystemOptimizerMixin {
    @Inject(method = "finish()V", at = @At("HEAD"), cancellable = true, remap = false)
    private static void zalith$skipRenderSystemFinish(CallbackInfo ci) {
        ci.cancel();
    }
}
