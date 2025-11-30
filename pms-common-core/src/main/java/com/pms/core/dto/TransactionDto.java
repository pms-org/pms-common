package com.pms.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Data Transfer Object representing a transaction in the PMS platform.
 * Transactions track the buy-sell matching and remaining quantities.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    /**
     * Unique identifier for the transaction (Primary Key)
     */
    private UUID transactionId;

    /**
     * Reference to the associated trade (Foreign Key)
     */
    private UUID tradeId;

    /**
     * Buy price for this transaction
     * Precision: 19 digits, Scale: 4 decimal places
     */
    private BigDecimal buyPrice;

    /**
     * Sell price for this transaction
     * Precision: 19 digits, Scale: 4 decimal places
     */
    private BigDecimal sellPrice;

    /**
     * Total quantity involved in this transaction
     */
    private Long quantity;

    /**
     * Remaining quantity not yet matched/closed
     */
    private Long remainingQuantity;
}
