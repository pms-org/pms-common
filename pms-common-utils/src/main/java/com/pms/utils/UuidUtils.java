package com.pms.utils;

import java.util.UUID;

/**
 * Utility class for UUID operations
 */
public final class UuidUtils {

    private UuidUtils() {
        // Prevent instantiation
    }

    /**
     * Generate a new random UUID
     */
    public static UUID generateUuid() {
        return UUID.randomUUID();
    }

    /**
     * Parse string to UUID
     */
    public static UUID fromString(String uuidString) {
        return UUID.fromString(uuidString);
    }

    /**
     * Check if string is valid UUID
     */
    public static boolean isValidUuid(String uuidString) {
        try {
            UUID.fromString(uuidString);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
