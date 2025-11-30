package com.pms.validation.dto;

import com.pms.validation.enums.Sector;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Data Transfer Object representing stock information
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {

    /**
     * Primary key; auto-generated identity
     */
    private Long stockId;

    /**
     * Stock symbol / ticker (e.g., AAPL, MSFT)
     */
    private String symbol;

    /**
     * Sector classification
     */
    private Sector sectorName;

    /**
     * Record creation timestamp
     */
    private LocalDateTime createdAt;

    /**
     * Record last-modified timestamp
     */
    private LocalDateTime updatedAt;
}
