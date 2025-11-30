package com.pms.validation.dto;

import com.pms.core.enums.TradeSide;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Data Transfer Object for validation outbox
 * Stores validated trades before forwarding to downstream services
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationOutboxDto {

    /**
     * Primary key; auto-generated identity
     */
    private Long validationOutboxId;

    /**
     * Trade identifier (UUID)
     */
    private UUID tradeId;

    /**
     * Portfolio identifier (UUID)
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
     * Price per share; precision 19 scale 4
     */
    private BigDecimal pricePerStock;

    /**
     * Number of shares
     */
    private Long quantity;

    /**
     * Event timestamp
     */
    private LocalDateTime timestamp;

    /**
     * Processing status (e.g., PENDING, PROCESSED)
     */
    private String status;

    /**
     * Record creation timestamp
     */
    private LocalDateTime createdAt;

    /**
     * Record last-modified timestamp
     */
    private LocalDateTime updatedAt;
}
