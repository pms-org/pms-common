package com.pms.simulator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Data Transfer Object for simulated trades
 * Used by the simulator to generate test trade data
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimulatedTradeDto {

    /**
     * Portfolio identifier
     */
    private UUID portfolioId;

    /**
     * Trade identifier
     */
    private UUID tradeId;

    /**
     * Stock symbol / ticker
     */
    private String symbol;

    /**
     * Trade side: "buy" or "sell"
     */
    private String side;

    /**
     * Price per stock - using BigDecimal for financial precision
     * Precision: 19 digits, Scale: 4 decimal places
     */
    private BigDecimal pricePerStock;

    /**
     * Quantity of shares
     */
    private Long quantity;

    /**
     * Timestamp (past time for historical simulation)
     */
    private LocalDateTime timestamp;
}
