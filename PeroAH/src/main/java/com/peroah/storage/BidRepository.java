package com.peroah.storage;

import com.peroah.bidding.Bid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class BidRepository {
    private Map<UUID, Bid> bids = new HashMap<>();

    public void save(Bid bid) {
        bids.put(bid.getId(), bid);
    }

    public Bid findById(UUID bidId) {
        return bids.get(bidId);
    }

    public List<Bid> findByAuctionId(UUID auctionId) {
        return bids.values().stream()
            .filter(b -> b.getAuctionId().equals(auctionId))
            .collect(Collectors.toList());
    }

    public List<Bid> findByBidderId(UUID bidderId) {
        return bids.values().stream()
            .filter(b -> b.getBidderId().equals(bidderId))
            .collect(Collectors.toList());
    }
}
