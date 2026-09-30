package com.peroah.bidding;

import com.peroah.auction.Auction;
import com.peroah.util.Money;

public class BidValidator {
    public static boolean isValidBid(Auction auction, long bidAmount) {
        if (auction == null) {
            return false;
        }
        return bidAmount > auction.getCurrentBid();
    }

    public static boolean hasEnoughMoney(long playerBalance, long bidAmount) {
        return playerBalance >= bidAmount;
    }

    public static String getValidationError(Auction auction, long bidAmount, long playerBalance) {
        if (auction == null) {
            return "Auction not found!";
        }
        if (!isValidBid(auction, bidAmount)) {
            return "Bid must be higher than current bid of " + Money.format(auction.getCurrentBid());
        }
        if (!hasEnoughMoney(playerBalance, bidAmount)) {
            return "You don't have enough money!";
        }
        return null;
    }
}
