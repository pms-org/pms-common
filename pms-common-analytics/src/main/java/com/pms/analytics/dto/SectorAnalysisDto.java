package com.pms.analytics.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Data Transfer Object for sector-wise analysis
 * Provides investment breakdown by sector
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SectorAnalysisDto {

    /**
     * Portfolio identifier
     */
    private UUID portfolioId;

    /**
     * Sector name
     */
    private String sectorName;

    /**
     * Total invested amount in this sector
     * Precision: 19 digits, Scale: 4 decimal places
     */
    private BigDecimal investedPrice;

    /**
     * Record creation timestamp
     */
    private LocalDateTime createdAt;

    /**
     * Record last-modified timestamp
     */
    private LocalDateTime updatedAt;
}
