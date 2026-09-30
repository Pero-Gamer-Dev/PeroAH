package com.peroah.bidding;

import java.util.UUID;

public class Bid {
    private UUID id;
    private UUID auctionId;
    private UUID bidderId;
    private long amount;
    private long bidTime;

    public Bid(UUID id, UUID auctionId, UUID bidderId, long amount, long bidTime) {
        this.id = id;
        this.auctionId = auctionId;
        this.bidderId = bidderId;
        this.amount = amount;
        this.bidTime = bidTime;
    }

    public UUID getId() {
        return id;
    }

    public UUID getAuctionId() {
        return auctionId;
    }

    public UUID getBidderId() {
        return bidderId;
    }

    public long getAmount() {
        return amount;
    }

    public long getBidTime() {
        return bidTime;
    }
}
