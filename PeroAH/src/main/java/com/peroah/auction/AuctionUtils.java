package com.peroah.auction;

import java.util.concurrent.TimeUnit;

public class AuctionUtils {
    public static String formatTimeRemaining(long expirationTime) {
        long remaining = expirationTime - System.currentTimeMillis();
        if (remaining <= 0) {
            return "Expired";
        }
        
        long days = TimeUnit.MILLISECONDS.toDays(remaining);
        long hours = TimeUnit.MILLISECONDS.toHours(remaining) % 24;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(remaining) % 60;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(remaining) % 60;
        
        if (days > 0) {
            return days + "d " + hours + "h";
        } else if (hours > 0) {
            return hours + "h " + minutes + "m";
        } else if (minutes > 0) {
            return minutes + "m " + seconds + "s";
        } else {
            return seconds + "s";
        }
    }
}
