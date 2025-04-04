package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.ModBlocks;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB =
            CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.EXAMPLE_ITEM.get()))
                    .title(Component.translatable("creativetab.example_tab"))
                    .displayItems((Parameters, pOutput) -> {
                        // add items to the tab
                        pOutput.accept(ModItems.EXAMPLE_ITEM.get());
                        pOutput.accept(ModItems.EXAMPLE_ITEM_TWO.get());

                        // add block(item)s to the tab
                        pOutput.accept(ModBlocks.EXAMPLE_BLOCK.get());
                        pOutput.accept(ModBlocks.EXAMPLE_BLOCK_TWO.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> EXAMPLE_MOD_ORES =
            CREATIVE_MODE_TABS.register("example_mod_ores_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.EXAMPLE_ITEM.get()))
                    .title(Component.translatable("creativetab.example_mod_ores_tab"))
                    .displayItems((Parameters, pOutput) -> {
                        pOutput.accept(ModBlocks.EXAMPLE_BLOCK_ORE.get());
                        pOutput.accept(ModBlocks.EXAMPLE_BLOCK_DEEPSLATE_ORE.get());
                        pOutput.accept(ModBlocks.EXAMPLE_BLOCK_NETHER_ORE.get());
                        pOutput.accept(ModBlocks.EXAMPLE_BLOCK_END_ORE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
