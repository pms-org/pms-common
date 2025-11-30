package com.pms.snapshot.constants;

/**
 * Constants used across the snapshot domain
 */
public final class SnapshotConstants {

    private SnapshotConstants() {
        // Prevent instantiation
    }

    // Table names
    public static final String TABLE_MARKET_SNAPSHOTS = "market_snapshots";

    // Kafka topics
    public static final String TOPIC_SNAPSHOT_CAPTURED = "pms.snapshot.captured";

    // Metrics
    public static final String METRIC_SNAPSHOT_CAPTURED = "pms.snapshot.captured";
}
