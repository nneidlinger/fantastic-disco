package com.example.examplemod.block;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{
    // create register
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MOD_ID);

    // add blocks
    public static final RegistryObject<Block> EXAMPLE_BLOCK =
            registerBlock("example_block",
                    () -> new Block(BlockBehaviour.Properties
                            .copy(Blocks.IRON_BLOCK)
                            .sound(SoundType.BONE_BLOCK)
                    ));

    public static final RegistryObject<Block> EXAMPLE_BLOCK_TWO =
            registerBlock("example_block_two",
                    () -> new Block(BlockBehaviour.Properties
                            .copy(Blocks.AMETHYST_BLOCK)
                            .sound(SoundType.AMETHYST)
                    ));

    public static final RegistryObject<Block> EXAMPLE_BLOCK_ORE =
            registerBlock("example_block_ore",
                    () -> new DropExperienceBlock(BlockBehaviour.Properties
                            .copy(Blocks.STONE)
                            .sound(SoundType.STONE)
                            .requiresCorrectToolForDrops()
                            ,UniformInt.of(3,5) // amt exp dropped
                    ));

    public static final RegistryObject<Block> EXAMPLE_BLOCK_DEEPSLATE_ORE =
            registerBlock("example_block_deepslate_ore",
                    () -> new DropExperienceBlock(BlockBehaviour.Properties
                            .copy(Blocks.DEEPSLATE)
                            .requiresCorrectToolForDrops()
                            ,UniformInt.of(3,5) // amt exp dropped
                    ));

    public static final RegistryObject<Block> EXAMPLE_BLOCK_NETHER_ORE =
            registerBlock("example_block_nether_ore",
                    () -> new DropExperienceBlock(BlockBehaviour.Properties
                            .copy(Blocks.NETHERRACK)
                            .requiresCorrectToolForDrops()
                            ,UniformInt.of(3,5) // amt exp dropped
                    ));

    public static final RegistryObject<Block> EXAMPLE_BLOCK_END_ORE =
            registerBlock("example_block_end_ore",
                    () -> new DropExperienceBlock(BlockBehaviour.Properties
                            .copy(Blocks.END_STONE)
                            .requiresCorrectToolForDrops()
                            ,UniformInt.of(3,5) // amt exp dropped
                    ));

    // =========================== BEGIN Helper Functions ===========================
    // creates a registry item for block and makes call to create an inventory
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> result = BLOCKS.register(name, block);
        registerBlockItem(name, result);
        return result;
    }

    // creates an inventory item for block
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    // ============================ END Helper Functions ============================

    // actually register blocks
    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
