package com.peroah.api.event;

public class AuctionCancelEvent {
    private final int auctionId;

    public AuctionCancelEvent(int auctionId) {
        this.auctionId = auctionId;
    }

    public int getAuctionId() {
        return auctionId;
    }
}
