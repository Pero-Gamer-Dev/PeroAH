package com.peroah.gui;

import com.peroah.util.Text;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Items {
    public static ItemStack createItem(Material material, String name, String... lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(Text.color(name));
            List<String> loreList = new ArrayList<>();
            for (String line : lore) {
                loreList.add(Text.color(line));
            }
            meta.setLore(loreList);
            item.setItemMeta(meta);
        }
        return item;
    }

    public static ItemStack createSkull(String playerName, String displayName, String... lore) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta meta = skull.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(Text.color(displayName));
            List<String> loreList = new ArrayList<>();
            for (String line : lore) {
                loreList.add(Text.color(line));
            }
            meta.setLore(loreList);
            skull.setItemMeta(meta);
        }
        return skull;
    }
}
