package com.megabyte512.tennis;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TennisMod implements ModInitializer {
	public static final String MOD_ID = "tennis";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Item DIAMOND_RACKET = new Item(new Item.Settings().maxCount(1));

	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "diamond_racket"), DIAMOND_RACKET);
		
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
			content.add(DIAMOND_RACKET);
		});
		
		LOGGER.info("Tennis mod initialized");
	}
}
