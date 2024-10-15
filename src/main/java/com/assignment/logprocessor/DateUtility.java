package com.assignment.logprocessor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public final class DateUtility {

    private static final ZoneId zone = ZoneId.of("America/New_York");

    private DateUtility() {
    }

    public static long localDateTimeToMilliseconds(LocalDateTime localDateTime) {
        return localDateTime.atZone(zone).toInstant().toEpochMilli();
    }

    public static int getHourFromMilliseconds(long milliseconds) {
        return Instant.ofEpochMilli(milliseconds)
                .atZone(zone)
                .toLocalDateTime()
                .getHour();
    }

    public static int getDayFromMilliseconds(long milliseconds) {
        return Instant.ofEpochMilli(milliseconds)
                .atZone(zone)
                .toLocalDateTime()
                .getDayOfMonth();
    }

}
