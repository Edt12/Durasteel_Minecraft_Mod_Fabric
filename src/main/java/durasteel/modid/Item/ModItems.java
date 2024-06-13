package durasteel.modid.Item;

import durasteel.modid.Durasteel;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item DURASTEEL_SHEET = registerItem("durasteel_sheet",new Item(new FabricItemSettings()));//Items must be lowercase no spaces
    //Block Item as it is a block with an item e.g is the item that places the block
    public static final Item DURASTEEL_PICKAXE = registerItem("durasteel_pickaxe",
            new PickaxeItem(ModToolMaterial.DURASTEEL,3,2,new FabricItemSettings()));
    public static final Item DURASTEEL_SWORD = registerItem("durasteel_sword",
            new SwordItem(ModToolMaterial.DURASTEEL,10,4,new FabricItemSettings()));
    public static final Item DURASTEEL_AXE = registerItem("durasteel_axe",
            new AxeItem(ModToolMaterial.DURASTEEL,15,2,new FabricItemSettings()));
    public static final Item DURASTEEL_SHOVEL = registerItem("durasteel_shovel",
            new ShovelItem(ModToolMaterial.DURASTEEL,3,2,new FabricItemSettings()));
    public static final Item DURASTEEL_HOE = registerItem("durasteel_hoe",
            new HoeItem(ModToolMaterial.DURASTEEL,3,2,new FabricItemSettings()));
    private static void addItemsToIngrediantTabAsGroup(FabricItemGroupEntries entries){
        entries.add(DURASTEEL_SHEET);
    }
    /**
     * Registers Item with Minecraft given it a unique identifier
     * @param name Name of Item
     * @param item Item trying to register
     * @return Registry entry
     */
    private static Item registerItem(String name , Item item){
        return Registry.register(Registries.ITEM,new Identifier(Durasteel.MOD_ID, name),item);
    }

    public static void registerModItemGroups(){
        Durasteel.DURASTEEL.info("Registers items for " + Durasteel.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngrediantTabAsGroup);

    }

}
