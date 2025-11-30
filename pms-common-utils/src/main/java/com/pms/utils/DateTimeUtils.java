package com.pms.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for date/time operations
 */
public final class DateTimeUtils {

    public static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    public static final ZoneId UTC = ZoneId.of("UTC");

    private DateTimeUtils() {
        // Prevent instantiation
    }

    /**
     * Get current timestamp in UTC
     */
    public static LocalDateTime now() {
        return LocalDateTime.now(UTC);
    }

    /**
     * Format LocalDateTime to ISO string
     */
    public static String format(LocalDateTime dateTime) {
        return dateTime.format(ISO_FORMATTER);
    }

    /**
     * Parse ISO string to LocalDateTime
     */
    public static LocalDateTime parse(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, ISO_FORMATTER);
    }
}
