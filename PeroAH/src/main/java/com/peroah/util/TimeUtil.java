package com.peroah.util;

import java.util.concurrent.TimeUnit;

public class TimeUtil {
    public static String formatDuration(long milliseconds) {
        long days = TimeUnit.MILLISECONDS.toDays(milliseconds);
        long hours = TimeUnit.MILLISECONDS.toHours(milliseconds) % 24;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds) % 60;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds) % 60;

        StringBuilder sb = new StringBuilder();
        if (days > 0) sb.append(days).append("d ");
        if (hours > 0) sb.append(hours).append("h ");
        if (minutes > 0) sb.append(minutes).append("m ");
        if (seconds > 0 || sb.length() == 0) sb.append(seconds).append("s");

        return sb.toString().trim();
    }

    public static long parseToMilliseconds(String duration) {
        long total = 0;
        String[] parts = duration.toLowerCase().split("\\s+");
        
        for (String part : parts) {
            if (part.endsWith("d")) {
                total += Long.parseLong(part.substring(0, part.length() - 1)) * 24 * 60 * 60 * 1000;
            } else if (part.endsWith("h")) {
                total += Long.parseLong(part.substring(0, part.length() - 1)) * 60 * 60 * 1000;
            } else if (part.endsWith("m")) {
                total += Long.parseLong(part.substring(0, part.length() - 1)) * 60 * 1000;
            } else if (part.endsWith("s")) {
                total += Long.parseLong(part.substring(0, part.length() - 1)) * 1000;
            }
        }
        
        return total;
    }
}
