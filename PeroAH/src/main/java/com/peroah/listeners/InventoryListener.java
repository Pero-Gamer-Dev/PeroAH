package com.peroah.listeners;

import com.peroah.PeroAH;
import com.peroah.gui.GuiHolder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class InventoryListener implements Listener {
    private PeroAH plugin;

    public InventoryListener(PeroAH plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        InventoryHolder holder = e.getInventory().getHolder();
        if (!(holder instanceof GuiHolder)) {
            return;
        }

        GuiHolder guiHolder = (GuiHolder) holder;
        e.setCancelled(true);

        switch (guiHolder.getGuiType()) {
            case "auction_house":
                handleAuctionHouseClick(e);
                break;
            case "mail":
                handleMailClick(e);
                break;
        }
    }

    private void handleAuctionHouseClick(InventoryClickEvent e) {
        // Handle auction house clicks
    }

    private void handleMailClick(InventoryClickEvent e) {
        // Handle mail clicks
    }
}
