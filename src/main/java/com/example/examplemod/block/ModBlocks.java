package com.example.examplemod.block;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

/**
 * The class used to create new blocks, in a simplified manner
 * @author Bobbyman5507
 */
public class ModBlocks
{

    //Block registry
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MODID);

    //Item Registry
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    //create blocks here
    public static final RegistryObject<Block> AHHHH = registerBlock("ahhhhh",
            new Block(BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("ahhhhh"))
                    .mapColor(MapColor.STONE)
            )
    );



    // Creates a new Block with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("example_block"))
                    .mapColor(MapColor.STONE)
            )
    );

    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block",
            () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties().setId(ITEMS.key("example_block")))
    );


    //initialization
    public static void registerModBlocks()
    {
        ExampleMod.LOGGER.info("Registering ModBlocks for "+ExampleMod.MODID);

    }



    /**
     * The method to simplify the registering of blocks
     * @param name String name of the block
     * @param block The block's properties
     * @return The field to register the block to the Forge Registry
     */
    private static RegistryObject<Block> registerBlock(String name, Block block)
    {
        // setting the name automatically
        block.properties().setId(BLOCKS.key(name));

        //registers as an item
        registerBlockItem(name, block);

        //returns block properties
        return BLOCKS.register(name, () -> block);
    }


    private static RegistryObject<Item> registerBlockItem(String name, Block block)
    {



        return ITEMS.register(name,
                () -> new BlockItem(block, new Item.Properties().setId(ITEMS.key(name)))
        );
    }




}
