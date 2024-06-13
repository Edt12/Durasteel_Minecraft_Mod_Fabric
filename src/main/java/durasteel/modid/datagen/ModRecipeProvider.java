package durasteel.modid.datagen;

import durasteel.modid.Blocks.ModBlocks;
import durasteel.modid.Item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.item.NetherStarItem;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    /**
     * Creating Crafting Recipes
     * @param exporter
     */
    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.DURASTEEL_SHEET,RecipeCategory.DECORATIONS,
                ModBlocks.DURASTEEL_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DURASTEEL_AXE,1)
                .pattern("DD ")
                .pattern("DS ")
                .pattern(" S ")
                .input('D',ModItems.DURASTEEL_SHEET)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.DURASTEEL_SHEET),conditionsFromItem(ModItems.DURASTEEL_SHEET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DURASTEEL_AXE)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DURASTEEL_HOE,1)
                .pattern("DD ")
                .pattern(" S ")
                .pattern(" S ")
                .input('D',ModItems.DURASTEEL_SHEET)
                .input('S',Items.STICK)
                .criterion(hasItem(ModItems.DURASTEEL_SHEET),conditionsFromItem(ModItems.DURASTEEL_SHEET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DURASTEEL_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DURASTEEL_PICKAXE,1)
                .pattern("DDD")
                .pattern(" S ")
                .pattern(" S ")
                .input('D',ModItems.DURASTEEL_SHEET)
                .input('S',Items.STICK)
                .criterion(hasItem(ModItems.DURASTEEL_SHEET),conditionsFromItem(ModItems.DURASTEEL_SHEET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DURASTEEL_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DURASTEEL_SHOVEL,1)
                .pattern(" D ")
                .pattern(" S ")
                .pattern(" S ")
                .input('D',ModItems.DURASTEEL_SHEET)
                .input('S',Items.STICK)
                .criterion(hasItem(ModItems.DURASTEEL_SHEET),conditionsFromItem(ModItems.DURASTEEL_SHEET))
                .offerTo(exporter,new Identifier(getRecipeName(ModItems.DURASTEEL_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DURASTEEL_SWORD,1)
                .pattern(" D ")
                .pattern(" D ")
                .pattern(" S ")
                .input('D',ModItems.DURASTEEL_SHEET)
                .input('S',Items.STICK)
                .criterion(hasItem(ModItems.DURASTEEL_SHEET),conditionsFromItem(ModItems.DURASTEEL_SHEET))
                .offerTo(exporter,new Identifier(getRecipeName(ModItems.DURASTEEL_SWORD)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.C4_BLOCK,1)
                .pattern("DDD")
                .pattern("DND")
                .pattern("DDD")
                .input('D',Items.DIAMOND)
                .input('N',Items.NETHER_STAR)
                .criterion(hasItem(Items.NETHER_STAR),conditionsFromItem(Items.NETHER_STAR))
                .offerTo(exporter,new Identifier(getRecipeName(ModBlocks.C4_BLOCK)));
    }
}
