package com.stevenrummler.cosmere_collection;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CosmereCollection implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("cosmere_collection");

	public static final ItemGroup COSMERE = FabricItemGroupBuilder.build(
			new Identifier("cosmere_collection", "cosmere"),
			() -> new ItemStack(Items.ENDER_EYE));

	// Swords
	public static final Item NIGHTBLOOD = new NightBlood(
			ToolMaterials.NETHERITE,100,2,
			new FabricItemSettings().group(COSMERE));
	public static final Item ISHAR = new NightBlood(
			ToolMaterials.NETHERITE,100,2,
			new FabricItemSettings().group(COSMERE));
	public static final Item JEZRIEN = new NightBlood(
			ToolMaterials.NETHERITE,100,2,
			new FabricItemSettings().group(COSMERE));
	public static final Item NALE = new NightBlood(
			ToolMaterials.NETHERITE,100,2,
			new FabricItemSettings().group(COSMERE));
	public static final Item CHANA = new NightBlood(
			ToolMaterials.NETHERITE,100,2,
			new FabricItemSettings().group(COSMERE));
	public static final Item VEDEL = new NightBlood(
			ToolMaterials.NETHERITE,100,2,
			new FabricItemSettings().group(COSMERE));
	public static final Item PAILIAH = new NightBlood(
			ToolMaterials.NETHERITE,100,2,
			new FabricItemSettings().group(COSMERE));
	public static final Item SHALASH = new NightBlood(
			ToolMaterials.NETHERITE,100,2,
			new FabricItemSettings().group(COSMERE));
	public static final Item BATTAR = new NightBlood(
			ToolMaterials.NETHERITE,100,2,
			new FabricItemSettings().group(COSMERE));
	public static final Item KALAK = new NightBlood(
			ToolMaterials.NETHERITE,100,2,
			new FabricItemSettings().group(COSMERE));
	public static final Item TALANAEL = new NightBlood(
			ToolMaterials.NETHERITE,100,2,
			new FabricItemSettings().group(COSMERE));

	// Soulstone
	public static final Block SOULSTONE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.0f));
	public static final Block HARDENED_SOULSTONE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.0f));
	private static final ConfiguredFeature<?, ?> OVERWORLD_SOULSTONE_CONFIGURED_FEATURE = Feature.ORE
			.configure(new OreFeatureConfig(
					OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
					SOULSTONE.getDefaultState(),
					9)); // vein size
	public static PlacedFeature OVERWORLD_SOULSTONE_PLACED_FEATURE = OVERWORLD_SOULSTONE_CONFIGURED_FEATURE.withPlacement(
			CountPlacementModifier.of(20), // number of veins per chunk
			SquarePlacementModifier.of(), // spreading horizontally
			HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))); // height

	// Stamps
	public static final Item EXPLORER_STAMP = new Stamp(new FabricItemSettings().group(COSMERE));
	public static final Item EXPLORER_STAMP_INKED = new Stamp(new FabricItemSettings().group(COSMERE));
	public static final Item EXPLORER_STAMP_SOFT = new Stamp(new FabricItemSettings().group(COSMERE));
	public static final Item FIGHTER_STAMP = new Stamp(new FabricItemSettings().group(COSMERE));
	public static final Item FIGHTER_STAMP_INKED = new Stamp(new FabricItemSettings().group(COSMERE));
	public static final Item FIGHTER_STAMP_SOFT = new Stamp(new FabricItemSettings().group(COSMERE));
	public static final Item MINER_STAMP = new Stamp(new FabricItemSettings().group(COSMERE));
	public static final Item MINER_STAMP_INKED = new Stamp(new FabricItemSettings().group(COSMERE));
	public static final Item MINER_STAMP_SOFT = new Stamp(new FabricItemSettings().group(COSMERE));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		// Swords
		Registry.register(Registry.ITEM, new Identifier("cosmere_collection", "nightblood"), NIGHTBLOOD);
		Registry.register(Registry.ITEM, new Identifier("cosmere_collection", "ishar"), ISHAR);
		Registry.register(Registry.ITEM, new Identifier("cosmere_collection", "jezrien"), JEZRIEN);
		Registry.register(Registry.ITEM, new Identifier("cosmere_collection", "nale"), NALE);
		Registry.register(Registry.ITEM, new Identifier("cosmere_collection", "chana"), CHANA);
		Registry.register(Registry.ITEM, new Identifier("cosmere_collection", "vedel"), VEDEL);
		Registry.register(Registry.ITEM, new Identifier("cosmere_collection", "pailiah"), PAILIAH);
		Registry.register(Registry.ITEM, new Identifier("cosmere_collection", "shalash"), SHALASH);
		Registry.register(Registry.ITEM, new Identifier("cosmere_collection", "battar"), BATTAR);
		Registry.register(Registry.ITEM, new Identifier("cosmere_collection", "kalak"), KALAK);
		Registry.register(Registry.ITEM, new Identifier("cosmere_collection", "talanael"), TALANAEL);

		// Soulstone Blocks, Items, and Generation
		Registry.register(Registry.BLOCK, new Identifier("cosmere_collection", "soulstone"), SOULSTONE);
		Registry.register(Registry.BLOCK, new Identifier("cosmere_collection", "hardened_soulstone"), HARDENED_SOULSTONE);

		Registry.register(Registry.ITEM, new Identifier("cosmere_collection", "soulstone"), new BlockItem(SOULSTONE, new FabricItemSettings().group(COSMERE)));
		Registry.register(Registry.ITEM, new Identifier("cosmere_collection", "hardened_soulstone"), new BlockItem(HARDENED_SOULSTONE, new FabricItemSettings().group(COSMERE)));

		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("cosmere_collection", "overworld_soulstone"), OVERWORLD_SOULSTONE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("cosmere_collection", "overworld_soulstone"),
				OVERWORLD_SOULSTONE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("cosmere_collection", "overworld_soulstone")));

		// Stamps
		Registry.register(Registry.ITEM, new Identifier("tutorial", "explorer_stamp"), EXPLORER_STAMP);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "explorer_stamp_inked"), EXPLORER_STAMP_INKED);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "explorer_stamp_soft"), EXPLORER_STAMP_SOFT);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "fighter_stamp"), FIGHTER_STAMP);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "fighter_stamp_inked"), FIGHTER_STAMP_INKED);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "fighter_stamp_soft"), FIGHTER_STAMP_SOFT);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "miner_stamp"), MINER_STAMP);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "miner_stamp_inked"), MINER_STAMP_INKED);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "miner_stamp_soft"), MINER_STAMP_SOFT);
	}


}
