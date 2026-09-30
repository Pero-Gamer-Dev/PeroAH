package com.peroah.api;

import com.peroah.PeroAH;
import com.peroah.auction.Auction;
import com.peroah.auction.AuctionStatus;
import com.peroah.bidding.Bid;
import com.peroah.mail.MailItem;
import com.peroah.storage.AuctionRepository;
import com.peroah.storage.BidRepository;
import com.peroah.storage.MailRepository;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.UUID;

public class AuctionHouseAPI {
    private PeroAH plugin;
    private AuctionRepository auctionRepository;
    private BidRepository bidRepository;
    private MailRepository mailRepository;

    public AuctionHouseAPI(PeroAH plugin) {
        this.plugin = plugin;
        this.auctionRepository = new AuctionRepository();
        this.bidRepository = new BidRepository();
        this.mailRepository = new MailRepository();
    }

    /**
     * Create a new auction
     */
    public Auction createAuction(Player seller, ItemStack item, long startingPrice, long duration) {
        Auction auction = new Auction(
            UUID.randomUUID(),
            seller.getUniqueId(),
            item,
            startingPrice,
            System.currentTimeMillis() + (duration * 1000),
            AuctionStatus.ACTIVE
        );
        auctionRepository.save(auction);
        return auction;
    }

    /**
     * Place a bid on an auction
     */
    public boolean placeBid(Auction auction, Player bidder, long amount) {
        Bid bid = new Bid(
            UUID.randomUUID(),
            auction.getId(),
            bidder.getUniqueId(),
            amount,
            System.currentTimeMillis()
        );
        bidRepository.save(bid);
        auction.setCurrentBid(amount);
        auction.setCurrentBidder(bidder.getUniqueId());
        auctionRepository.update(auction);
        return true;
    }

    /**
     * Get all active auctions
     */
    public List<Auction> getActiveAuctions() {
        return auctionRepository.findByStatus(AuctionStatus.ACTIVE);
    }

    /**
     * Get an auction by ID
     */
    public Auction getAuction(UUID auctionId) {
        return auctionRepository.findById(auctionId);
    }

    /**
     * Send mail to a player
     */
    public void sendMail(UUID playerId, ItemStack item, String message) {
        MailItem mailItem = new MailItem(
            UUID.randomUUID(),
            playerId,
            item,
            message,
            System.currentTimeMillis()
        );
        mailRepository.save(mailItem);
    }
}
