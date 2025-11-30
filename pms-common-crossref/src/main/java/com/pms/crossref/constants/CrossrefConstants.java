package com.pms.crossref.constants;

/**
 * Constants used across the cross-reference domain
 */
public final class CrossrefConstants {

    private CrossrefConstants() {
        // Prevent instantiation
    }

    // Table names
    public static final String TABLE_LIFECYCLE_EVENTS = "lifecycle_events";

    // Kafka topics
    public static final String TOPIC_LIFECYCLE_EVENT = "pms.crossref.lifecycle";

    // Stages
    public static final String STAGE_INGESTION = "INGESTION";
    public static final String STAGE_VALIDATION = "VALIDATION";
    public static final String STAGE_ENRICHMENT = "ENRICHMENT";
    public static final String STAGE_ANALYTICS = "ANALYTICS";
    public static final String STAGE_NOTIFICATION = "NOTIFICATION";

    // Status
    public static final String STATUS_SUCCESS = "SUCCESS";
    public static final String STATUS_FAILURE = "FAILURE";

    // Metrics
    public static final String METRIC_LIFECYCLE_EVENT = "pms.crossref.lifecycle.event";
}
