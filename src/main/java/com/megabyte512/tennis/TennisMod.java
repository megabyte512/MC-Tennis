package com.megabyte512.tennis;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TennisMod implements ModInitializer {
	public static final String MOD_ID = "tennis";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	
	public static Item DIAMOND_RACKET;

	@Override
	public void onInitialize() {
		// Create identifier and registry key
		Identifier id = Identifier.of(MOD_ID, "diamond_racket");
		RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
		
		// Create item with registry key in settings
		Item.Settings settings = new Item.Settings().maxCount(1).registryKey(key);
		
		// Register the item
		DIAMOND_RACKET = Registry.register(Registries.ITEM, key, new Item(settings));
		
		// Add to creative tab
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
			content.add(DIAMOND_RACKET);
		});
		
		LOGGER.info("Tennis mod initialized!");
	}
}
