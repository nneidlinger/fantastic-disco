package com.example.examplemod.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

// HAS NOT YET BEEN ADDED TO ITEM REGISTRY...etc
public class LoudItem extends Item
{
    public LoudItem(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext)
    {
        if (!pContext.getLevel().isClientSide())
        {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();

            BlockState state = pContext.getLevel().getBlockState(positionClicked);

            outputBlockCoordinates(positionClicked, player, state.getBlock());
        }
        return InteractionResult.SUCCESS;
    }

    private void outputBlockCoordinates(BlockPos pos, Player player, Block block)
    {
        player.sendSystemMessage(Component.literal("Block: " + I18n.get(block.getDescriptionId()) + " at " +
                "(" + pos.getX() + ", " + pos.getY() + ", "+ pos.getZ() + ")"));
    }
}