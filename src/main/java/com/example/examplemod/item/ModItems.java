package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    // create register
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);

    // create actual items
    public static final RegistryObject<Item> EXAMPLE_ITEM =
            ITEMS.register("example_item", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EXAMPLE_ITEM_TWO =
            ITEMS.register("example_item_two", () -> new Item(new Item.Properties()));

    // actually register items
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
