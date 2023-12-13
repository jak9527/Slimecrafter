package com.slimecrafter.world;

import com.slimecrafter.Main;
import com.slimecrafter.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> SLIMIUM_ORE_KEY = registerKey("slimium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEEPSLATE_SLIMIUM_ORE_KEY = registerKey("deepslate_slimium_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        RuleTest stoneReplaceable = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deeplslateReplaceable = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldSlimiumOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceable, ModBlocks.SLIMIUM_ORE_BLOCK.getDefaultState()),
                        OreFeatureConfig.createTarget(deeplslateReplaceable, ModBlocks.DEEPSLATE_SLIMIUM_ORE_BLOCK.getDefaultState())
                );

        register(context, SLIMIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldSlimiumOres, 6));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
