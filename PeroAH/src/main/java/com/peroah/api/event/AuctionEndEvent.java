package com.peroah.api.event;

import com.peroah.auction.Auction;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AuctionEndEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private Auction auction;

    public AuctionEndEvent(Auction auction) {
        this.auction = auction;
    }

    public Auction getAuction() {
        return auction;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
