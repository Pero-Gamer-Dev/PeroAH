package com.peroah.mail;

import org.bukkit.entity.Player;

public class MailManager {
    public void send(Player player, String message) {
        if (player != null) {
            player.sendMessage(message);
        }
    }
}
