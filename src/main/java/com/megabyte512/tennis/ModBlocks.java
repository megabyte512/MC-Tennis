package com.megabyte512.tennis;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.PaneBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
	public static Block TENNIS_NET;
	
	public static void initialize() {
		// Create identifier and registry key
		Identifier id = Identifier.of(TennisMod.MOD_ID, "tennis_net");
		RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);
		
		// Create settings with registry key
		AbstractBlock.Settings settings = AbstractBlock.Settings.create()
			.strength(1.0f)
			.sounds(BlockSoundGroup.WOOL)
			.nonOpaque()
			.registryKey(blockKey);
		
		// Register the block
		TENNIS_NET = Registry.register(Registries.BLOCK, blockKey, new PaneBlock(settings));
		
		// Register the block item
		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);
		Registry.register(Registries.ITEM, itemKey, 
			new BlockItem(TENNIS_NET, new Item.Settings().registryKey(itemKey)));
	}
}
