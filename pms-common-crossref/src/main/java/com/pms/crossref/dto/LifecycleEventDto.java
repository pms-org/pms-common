package com.pms.crossref.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Data Transfer Object for lifecycle events
 * Tracks processing stages across the entire system
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LifecycleEventDto {

    /**
     * Lifecycle trace identifier
     */
    private UUID traceId;

    /**
     * External Trade ID from OMS
     */
    private String xRef;

    /**
     * Portfolio identifier
     */
    private String portfolioId;

    /**
     * Processing stage (e.g., INGESTION, VALIDATION, ENRICHMENT, ANALYTICS)
     */
    private String stage;

    /**
     * Status of the stage (SUCCESS/FAILURE)
     */
    private String status;

    /**
     * Timestamp of the event
     */
    private LocalDateTime ts;

    /**
     * Additional metadata as JSON
     */
    private JsonNode details;
}
