package com.peroah.gui;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class GuiHolder implements InventoryHolder {
    private String guiType;

    public GuiHolder(String guiType) {
        this.guiType = guiType;
    }

    @Override
    public Inventory getInventory() {
        return null;
    }

    public String getGuiType() {
        return guiType;
    }
}
