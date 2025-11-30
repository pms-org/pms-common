package com.pms.ingestion.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.pms.ingestion.enums.TradeAuditStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Data Transfer Object for trade audit log entries.
 * Captures all trades ingested from OMS with their validation status.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TradeAuditLogDto {

    /**
     * Primary key for audit row
     */
    private UUID id;

    /**
     * External Trade ID from OMS
     */
    private String xRef;

    /**
     * Portfolio identifier
     */
    private String portfolioId;

    /**
     * Asset symbol (ticker)
     */
    private String symbol;

    /**
     * Trade side: BUY or SELL
     */
    private String side;

    /**
     * Quantity of shares
     */
    private Long qty;

    /**
     * Price from OMS
     */
    private BigDecimal price;

    /**
     * Original payload from OMS in JSON format
     */
    private JsonNode rawPayload;

    /**
     * Timestamp when the trade was ingested
     */
    private LocalDateTime ingestTimestamp;

    /**
     * Current status of the trade in the processing pipeline
     */
    private TradeAuditStatus status;

    /**
     * Validation error message if status is INVALID
     */
    private String errorMessage;
}
