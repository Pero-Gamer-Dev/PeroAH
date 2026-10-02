package com.peroah;

import org.bukkit.plugin.java.JavaPlugin;

public class PeroAH extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("PeroAH enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("PeroAH disabled.");
    }
}
