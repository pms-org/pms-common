package com.pms.validation.constants;

/**
 * Constants used across the validation domain
 */
public final class ValidationConstants {

    private ValidationConstants() {
        // Prevent instantiation
    }

    // Table names
    public static final String TABLE_STOCKS = "stocks";
    public static final String TABLE_VALIDATION_OUTBOX = "validation_outbox";

    // Kafka topics
    public static final String TOPIC_TRADE_VALIDATED = "pms.validation.validated";
    public static final String TOPIC_VALIDATION_FAILED = "pms.validation.failed";

    // Status values
    public static final String STATUS_PENDING = "PENDING";
    public static final String STATUS_PROCESSED = "PROCESSED";
    public static final String STATUS_FAILED = "FAILED";

    // Metrics
    public static final String METRIC_TRADE_VALIDATED = "pms.validation.trade.validated";
    public static final String METRIC_VALIDATION_FAILED = "pms.validation.trade.failed";
}
