package com.pms.core.constants;

/**
 * Constants used across the core domain
 */
public final class CoreConstants {

    private CoreConstants() {
        // Prevent instantiation
    }

    // Table names
    public static final String TABLE_TRADES = "trades";
    public static final String TABLE_TRANSACTIONS = "transactions";

    // Kafka topics
    public static final String TOPIC_TRADES = "pms.trades";
    public static final String TOPIC_TRANSACTIONS = "pms.transactions";

    // Metrics
    public static final String METRIC_TRADE_PROCESSED = "pms.core.trade.processed";
    public static final String METRIC_TRANSACTION_CREATED = "pms.core.transaction.created";
}
