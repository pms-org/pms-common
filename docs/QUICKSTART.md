# 🚀 PMS Domain Libraries - Quick Start Guide

## Prerequisites

Before you begin, ensure you have:
- ✅ Java 17 or higher (`java -version`)
- ✅ Maven 3.9+ (`mvn -version`)
- ✅ Git (optional, for version control)

## 🎯 Step-by-Step Setup

### Step 1: Navigate to the Monorepo

```bash
cd /mnt/c/Developer/pms-domain-libs
```

### Step 2: Verify Structure

```bash
ls -la
```

You should see:
- `pom.xml` (parent POM)
- `README.md`
- `GENERATION_SUMMARY.md`
- `scripts/` directory
- 9 module directories (pms-common-*)

### Step 3: Build All Modules

```bash
./scripts/build-all.sh
```

This will:
1. Build the parent POM
2. Build all 9 modules in dependency order
3. Run tests (currently skipped)
4. Generate protobuf classes

**Expected Output**:
```
=========================================
Building All PMS Domain Modules
=========================================

→ Building parent POM...
→ Building pms-common-utils...
✓ pms-common-utils built successfully
→ Building pms-common-core...
✓ pms-common-core built successfully
...
=========================================
✓ All modules built successfully!
=========================================
```

### Step 4: Install to Local Maven Repository

```bash
./scripts/local-install-all.sh
```

This installs all modules to `~/.m2/repository/com/pms/`

### Step 5: Verify Installation

```bash
ls ~/.m2/repository/com/pms/
```

You should see all 9 modules:
- `pms-common-core`
- `pms-common-ingestion`
- `pms-common-validation`
- `pms-common-analytics`
- `pms-common-snapshot`
- `pms-common-simulator`
- `pms-common-crossref`
- `pms-common-proto`
- `pms-common-utils`

## 🧪 Testing Individual Modules

### Test a Specific Module

```bash
cd pms-common-core
mvn clean verify
```

### View Generated Classes

```bash
ls -la pms-common-core/target/classes/com/pms/core/
```

### View Protobuf Generated Classes

```bash
ls -la pms-common-proto/target/generated-sources/protobuf/java/com/pms/proto/
```

## 📦 Using in Your Microservice

### 1. Add Dependency to Your `pom.xml`

```xml
<dependencies>
    <!-- Core Domain -->
    <dependency>
        <groupId>com.pms</groupId>
        <artifactId>pms-common-core</artifactId>
        <version>1.0.0</version>
    </dependency>

    <!-- Analytics Domain -->
    <dependency>
        <groupId>com.pms</groupId>
        <artifactId>pms-common-analytics</artifactId>
        <version>1.0.0</version>
    </dependency>

    <!-- Add other modules as needed -->
</dependencies>
```

### 2. Import and Use DTOs

```java
import com.pms.core.dto.TradeDto;
import com.pms.core.enums.TradeSide;
import com.pms.analytics.dto.PnlDto;

// Create a trade
TradeDto trade = TradeDto.builder()
    .tradeId(UUID.randomUUID())
    .portfolioId(UUID.randomUUID())
    .symbol("AAPL")
    .side(TradeSide.BUY)
    .pricePerStock(new BigDecimal("150.25"))
    .quantity(100L)
    .timestamp(LocalDateTime.now())
    .build();

// Use constants
String topicName = CoreConstants.TOPIC_TRADES;
```

### 3. Use Protobuf Messages

```java
import com.pms.proto.core.CoreProto;

// Build a protobuf trade message
CoreProto.Trade protoTrade = CoreProto.Trade.newBuilder()
    .setTradeId(tradeDto.getTradeId().toString())
    .setPortfolioId(tradeDto.getPortfolioId().toString())
    .setSymbol(tradeDto.getSymbol())
    .setSide(CoreProto.TradeSide.BUY)
    .setPricePerStock(tradeDto.getPricePerStock().toString())
    .setQuantity(tradeDto.getQuantity())
    .build();
```

## 🔧 Common Tasks

### Rebuild Everything

```bash
./scripts/build-all.sh
```

### Update Version

1. Edit `pom.xml` version:
```xml
<version>1.0.1</version>
```

2. Rebuild:
```bash
./scripts/build-all.sh
```

### Validate All Modules

```bash
./scripts/validate-modules.sh
```

### Regenerate Protobuf Classes

```bash
./scripts/generate-protos.sh
```

### Clean All Modules

```bash
cd /mnt/c/Developer/pms-domain-libs
find . -name "target" -type d -exec rm -rf {} + 2>/dev/null || true
```

## 🐛 Troubleshooting

### Issue: Build Fails with "Unable to find protoc"

**Solution**: Install Protocol Buffers compiler:

```bash
# Ubuntu/Debian
sudo apt-get install -y protobuf-compiler

# Check version
protoc --version
```

### Issue: Lombok Not Working

**Solution**: Ensure your IDE has Lombok plugin installed:
- **IntelliJ IDEA**: Settings → Plugins → Install "Lombok"
- **VS Code**: Install "Lombok Annotations Support"
- **Eclipse**: Download lombok.jar and run: `java -jar lombok.jar`

### Issue: Maven Build Fails

**Solution**: Clean and rebuild:

```bash
mvn clean
rm -rf ~/.m2/repository/com/pms
./scripts/build-all.sh
```

### Issue: Import Errors in IDE

**Solution**: 
1. Run Maven install first: `./scripts/local-install-all.sh`
2. Refresh/reimport Maven projects in your IDE
3. Rebuild IDE indexes

## 🎓 Learning Resources

### Understanding the Structure

```
pms-common-core/
├── pom.xml                      # Module configuration
├── Dockerfile                   # For containerization
├── src/main/java/com/pms/core/
│   ├── dto/                     # Data Transfer Objects
│   │   ├── TradeDto.java
│   │   └── TransactionDto.java
│   ├── enums/                   # Enumerations
│   │   └── TradeSide.java
│   └── constants/               # Constants
│       └── CoreConstants.java
└── scripts/                     # Build scripts
    ├── build.sh
    ├── publish.sh
    └── install-local.sh
```

### Module Dependencies

```
pms-common-utils         (base, no dependencies)
    ↓
pms-common-core          (depends on utils)
    ↓
pms-common-validation    (depends on core)
pms-common-analytics     (depends on core)
pms-common-ingestion     (independent)
pms-common-snapshot      (independent)
pms-common-simulator     (independent)
pms-common-crossref      (independent)
pms-common-proto         (independent)
```

## ✅ Success Checklist

After completing this guide, you should:

- [x] Have all 9 modules built successfully
- [x] See modules in `~/.m2/repository/com/pms/`
- [x] Be able to import DTOs in your Java code
- [x] Have protobuf classes generated
- [x] Understand how to add dependencies to microservices

## 🚀 Next Steps

1. **Integrate with Your Microservices**
   - Add dependencies to your service POMs
   - Replace duplicate DTOs with shared ones
   - Migrate to using common constants

2. **Set Up CI/CD**
   - Configure GitHub Actions
   - Set up artifact publishing
   - Automate version bumps

3. **Add to Version Control**
   ```bash
   cd /mnt/c/Developer/pms-domain-libs
   git init
   git add .
   git commit -m "Initial commit: PMS domain libraries monorepo"
   ```

4. **Publish to Artifact Repository**
   - Configure your Maven `settings.xml`
   - Run `./scripts/publish-all.sh`

## 📚 Additional Documentation

- See `README.md` for comprehensive documentation
- See `GENERATION_SUMMARY.md` for generation details
- Check individual module `pom.xml` files for specific configurations

## 💡 Tips

1. **Always build parent first**: The parent POM defines versions for all modules
2. **Use semantic versioning**: Follow `MAJOR.MINOR.PATCH` format
3. **Keep modules independent**: Minimize cross-module dependencies
4. **Document changes**: Update README when adding new DTOs
5. **Version together**: All modules share the same version from parent POM

---

**Questions?** Check the main `README.md` or review `GENERATION_SUMMARY.md`

**Ready to build?** Run: `./scripts/build-all.sh`
