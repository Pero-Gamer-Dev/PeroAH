package com.peroah.economy;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.UUID;

public class EconomyService {
    private static Economy economy = null;

    public static void initialize() {
        if (economy != null) return;
        
        RegisteredServiceProvider<Economy> rsp = Bukkit.getServicesManager().getRegistration(Economy.class);
        if (rsp != null) {
            economy = rsp.getProvider();
        }
    }

    public static boolean hasBalance(UUID playerId, double amount) {
        if (economy == null) return true;
        Player player = Bukkit.getPlayer(playerId);
        return player != null && economy.has(player, amount);
    }

    public static double getBalance(UUID playerId) {
        if (economy == null) return 0;
        Player player = Bukkit.getPlayer(playerId);
        return player != null ? economy.getBalance(player) : 0;
    }

    public static void withdraw(UUID playerId, double amount) {
        if (economy == null) return;
        Player player = Bukkit.getPlayer(playerId);
        if (player != null) {
            economy.withdrawPlayer(player, amount);
        }
    }

    public static void deposit(UUID playerId, double amount) {
        if (economy == null) return;
        Player player = Bukkit.getPlayer(playerId);
        if (player != null) {
            economy.depositPlayer(player, amount);
        }
    }
}
