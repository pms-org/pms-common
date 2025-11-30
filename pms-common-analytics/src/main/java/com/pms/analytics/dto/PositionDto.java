package com.pms.analytics.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Data Transfer Object for portfolio positions
 * Represents current holdings for each symbol in a portfolio
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionDto {

    /**
     * Portfolio identifier
     */
    private UUID portfolioId;

    /**
     * Stock symbol / ticker
     */
    private String symbol;

    /**
     * Current number of shares held
     */
    private Long holdings;

    /**
     * Record creation timestamp
     */
    private LocalDateTime createdAt;

    /**
     * Record last-modified timestamp
     */
    private LocalDateTime updatedAt;
}
