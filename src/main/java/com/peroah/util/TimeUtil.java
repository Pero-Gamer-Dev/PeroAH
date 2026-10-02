package com.peroah.util;

public final class TimeUtil {
    private TimeUtil() {}

    public static long secondsToMillis(long seconds) {
        return seconds * 1000L;
    }
}
