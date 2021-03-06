package paulevs.betternether.mixin.common;

import java.util.List;
import java.util.Map;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnEntry;
import paulevs.betternether.IBiome;

@Mixin(Biome.class)
public class BiomeMixin implements IBiome
{
	@Shadow
	@Final
	private Map<SpawnGroup, List<Biome.SpawnEntry>> spawns;
	
	@Shadow
	protected void addSpawn(SpawnGroup type, SpawnEntry spawnEntry) {}
	
	@Override
	public void addEntitySpawn(EntityType<?> type, int weight, int minGroupSize, int maxGroupSize)
	{
		addSpawn(type.getSpawnGroup(), new SpawnEntry(type, weight, minGroupSize, maxGroupSize));
	}
}