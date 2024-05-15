package djlaser.bulkstorageapi.datagen;

import djlaser.bulkstorageapi.register.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.VariantsBlockStateSupplier;
import net.minecraft.util.Identifier;

class ModelsDatagen extends FabricModelProvider {
    BlockStateModelGenerator blockStateModelGenerator;
    ItemModelGenerator itemModelGenerator;

    public ModelsDatagen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        this.blockStateModelGenerator = blockStateModelGenerator;
        registerDrawer(ModBlocks.EXAMPLE_DRAWER, drawerFace(ModBlocks.EXAMPLE_DRAWER));
    }

    public TextureMap drawerFace(Block drawer) {
        return TextureMap.all(TextureMap.getSubId(drawer, "_side")).put(TextureKey.FRONT, TextureMap.getSubId(drawer, "_face"));
    }

    private void registerDrawer(Block block, TextureMap texture) {
        Identifier identifier = Models.ORIENTABLE.upload(block, texture, this.blockStateModelGenerator.modelCollector);
        this.blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        this.itemModelGenerator = itemModelGenerator;
    }
}
