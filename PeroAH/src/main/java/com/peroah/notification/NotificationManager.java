package com.peroah.notification;

import com.peroah.util.Text;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class NotificationManager {
    public static void sendNotification(UUID playerId, String message) {
        Player player = Bukkit.getPlayer(playerId);
        if (player != null && player.isOnline()) {
            player.sendMessage(Text.color(message));
        }
    }

    public static void sendTitle(UUID playerId, String title, String subtitle) {
        Player player = Bukkit.getPlayer(playerId);
        if (player != null && player.isOnline()) {
            player.sendTitle(
                Text.color(title),
                Text.color(subtitle),
                10, 70, 20
            );
        }
    }

    public static void sendActionBar(UUID playerId, String message) {
        Player player = Bukkit.getPlayer(playerId);
        if (player != null && player.isOnline()) {
            player.spigot().sendMessage(
                net.md_5.bungee.api.ChatMessageType.ACTION_BAR,
                net.md_5.bungee.chat.ComponentBuilder(Text.color(message)).create()
            );
        }
    }
}
