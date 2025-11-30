package com.pms.ingestion.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Data Transfer Object for outbox events.
 * Implements the Transactional Outbox pattern for reliable message publishing.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OutboxEventDto {

    /**
     * Primary key for the outbox event
     */
    private UUID eventId;

    /**
     * Partition key used for Kafka partitioning
     */
    private String aggregateId;

    /**
     * Type of event (e.g., TradeValidated, TradeProcessed)
     */
    private String eventType;

    /**
     * Serialized event payload in bytes
     */
    private byte[] payloadBytes;

    /**
     * Timestamp when the event was created
     */
    private LocalDateTime createdAt;

    /**
     * Timestamp when CDC processed this event
     */
    private LocalDateTime processedAt;
}
