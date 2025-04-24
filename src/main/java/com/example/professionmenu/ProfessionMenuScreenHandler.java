package com.example.professionmenu;

import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class ProfessionMenuScreenHandler extends ScreenHandler {
    public ProfessionMenuScreenHandler(int syncId) {
        super(ScreenHandlerType.GENERIC_9X3, syncId);
    }

    @Override
    public boolean canUse(net.minecraft.entity.player.PlayerEntity player) {
        return true;
    }
}