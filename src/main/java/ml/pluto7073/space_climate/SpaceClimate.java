package ml.pluto7073.space_climate;

import net.environmentz.init.EffectInit;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import toughasnails.api.potion.TANEffects;

import java.util.function.Supplier;

public class SpaceClimate implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("Space Climate");
	public static final String MOD_ID = "space_climate";

	@Override
	public void onInitialize() {
		LOGGER.info("Space Climate Initialized!");
	}

	public static ResourceLocation id(String id) {
		return new ResourceLocation(MOD_ID, id);
	}

	public static void addEffect(LivingEntity e) {
		if (FabricLoader.getInstance().isModLoaded("toughasnails")) {
			e.addEffect(new MobEffectInstance(TANEffects.CLIMATE_CLEMENCY, 2, 0, true, false, true));
		} else if (FabricLoader.getInstance().isModLoaded("environmentz")) {
			e.addEffect(new MobEffectInstance(EffectInit.COMFORT, 2, 0, true, false, true));
		}
	}

}