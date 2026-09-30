package com.peroah.tasks;

import com.peroah.PeroAH;
import com.peroah.api.event.AuctionEndEvent;
import com.peroah.auction.Auction;
import com.peroah.auction.AuctionStatus;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class AuctionExpirationTask extends BukkitRunnable {
    private PeroAH plugin;

    public AuctionExpirationTask(PeroAH plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        List<Auction> activeAuctions = plugin.getAuctionHouseAPI().getActiveAuctions();
        for (Auction auction : activeAuctions) {
            if (auction.isExpired()) {
                auction.setStatus(AuctionStatus.EXPIRED);
                Bukkit.getPluginManager().callEvent(new AuctionEndEvent(auction));
            }
        }
    }
}
