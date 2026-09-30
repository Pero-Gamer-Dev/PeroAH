package com.peroah.gui;

import com.peroah.PeroAH;
import com.peroah.auction.Auction;
import com.peroah.util.Text;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GuiManager {
    public static void openAuctionHouseGUI(Player player) {
        Inventory inv = Bukkit.createInventory(new GuiHolder("auction_house"), 54, Text.color("&6Auction House"));
        
        List<Auction> auctions = PeroAH.getInstance().getAuctionHouseAPI().getActiveAuctions();
        int slot = 0;
        for (Auction auction : auctions) {
            if (slot >= 54) break;
            inv.setItem(slot++, auction.getItem());
        }
        
        // Add GUI decorations
        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta meta = filler.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(" ");
            filler.setItemMeta(meta);
        }
        
        // Fill edges
        for (int i = 45; i < 54; i++) {
            if (inv.getItem(i) == null) {
                inv.setItem(i, filler);
            }
        }
        
        player.openInventory(inv);
    }

    public static void openMailGUI(Player player) {
        Inventory inv = Bukkit.createInventory(new GuiHolder("mail"), 27, Text.color("&6Mail"));
        player.openInventory(inv);
    }
}
