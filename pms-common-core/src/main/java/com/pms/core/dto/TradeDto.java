package com.pms.core.dto;

import com.pms.core.enums.TradeSide;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Data Transfer Object representing a trade in the PMS platform.
 * Contains all essential information about a single trade transaction.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TradeDto {

    /**
     * Unique identifier for the trade (Primary Key)
     */
    private UUID tradeId;

    /**
     * Identifier of the portfolio to which this trade belongs
     */
    private UUID portfolioId;

    /**
     * Stock symbol or ticker (e.g., AAPL, GOOGL)
     */
    private String symbol;

    /**
     * Side of the trade - either BUY or SELL
     */
    private TradeSide side;

    /**
     * Price per stock at which the trade was executed
     * Precision: 19 digits, Scale: 4 decimal places
     */
    private BigDecimal pricePerStock;

    /**
     * Total quantity of stocks traded
     */
    private Long quantity;

    /**
     * Timestamp when the trade was executed
     */
    private LocalDateTime timestamp;
}
