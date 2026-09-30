package com.peroah.util;

public class Money {
    public static String format(long amount) {
        if (amount >= 1_000_000) {
            return String.format("%.2fM", amount / 1_000_000.0);
        } else if (amount >= 1_000) {
            return String.format("%.2fK", amount / 1_000.0);
        } else {
            return String.valueOf(amount);
        }
    }

    public static long parse(String amount) {
        amount = amount.toUpperCase().trim();
        if (amount.endsWith("M")) {
            return (long) (Double.parseDouble(amount.substring(0, amount.length() - 1)) * 1_000_000);
        } else if (amount.endsWith("K")) {
            return (long) (Double.parseDouble(amount.substring(0, amount.length() - 1)) * 1_000);
        } else {
            return Long.parseLong(amount);
        }
    }
}
