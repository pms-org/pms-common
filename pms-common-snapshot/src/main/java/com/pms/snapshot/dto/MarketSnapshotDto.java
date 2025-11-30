package com.pms.snapshot.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Data Transfer Object for market snapshots
 * Contains symbol-price mappings at a specific point in time
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketSnapshotDto {

    /**
     * Snapshot identifier
     */
    private String snapshotId;

    /**
     * Timestamp when the snapshot was captured
     */
    private LocalDateTime ts;

    /**
     * Symbol-to-price mapping stored as JSON
     * Example: {"AAPL": 150.25, "GOOGL": 2800.50, ...}
     */
    private JsonNode prices;
}
