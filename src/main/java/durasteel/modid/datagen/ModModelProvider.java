package durasteel.modid.datagen;

import durasteel.modid.Blocks.ModBlocks;
import durasteel.modid.Item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;


public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DURASTEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.C4_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.DURASTEEL_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DURASTEEL_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DURASTEEL_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DURASTEEL_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.DURASTEEL_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.DURASTEEL_SHEET, Models.GENERATED);
    }
}
