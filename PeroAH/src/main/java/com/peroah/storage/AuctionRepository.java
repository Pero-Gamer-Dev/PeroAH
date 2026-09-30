package com.peroah.storage;

import com.peroah.auction.Auction;
import com.peroah.auction.AuctionStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class AuctionRepository {
    private Map<UUID, Auction> auctions = new HashMap<>();

    public void save(Auction auction) {
        auctions.put(auction.getId(), auction);
    }

    public void update(Auction auction) {
        auctions.put(auction.getId(), auction);
    }

    public void delete(UUID auctionId) {
        auctions.remove(auctionId);
    }

    public Auction findById(UUID auctionId) {
        return auctions.get(auctionId);
    }

    public List<Auction> findByStatus(AuctionStatus status) {
        return auctions.values().stream()
            .filter(a -> a.getStatus() == status)
            .collect(Collectors.toList());
    }

    public List<Auction> findBySeller(UUID sellerId) {
        return auctions.values().stream()
            .filter(a -> a.getSeller().equals(sellerId))
            .collect(Collectors.toList());
    }

    public List<Auction> getAll() {
        return new java.util.ArrayList<>(auctions.values());
    }
}
