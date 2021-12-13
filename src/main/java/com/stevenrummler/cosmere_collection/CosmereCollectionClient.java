package com.stevenrummler.cosmere_collection;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.StickyKeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;

public class CosmereCollectionClient implements ClientModInitializer {
    private static KeyBinding keyBinding;

    @Override
    public void onInitializeClient() {
        KeyBinding honorblade_power_primary = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.cosmere_collection.honorblade_power_primary", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R, "key.category.cosmere_collection"));
        KeyBinding honorblade_power_secondary = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.cosmere_collection.honorblade_power_secondary", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_F, "key.category.cosmere_collection"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (honorblade_power_primary.wasPressed()) {
                client.player.sendMessage(new LiteralText("Primary" + client.player.getInventory().getMainHandStack().getItem().toString()), false);
            }

            while (honorblade_power_secondary.wasPressed()) {
                client.player.sendMessage(new LiteralText("Secondary" + client.player.getInventory().getMainHandStack().getItem().toString()), false);
            }
        });
    }
}
