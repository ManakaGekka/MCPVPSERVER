package com.example.professionmenu;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ProfessionMenu extends HandledScreen<ProfessionMenuScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("professionmenu", "textures/gui/menu.png");

    public ProfessionMenu(ProfessionMenuScreenHandler handler, PlayerEntity player) {
        super(handler, player.getInventory(), Text.of("选择职业"));
    }

    public static void open(PlayerEntity player) {
        player.openHandledScreen(new SimpleScreenHandlerFactory(
            (syncId, inventory, playerEntity) -> new ProfessionMenuScreenHandler(syncId), 
            Text.of("职业菜单")
        ));
    }

    @Override
    protected void init() {
        super.init();
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        addDrawableChild(ButtonWidget.builder(Text.of("战士"), button -> {
            ProfessionManager.setProfession(client.player, "warrior");
            close();
        }).dimensions(x + 50, y + 40, 70, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.of("法师"), button -> {
            ProfessionManager.setProfession(client.player, "mage");
            close();
        }).dimensions(x + 50, y + 70, 70, 20).build());

        int column1X = x + 20;
        int column2X = x + 120;
        int startY = y + 30;
        int buttonHeight = 20;
        int verticalSpacing = 30;

        // 第一列
        addDrawableChild(ButtonWidget.builder(Text.translatable("professionmenu.profession.warrior"), button -> {
            ProfessionManager.setProfession(client.player, "warrior");
            close();
        }).dimensions(column1X, startY, 90, buttonHeight).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("professionmenu.profession.archer"), button -> {
            ProfessionManager.setProfession(client.player, "archer");
            close();
        }).dimensions(column1X, startY + verticalSpacing, 90, buttonHeight).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("professionmenu.profession.assassin"), button -> {
            ProfessionManager.setProfession(client.player, "assassin");
            close();
        }).dimensions(column1X, startY + verticalSpacing*2, 90, buttonHeight).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("professionmenu.profession.priest"), button -> {
            ProfessionManager.setProfession(client.player, "priest");
            close();
        }).dimensions(column1X, startY + verticalSpacing*3, 90, buttonHeight).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("professionmenu.profession.tank"), button -> {
            ProfessionManager.setProfession(client.player, "tank");
            close();
        }).dimensions(column1X, startY + verticalSpacing*4, 90, buttonHeight).build());

        // 第二列
        addDrawableChild(ButtonWidget.builder(Text.translatable("professionmenu.profession.mage"), button -> {
            ProfessionManager.setProfession(client.player, "mage");
            close();
        }).dimensions(column2X, startY, 90, buttonHeight).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("professionmenu.profession.hunter"), button -> {
            ProfessionManager.setProfession(client.player, "hunter");
            close();
        }).dimensions(column2X, startY + verticalSpacing, 90, buttonHeight).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("professionmenu.profession.elementalist"), button -> {
            ProfessionManager.setProfession(client.player, "elementalist");
            close();
        }).dimensions(column2X, startY + verticalSpacing*2, 90, buttonHeight).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("professionmenu.profession.blacksmith"), button -> {
            ProfessionManager.setProfession(client.player, "blacksmith");
            close();
        }).dimensions(column2X, startY + verticalSpacing*3, 90, buttonHeight).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("professionmenu.profession.summoner"), button -> {
            ProfessionManager.setProfession(client.player, "summoner");
            close();
        }).dimensions(column2X, startY + verticalSpacing*4, 90, buttonHeight).build());
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawCenteredText(matrices, textRenderer, title, width / 2, y + 10, 0xFFFFFF);
    }
}