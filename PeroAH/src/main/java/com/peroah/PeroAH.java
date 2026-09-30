package com.peroah;

import com.peroah.api.AuctionHouseAPI;
import com.peroah.config.ConfigManager;
import com.peroah.commands.AdminCommand;
import com.peroah.listeners.InventoryListener;
import com.peroah.tasks.AuctionExpirationTask;
import org.bukkit.plugin.java.JavaPlugin;

public class PeroAH extends JavaPlugin {
    private static PeroAH instance;
    private ConfigManager configManager;
    private AuctionHouseAPI auctionHouseAPI;

    @Override
    public void onEnable() {
        instance = this;
        
        // Load configuration
        this.configManager = new ConfigManager(this);
        configManager.loadConfig();
        
        // Initialize API
        this.auctionHouseAPI = new AuctionHouseAPI(this);
        
        // Register commands
        getCommand("auctionhouse").setExecutor(new AdminCommand(this));
        
        // Register listeners
        getServer().getPluginManager().registerEvents(new InventoryListener(this), this);
        
        // Schedule tasks
        new AuctionExpirationTask(this).runTaskTimer(this, 0L, 20L * 60L); // Run every minute
        
        getLogger().info("PeroAH has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("PeroAH has been disabled!");
    }

    public static PeroAH getInstance() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public AuctionHouseAPI getAuctionHouseAPI() {
        return auctionHouseAPI;
    }
}
