package com.peroah.auction;

import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class Auction {
    private UUID id;
    private UUID seller;
    private ItemStack item;
    private long startingPrice;
    private long currentBid;
    private UUID currentBidder;
    private long expirationTime;
    private AuctionStatus status;
    private long createdAt;

    public Auction(UUID id, UUID seller, ItemStack item, long startingPrice, long expirationTime, AuctionStatus status) {
        this.id = id;
        this.seller = seller;
        this.item = item;
        this.startingPrice = startingPrice;
        this.currentBid = startingPrice;
        this.expirationTime = expirationTime;
        this.status = status;
        this.createdAt = System.currentTimeMillis();
    }

    public UUID getId() {
        return id;
    }

    public UUID getSeller() {
        return seller;
    }

    public ItemStack getItem() {
        return item;
    }

    public long getStartingPrice() {
        return startingPrice;
    }

    public long getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(long currentBid) {
        this.currentBid = currentBid;
    }

    public UUID getCurrentBidder() {
        return currentBidder;
    }

    public void setCurrentBidder(UUID currentBidder) {
        this.currentBidder = currentBidder;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public AuctionStatus getStatus() {
        return status;
    }

    public void setStatus(AuctionStatus status) {
        this.status = status;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() >= expirationTime;
    }
}
