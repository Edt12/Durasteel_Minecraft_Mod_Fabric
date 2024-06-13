package durasteel.modid.Blocks;

import durasteel.modid.Durasteel;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TntBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block DURASTEEL_BLOCK = registerBlock("durasteel",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(400).resistance(40)));
    public static final Block C4_BLOCK = registerBlock("c4",
            new C4Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK , new Identifier(Durasteel.MOD_ID,name),block);
    }
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(Durasteel.MOD_ID, name),
            new BlockItem(block,new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        int x = 0;

    }

}
