package com.pms.analytics.constants;

/**
 * Constants used across the analytics domain
 */
public final class AnalyticsConstants {

    private AnalyticsConstants() {
        // Prevent instantiation
    }

    // Table names
    public static final String TABLE_PNL = "pnl";
    public static final String TABLE_POSITION = "position";
    public static final String TABLE_RISK = "risk";
    public static final String TABLE_SECTOR_ANALYSIS = "sector_analysis";

    // Kafka topics
    public static final String TOPIC_PNL_CALCULATED = "pms.analytics.pnl";
    public static final String TOPIC_POSITION_UPDATED = "pms.analytics.position";
    public static final String TOPIC_RISK_CALCULATED = "pms.analytics.risk";
    public static final String TOPIC_SECTOR_UPDATED = "pms.analytics.sector";

    // Metrics
    public static final String METRIC_PNL_CALCULATED = "pms.analytics.pnl.calculated";
    public static final String METRIC_POSITION_UPDATED = "pms.analytics.position.updated";
    public static final String METRIC_RISK_CALCULATED = "pms.analytics.risk.calculated";
}
