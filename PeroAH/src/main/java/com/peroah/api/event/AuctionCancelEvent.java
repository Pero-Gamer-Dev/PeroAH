package com.peroah.api.event;

import com.peroah.auction.Auction;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AuctionCancelEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private Auction auction;

    public AuctionCancelEvent(Auction auction) {
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
