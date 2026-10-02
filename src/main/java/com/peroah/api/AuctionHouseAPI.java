package com.peroah.api;

import org.bukkit.entity.Player;

public interface AuctionHouseAPI {
    boolean createAuction(Player player, Object item, double price);
    boolean cancelAuction(int auctionId);
}
