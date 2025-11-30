# PMS Common

A domain-driven Maven library monorepo providing shared DTOs, constants, Protocol Buffers definitions, and utilities for the Portfolio Management System (PMS) platform.

## Overview

This repository contains modular, reusable components organized by domain boundaries. Each module provides immutable DTOs, enums, constants, and protobuf schemas for inter-service communication.

## Modules

### Core Modules

- **pms-common-core**: Core domain models for trades and transactions
- **pms-common-ingestion**: Ingestion domain with audit logs and outbox events
- **pms-common-validation**: Validation domain with stock data and validation outbox
- **pms-common-analytics**: Analytics domain with PnL, positions, risk metrics, and sector analysis
- **pms-common-snapshot**: Market snapshot data models
- **pms-common-simulator**: Trade simulation message structures
- **pms-common-crossref**: Cross-cutting lifecycle event tracking

### Infrastructure Modules

- **pms-common-proto**: Protocol Buffer definitions for all domains
- **pms-common-utils**: Common utilities (JSON, DateTime, UUID helpers)

## Technology Stack

- Java 17
- Maven 3.9+
- Lombok 1.18.30
- Protocol Buffers 3.25.1
- gRPC 1.60.0
- Jackson 2.16.0
- MapStruct 1.5.5.Final

## Installation

### Using as a Maven Dependency

Add the following to your pom.xml:

\`\`\`xml
<dependency>
    <groupId>com.pms</groupId>
    <artifactId>pms-common-core</artifactId>
    <version>1.0.0</version>
</dependency>
\`\`\`

### GitHub Packages Configuration

Configure GitHub Packages authentication in ~/.m2/settings.xml

## Building from Source

### Prerequisites

- Java 17 or later
- Maven 3.9 or later

### Build Commands

\`\`\`bash
# Clean and build all modules
mvn clean install

# Skip tests
mvn clean install -DskipTests
\`\`\`

## License

MIT License
