package io.github.myueqf.mixin;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class QAQ {
    @Inject(method = "loadWorld", at = @At("RETURN"))
    private void onWorldLoad(CallbackInfo ci) {
        MinecraftServer server = (MinecraftServer)(Object)this;
        ServerWorld world = server.getOverworld();
        world.setSpawnPos(new BlockPos(8, 64, 8), 0);
        world.getGameRules().get(GameRules.SPAWN_RADIUS).set(0, server);
    }
}

