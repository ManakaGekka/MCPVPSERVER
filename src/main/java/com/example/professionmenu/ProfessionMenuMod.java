package com.example.professionmenu;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.item.Items;
import net.minecraft.util.TypedActionResult;

public class ProfessionMenuMod implements ModInitializer {
    @Override
    public void onInitialize() {
        UseItemCallback.EVENT.register((player, world, hand) -> {
            if (player.getStackInHand(hand).getItem() == Items.CLOCK) {
                if (!world.isClient) {
                    ProfessionMenu.open(player);
                }
                return TypedActionResult.success(player.getStackInHand(hand));
            }
            return TypedActionResult.pass(player.getStackInHand(hand));
        });
    }
}