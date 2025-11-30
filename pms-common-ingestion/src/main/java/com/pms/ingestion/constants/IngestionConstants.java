package com.pms.ingestion.constants;

/**
 * Constants used across the ingestion domain
 */
public final class IngestionConstants {

    private IngestionConstants() {
        // Prevent instantiation
    }

    // Table names
    public static final String TABLE_TRADE_AUDIT_LOG = "trade_audit_log";
    public static final String TABLE_OUTBOX_EVENTS = "outbox_events";

    // Kafka topics
    public static final String TOPIC_TRADE_INGESTED = "pms.ingestion.trade";
    public static final String TOPIC_OUTBOX = "pms.outbox";

    // Metrics
    public static final String METRIC_TRADE_INGESTED = "pms.ingestion.trade.received";
    public static final String METRIC_OUTBOX_PUBLISHED = "pms.ingestion.outbox.published";
}
