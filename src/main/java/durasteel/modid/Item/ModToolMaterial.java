package durasteel.modid.Item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.block.BlockState;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    DURASTEEL(1000,10,10,MiningLevels.STONE,150,
    ()-> Ingredient.ofItems(ModItems.DURASTEEL_SHEET));
    private final int durability;
    private final float miningSpeedMultiplier;
    private final float attackDamage;
    private final int miningLevel;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngrediant;

    ModToolMaterial(int durability, float miningSpeedMultiplier, float attackDamage, int miningLevel, int enchantability, Supplier<Ingredient> repairIngrediant) {
        this.durability = durability;
        this.miningSpeedMultiplier = miningSpeedMultiplier;
        this.attackDamage = attackDamage;
        this.miningLevel = miningLevel;
        this.enchantability = enchantability;
        this.repairIngrediant = repairIngrediant;
    }

    /**
     * {@return the total amount of durability a {@link ToolItem } using this {@link ToolMaterial} has}
     * <p>
     * The value returned here will set the {@link Item.Settings} max durability option when passed
     * into {@link ToolItem#ToolItem(ToolMaterial, Item.Settings)}
     * if the value was not already specified.
     */
    @Override
    public int getDurability() {
        return durability;
    }

    /**
     * {@return the mining speed bonus applied when a {@link ToolItem} using this material is breaking an appropriate block}
     * {@code 1.0f} will result in no speed change.
     * <p>
     * <b>Note:</b> for default vanilla tool classes, this bonus is only applied in {@link MiningToolItem#getMiningSpeedMultiplier(ItemStack, BlockState)}.
     */
    @Override
    public float getMiningSpeedMultiplier() {
        return miningSpeedMultiplier;
    }

    /**
     * {@return the attack damage bonus applied to any {@link ToolItem} using this {@link ToolMaterial}}
     * <p>
     * In the case of {@link MiningToolItem} or {@link SwordItem}, the value returned
     * here will be added on top of the {@code attackDamage} value passed into the tool's constructor.
     */
    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    /**
     * {@return the mining level of a {@link ToolItem} using this {@link ToolMaterial}}
     * To prevent this tool from successfully harvesting any mining level gated blocks, return {@link MiningLevels#HAND}.
     * <p>
     * For more information on mining levels, visit {@link MiningLevels}.
     */
    @Override
    public int getMiningLevel() {
        return miningLevel;
    }

    /**
     * {@return the enchantment value sent back to {@link Item#getEnchantability()} for tools using this material}
     * <p>
     * By default, {@link ToolMaterial} will override {@link Item#getEnchantability()}
     * and delegate the call back to this method.
     * <p>
     * A higher return value will result in better enchantment results when using an {@code Enchanting Table}.
     * The highest enchantability value in vanilla is Netherite, at {@code 37}.
     */
    @Override
    public int getEnchantability() {
        return enchantability;
    }

    /**
     * {@return the {@link Ingredient } used to repair items using this {@link ToolMaterial}}
     * <p>
     * By default, {@link ToolMaterial} will delegate {@link Item#canRepair(ItemStack, ItemStack)}
     * back to this method.
     */
    @Override
    public Ingredient getRepairIngredient() {
        return repairIngrediant.get();
    }
}
