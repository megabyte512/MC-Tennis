package com.megabyte512.tennis;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
	// Declare items
	public static Item WOODEN_RACKET;
	public static Item STONE_RACKET;
	public static Item IRON_RACKET;
	public static Item GOLDEN_RACKET;
	public static Item DIAMOND_RACKET;
	public static Item NETHERITE_RACKET;
	public static Item TENNIS_BALL;
	
	public static void initialize() {
		// Register all rackets
		WOODEN_RACKET = registerTool("wooden_racket", 59);
		STONE_RACKET = registerTool("stone_racket", 132);
		IRON_RACKET = registerTool("iron_racket", 251);
		GOLDEN_RACKET = registerTool("golden_racket", 32);
		DIAMOND_RACKET = registerTool("diamond_racket", 1562);
		NETHERITE_RACKET = registerTool("netherite_racket", 2031);
		
		// Register tennis ball
		Identifier ballId = Identifier.of(TennisMod.MOD_ID, "tennis_ball");
		RegistryKey<Item> ballKey = RegistryKey.of(RegistryKeys.ITEM, ballId);
		TENNIS_BALL = Registry.register(Registries.ITEM, ballKey, new Item(new Item.Settings().maxCount(1).registryKey(ballKey)));
	}
	
	// Helper method
	private static Item registerTool(String name, int maxDamage) {
		Identifier id = Identifier.of(TennisMod.MOD_ID, name);
		RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
		Item.Settings settings = new Item.Settings().maxCount(1).maxDamage(maxDamage).registryKey(key);
		return Registry.register(Registries.ITEM, key, new Item(settings));
	}
}
