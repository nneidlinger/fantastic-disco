package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
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
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB =
            CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.EXAMPLE_ITEM.get()))
                    .title(Component.translatable("creativetab.example_tab"))
                    .displayItems((Parameters, pOutput) -> {
                        pOutput.accept(ModItems.EXAMPLE_ITEM.get());
                        pOutput.accept(ModItems.EXAMPLE_ITEM_TWO.get());
                    })
                    .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
