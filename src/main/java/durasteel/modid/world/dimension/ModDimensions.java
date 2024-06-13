package durasteel.modid.world.dimension;

import durasteel.modid.Durasteel;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> CARL_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(Durasteel.MOD_ID, "carl"));

    public static final RegistryKey<World> CARL_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(Durasteel.MOD_ID, "carl"));

    public static final RegistryKey<net.minecraft.world.dimension.DimensionType> CARL_DIMENSION_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(Durasteel.MOD_ID, "carl_type"));


    public static void addType(Registerable<net.minecraft.world.dimension.DimensionType> type){
        type.register(CARL_DIMENSION_TYPE, new DimensionType(
                OptionalLong.of(120000),
                true,//hasSkylight
                false,//hasCeiling
                false, //ultrawarm
                true,//natural
                1.0,//coordinateScale
                true,//Bedworks
                false,//RespawnAnchorWorks
                -256,//minY
                256,//height
                256,//logicalHeight
                BlockTags.INFINIBURN_OVERWORLD,//Infiniburn
                DimensionTypes.OVERWORLD_ID,//effects Location
                1.0f,//ambientLight
                new DimensionType.MonsterSettings(false,false, UniformIntProvider.create(0,0),0)));


    }


}

