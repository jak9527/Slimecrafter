package com.slimecrafter.item;

import com.slimecrafter.Main;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    SLIMIUM("slimium", 25, new int[] {2, 5, 4, 2}, 19,
            SoundEvents.ENTITY_SLIME_SQUISH, 0f, 0.3f,
            () -> Ingredient.ofItems(ModItems.SLIMIUM_INGOT)),
    REINFORCED_SLIMIUM("reinforced_slimium", 30, new int[] {3, 6, 6, 3}, 24,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 1f, 0.8f,
            () -> Ingredient.ofItems(ModItems.REINFORCED_SLIMIUM_INGOT));
    ;

    private final String name;
    private final int durabilityMult;
    private final int[] protAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResist;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURA = {11, 16, 15, 13};

    ModArmorMaterials(String name, int durabilityMult, int[] protAmounts, int enchantability, SoundEvent equipSound,
                      float toughness, float knockbackResist, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMult = durabilityMult;
        this.protAmounts = protAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResist = knockbackResist;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURA[type.ordinal()] * this.durabilityMult;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return Main.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResist;
    }
}
