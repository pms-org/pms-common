package com.pms.ingestion.enums;

/**
 * Status of ingested trade in the audit log
 */
public enum TradeAuditStatus {
    /**
     * Trade has been received from OMS
     */
    RECEIVED,
    
    /**
     * Trade passed validation
     */
    VALID,
    
    /**
     * Trade failed validation
     */
    INVALID,
    
    /**
     * Trade has been processed successfully
     */
    PROCESSED
}
