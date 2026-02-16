package com.megabyte512.tennis;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TennisMod implements ModInitializer {
	public static final String MOD_ID = "tennis";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Register everything
		ModItems.initialize();
		ModBlocks.initialize();
		
		// Add items to creative tabs
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
			content.add(ModItems.WOODEN_RACKET);
			content.add(ModItems.STONE_RACKET);
			content.add(ModItems.IRON_RACKET);
			content.add(ModItems.GOLDEN_RACKET);
			content.add(ModItems.DIAMOND_RACKET);
			content.add(ModItems.NETHERITE_RACKET);
			content.add(ModItems.TENNIS_BALL);
		});
		
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
			content.add(ModBlocks.TENNIS_NET);
		});
		
		LOGGER.info("Tennis mod initialized!");
	}
}
