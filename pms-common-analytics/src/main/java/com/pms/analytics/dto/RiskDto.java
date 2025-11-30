package com.pms.analytics.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Data Transfer Object for risk metrics
 * Contains calculated risk indicators for a portfolio
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiskDto {

    /**
     * Portfolio identifier
     */
    private UUID portfolioId;

    /**
     * Sharpe Ratio - risk-adjusted return metric
     * Precision: 19 digits, Scale: 4 decimal places
     */
    private BigDecimal sharpRatio;

    /**
     * Sortino Ratio - downside risk-adjusted return metric
     * Precision: 19 digits, Scale: 4 decimal places
     */
    private BigDecimal sortinoRatio;

    /**
     * Record creation timestamp
     */
    private LocalDateTime createdAt;

    /**
     * Record last-modified timestamp
     */
    private LocalDateTime updatedAt;
}
