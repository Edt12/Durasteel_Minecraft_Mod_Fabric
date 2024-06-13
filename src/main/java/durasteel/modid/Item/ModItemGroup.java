package durasteel.modid.Item;
import durasteel.modid.Blocks.ModBlocks;
import durasteel.modid.Durasteel;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup DURASTEEL_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Durasteel.MOD_ID,"ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.durasteel"))
                    .icon(() -> new ItemStack(ModItems.DURASTEEL_SHEET)).entries((displayContext, entries) -> {
                        entries.add(ModItems.DURASTEEL_SHEET);
                        entries.add(Items.DIAMOND);
                        entries.add(ModBlocks.DURASTEEL_BLOCK);
                        entries.add(ModItems.DURASTEEL_AXE);
                        entries.add(ModItems.DURASTEEL_HOE);
                        entries.add(ModItems.DURASTEEL_SWORD);
                        entries.add(ModItems.DURASTEEL_PICKAXE);
                        entries.add(ModItems.DURASTEEL_SHOVEL);
                        entries.add(ModBlocks.C4_BLOCK);


                    }).build());
    public static void registerItemGroups() {
        Durasteel.DURASTEEL.info("Registering Item Groups for " + Durasteel.MOD_ID);

    }
}
