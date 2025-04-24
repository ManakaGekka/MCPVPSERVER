package com.example.professionmenu;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class ProfessionManager {
    private static final String PROFESSION_KEY = "ProfessionMenu_Profession";

    public static void setProfession(PlayerEntity player, String profession) {
        NbtCompound nbt = player.getMainHandStack().getOrCreateNbt();
        nbt.putString(PROFESSION_KEY, profession);
        applyProfessionEffects((ServerPlayerEntity) player, profession);
        player.sendMessage(Text.translatable("msg.professionmenu.set", profession));
    }

    public static String getProfession(PlayerEntity player) {
        return player.getMainHandStack().getOrCreateNbt().getString(PROFESSION_KEY);
    }

    private static void applyProfessionEffects(ServerPlayerEntity player, String profession) {
        switch (profession) {
            case "warrior":
                player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(10.0);
                break;
            case "mage":
                player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(30.0);
                break;
            // 新增职业效果
            case "archer":
                player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(15.0);
                break;
            case "assassin":
                player.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.2);
                break;
            case "priest":
                player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(5.0);
                break;
            case "hunter":
                player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_KNOCKBACK).setBaseValue(0.25);
                break;
            case "tank":
                player.getAttributeInstance(EntityAttributes.GENERIC_ARMOR).setBaseValue(8.0);
                break;
            case "elementalist":
                player.getAttributeInstance(EntityAttributes.GENERIC_ARMOR_TOUGHNESS).setBaseValue(0.3);
                break;
            case "ranger":
                player.getAttributeInstance(EntityAttributes.GENERIC_JUMP_STRENGTH).setBaseValue(2.0);
                break;
            case "blacksmith":
                player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED).setBaseValue(0.5);
                break;
            case "summoner":
                player.getAttributeInstance(EntityAttributes.GENERIC_MAX_ABSORPTION).setBaseValue(50.0);
                break;
        }
    }
}