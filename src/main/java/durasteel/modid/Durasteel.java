package durasteel.modid;

import durasteel.modid.Blocks.ModBlocks;
import durasteel.modid.Item.ModItemGroup;
import durasteel.modid.Item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Durasteel implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "durasteel";
    public static final Logger DURASTEEL = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItems.registerModItemGroups();
		ModItemGroup.registerItemGroups();//Item group must call this method otherwise doesn't load
		ModBlocks.registerModBlocks();
		CustomPortalBuilder.beginPortal()
				.frameBlock(Blocks.DIAMOND_BLOCK)
				.lightWithItem(Items.FLINT_AND_STEEL)
				.destDimID(new Identifier(Durasteel.MOD_ID,"carl"))
				.tintColor(0,0,255)
				.registerPortal();



	}
}