# PMS Common - Quick Reference Guide

## Installation

Add to your `pom.xml`:

```xml
<dependency>
    <groupId>com.pms</groupId>
    <artifactId>pms-common-core</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Core Module (`pms-common-core`)

### TradeDto
```java
import com.pms.core.dto.TradeDto;
import com.pms.core.enums.TradeSide;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

TradeDto trade = TradeDto.builder()
    .tradeId(UUID.randomUUID())
    .portfolioId(UUID.fromString("..."))
    .symbol("AAPL")
    .side(TradeSide.BUY)
    .pricePerStock(new BigDecimal("150.25"))
    .quantity(100L)
    .timestamp(LocalDateTime.now())
    .build();
```

### TransactionDto
```java
import com.pms.core.dto.TransactionDto;

TransactionDto txn = TransactionDto.builder()
    .transactionId(UUID.randomUUID())
    .tradeId(UUID.randomUUID())
    .symbol("GOOGL")
    .side(TradeSide.SELL)
    .executedPrice(new BigDecimal("2500.50"))
    .executedQuantity(50L)
    .executedTimestamp(LocalDateTime.now())
    .build();
```

## Validation Module (`pms-common-validation`)

### StockDto
```java
import com.pms.validation.dto.StockDto;
import com.pms.validation.enums.Sector;

StockDto stock = StockDto.builder()
    .symbol("TSLA")
    .sector(Sector.TECHNOLOGY)
    .marketCap(new BigDecimal("800000000000"))
    .build();
```

### Available Sectors
- TECHNOLOGY
- HEALTHCARE
- FINANCE
- ENERGY
- CONSUMER_GOODS
- INDUSTRIALS
- UTILITIES
- REAL_ESTATE
- MATERIALS
- TELECOMMUNICATIONS
- CONSUMER_SERVICES
- UNKNOWN

## Analytics Module (`pms-common-analytics`)

### PnlDto
```java
import com.pms.analytics.dto.PnlDto;

PnlDto pnl = PnlDto.builder()
    .portfolioId(UUID.randomUUID())
    .symbol("AAPL")
    .realizedPnl(new BigDecimal("1250.50"))
    .unrealizedPnl(new BigDecimal("500.25"))
    .totalPnl(new BigDecimal("1750.75"))
    .snapshotTimestamp(LocalDateTime.now())
    .build();
```

### PositionDto
```java
import com.pms.analytics.dto.PositionDto;

PositionDto position = PositionDto.builder()
    .portfolioId(UUID.randomUUID())
    .symbol("MSFT")
    .currentQuantity(200L)
    .averagePrice(new BigDecimal("350.00"))
    .currentMarketPrice(new BigDecimal("375.50"))
    .positionValue(new BigDecimal("75100.00"))
    .unrealizedPnl(new BigDecimal("5100.00"))
    .snapshotTimestamp(LocalDateTime.now())
    .build();
```

## Utils Module (`pms-common-utils`)

### JsonUtils
```java
import com.pms.utils.JsonUtils;

// Serialize to JSON
String json = JsonUtils.toJson(tradeDto);

// Deserialize from JSON
TradeDto trade = JsonUtils.fromJson(json, TradeDto.class);

// Pretty print
String prettyJson = JsonUtils.toPrettyJson(tradeDto);
```

### DateTimeUtils
```java
import com.pms.utils.DateTimeUtils;

// Get current UTC time
LocalDateTime now = DateTimeUtils.nowUtc();

// Format as ISO-8601
String isoString = DateTimeUtils.formatIso(now);

// Parse ISO-8601
LocalDateTime parsed = DateTimeUtils.parseIso("2024-01-15T10:30:00Z");

// Convert to epoch millis
long millis = DateTimeUtils.toEpochMilli(now);

// Convert from epoch millis
LocalDateTime fromMillis = DateTimeUtils.fromEpochMilli(1705315800000L);
```

### UuidUtils
```java
import com.pms.utils.UuidUtils;

// Validate UUID string
boolean isValid = UuidUtils.isValidUuid("123e4567-e89b-12d3-a456-426614174000");

// Safe parsing (returns null on invalid)
UUID uuid = UuidUtils.tryParse("invalid-uuid");
```

## Ingestion Module (`pms-common-ingestion`)

### TradeAuditLogDto
```java
import com.pms.ingestion.dto.TradeAuditLogDto;
import com.pms.ingestion.enums.TradeAuditStatus;
import com.fasterxml.jackson.databind.JsonNode;

TradeAuditLogDto audit = TradeAuditLogDto.builder()
    .auditId(UUID.randomUUID())
    .tradeId(UUID.randomUUID())
    .rawPayload(jsonNode)
    .status(TradeAuditStatus.RECEIVED)
    .ingestedTimestamp(LocalDateTime.now())
    .build();
```

### OutboxEventDto
```java
import com.pms.ingestion.dto.OutboxEventDto;

OutboxEventDto outbox = OutboxEventDto.builder()
    .eventId(UUID.randomUUID())
    .eventType("TRADE_CREATED")
    .aggregateId(UUID.randomUUID())
    .payloadBytes(payload)
    .createdTimestamp(LocalDateTime.now())
    .published(false)
    .build();
```

## Proto Module (`pms-common-proto`)

### Generated Java Classes

After building, Protocol Buffer classes are available in:
```java
import com.pms.proto.core.Trade;
import com.pms.proto.core.TradeEnvelope;
import com.google.protobuf.Timestamp;

Trade trade = Trade.newBuilder()
    .setTradeId(UUID.randomUUID().toString())
    .setPortfolioId(UUID.randomUUID().toString())
    .setSymbol("AAPL")
    .setSide("BUY")
    .setPricePerStock("150.25")
    .setQuantity(100)
    .build();

TradeEnvelope envelope = TradeEnvelope.newBuilder()
    .setTraceId(UUID.randomUUID().toString())
    .setTrade(trade)
    .setEventTimestamp(Timestamp.newBuilder()
        .setSeconds(System.currentTimeMillis() / 1000)
        .build())
    .build();
```

## Common Patterns

### Builder Pattern
All DTOs use Lombok's `@Builder`:
```java
TradeDto trade = TradeDto.builder()
    .field1(value1)
    .field2(value2)
    .build();
```

### Immutability
All DTOs are immutable. Use `toBuilder()` for modifications:
```java
TradeDto updatedTrade = originalTrade.toBuilder()
    .quantity(200L)
    .build();
```

### Null Safety
Use Optional for nullable fields:
```java
Optional<String> optionalField = Optional.ofNullable(dto.getField());
```

## Module Dependencies

When adding dependencies, follow this order:
1. `pms-common-core` (base, no dependencies)
2. `pms-common-utils` (independent)
3. Modules that depend on core: validation, analytics
4. `pms-common-proto` (independent)

Example POM:
```xml
<dependencies>
    <dependency>
        <groupId>com.pms</groupId>
        <artifactId>pms-common-core</artifactId>
        <version>1.0.0</version>
    </dependency>
    <dependency>
        <groupId>com.pms</groupId>
        <artifactId>pms-common-utils</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

## Type Conventions

- **IDs**: Use `UUID` type
- **Timestamps**: Use `LocalDateTime` (UTC)
- **Money**: Use `BigDecimal`
- **Quantities**: Use `Long`
- **Percentages/Ratios**: Use `BigDecimal`
- **JSON Data**: Use Jackson's `JsonNode`
- **Binary Data**: Use `byte[]`

## Constants Access

Each module provides a Constants class:
```java
import com.pms.core.constants.CoreConstants;
import com.pms.validation.constants.ValidationConstants;

String moduleName = CoreConstants.MODULE_NAME;
String version = ValidationConstants.VERSION;
```

## Best Practices

1. **Use Builder Pattern**: Always use `.builder()` for DTOs
2. **Validate UUIDs**: Use `UuidUtils.isValidUuid()` before parsing
3. **Handle JSON Safely**: Wrap `JsonUtils` calls in try-catch
4. **Use UTC**: Always use `DateTimeUtils.nowUtc()` for timestamps
5. **Document Side Effects**: Add Javadoc for non-obvious behavior
6. **Test Serialization**: Test JSON and Protobuf serialization in unit tests

## Maven Commands

```bash
# Add dependency to your project
mvn dependency:get -Dartifact=com.pms:pms-common-core:1.0.0

# Check for updates
mvn versions:display-dependency-updates

# Analyze dependencies
mvn dependency:tree
```

## Troubleshooting

### Module Not Found
1. Check if installed: `ls ~/.m2/repository/com/pms/`
2. Rebuild: `mvn clean install -DskipTests`
3. Update indexes: `mvn dependency:resolve`

### Version Conflicts
```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.pms</groupId>
            <artifactId>pms-common-core</artifactId>
            <version>1.0.0</version>
        </dependency>
    </dependencies>
</dependencyManagement>
```

### Lombok Not Working
1. Enable annotation processing in IDE
2. Install Lombok plugin
3. Rebuild project

---

For more details, see README.md and DEPLOYMENT_SUMMARY.md
