package com.peroah.mail;

import com.peroah.PeroAH;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MailManager {
    private PeroAH plugin;
    private Map<UUID, MailItem> mailCache;

    public MailManager(PeroAH plugin) {
        this.plugin = plugin;
        this.mailCache = new HashMap<>();
    }

    public void sendMail(UUID recipientId, MailItem mail) {
        mailCache.put(mail.getId(), mail);
        
        Player player = Bukkit.getPlayer(recipientId);
        if (player != null && player.isOnline()) {
            player.sendMessage("§aYou have received new mail!");
        }
    }

    public MailItem getMail(UUID mailId) {
        return mailCache.get(mailId);
    }
}
