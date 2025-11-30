package com.pms.analytics.dto;

import com.pms.core.enums.TradeSide;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Data Transfer Object for Profit and Loss (PnL) calculations
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PnlDto {

    /**
     * Transaction identifier
     */
    private UUID transactionId;

    /**
     * Portfolio identifier
     */
    private UUID portfolioId;

    /**
     * Stock symbol / ticker
     */
    private String symbol;

    /**
     * Trade side (BUY/SELL)
     */
    private TradeSide side;

    /**
     * Buy price for the transaction
     * Precision: 19 digits, Scale: 4 decimal places
     */
    private BigDecimal buyPrice;

    /**
     * Remaining quantity not yet sold
     */
    private Long remainingQuantity;

    /**
     * Timestamp of the transaction
     */
    private LocalDateTime timestamp;

    /**
     * Realized profit or loss
     * Precision: 19 digits, Scale: 4 decimal places
     */
    private BigDecimal realizedPnl;

    /**
     * Record creation timestamp
     */
    private LocalDateTime createdAt;

    /**
     * Record last-modified timestamp
     */
    private LocalDateTime updatedAt;
}
