package io.github.myueqf;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.*;
import net.minecraft.world.gen.noise.NoiseConfig;
import java.util.concurrent.CompletableFuture;

public class ChunkGenerator2D extends NoiseChunkGenerator {

    public static final MapCodec<ChunkGenerator2D> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(
                    BiomeSource.CODEC.fieldOf("biome_source").forGetter(ChunkGenerator2D::getBiomeSource),
                    ChunkGeneratorSettings.REGISTRY_CODEC.fieldOf("settings").forGetter(ChunkGenerator2D::getSettings))
            .apply(instance, instance.stable(ChunkGenerator2D::new)));

    private static final int maxChunkDistFromXAxis = 0;
    // private static final int structureChunkDistanceFlexibility = 2;

    public ChunkGenerator2D(BiomeSource biomeSource, RegistryEntry<ChunkGeneratorSettings> settings) {
        super(biomeSource, settings);
    }

    @Override
    protected MapCodec<? extends ChunkGenerator> getCodec() {
        return CODEC;
    }

    @Override
    public void buildSurface(ChunkRegion region, StructureAccessor structures, NoiseConfig noiseConfig, Chunk chunk) {
        if (Math.abs(chunk.getPos().z) <= maxChunkDistFromXAxis)
            super.buildSurface(region, structures, noiseConfig, chunk);
    }

    private static void fillChunkWithBARRIER(Chunk chunk) {
        final BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = chunk.getBottomY(); y < chunk.getHeight() ; y++) {
                    chunk.setBlockState(mutable.set(x, y, z), Blocks.BARRIER.getDefaultState(), false);
                }
            }
        }
    }

    @Override
    public void carve(ChunkRegion chunkRegion, long seed, NoiseConfig noiseConfig, BiomeAccess biomeAccess, StructureAccessor structureAccessor, Chunk chunk) {
        if (Math.abs(chunk.getPos().z) <= maxChunkDistFromXAxis)
            super.carve(chunkRegion, seed, noiseConfig, biomeAccess, structureAccessor, chunk);
    }

    @Override
    public CompletableFuture<Chunk> populateNoise(Blender blender, NoiseConfig noiseConfig, StructureAccessor structureAccessor, Chunk chunk) {
        if (Math.abs(chunk.getPos().z) <= maxChunkDistFromXAxis)
            return super.populateNoise(blender, noiseConfig, structureAccessor, chunk);
        return CompletableFuture.completedFuture(chunk);
    }

    @Override
    public void generateFeatures(StructureWorldAccess world, Chunk chunk, StructureAccessor structureAccessor) {
        if(Math.abs(chunk.getPos().z) <= maxChunkDistFromXAxis)
            super.generateFeatures(world, chunk, structureAccessor);
        else if (Math.abs(chunk.getPos().z) <= maxChunkDistFromXAxis + 1) {
            fillChunkWithBARRIER(chunk);
        }
    }
}