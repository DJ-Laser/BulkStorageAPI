package djlaser.bulkstorageapi.register;

import djlaser.bulkstorageapi.BulkStorageMod;
import djlaser.bulkstorageapi.drawer.DrawerBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block EXAMPLE_DRAWER = registerBlock("drawer", new DrawerBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD)));
    public static final Item EXAMPLE_DRAWER_ITEM = registerBlockItem("drawer", EXAMPLE_DRAWER);

    private static Block registerBlock(String blockID, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(BulkStorageMod.MOD_ID, blockID), block);
    }
    private static Item registerBlockItem(String itemID, Block block, FabricItemSettings settings) {
        return Registry.register(Registries.ITEM, new Identifier(BulkStorageMod.MOD_ID, itemID), new BlockItem(block, settings));
    }
    private static Item registerBlockItem(String itemID, Block block) {
        return registerBlockItem(itemID, block, new FabricItemSettings());
    }
    public static void register() {
        BulkStorageMod.LOGGER.info("Registering blocks for {}", BulkStorageMod.MOD_ID);
    }
}
