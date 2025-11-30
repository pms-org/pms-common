#!/bin/bash
set -e

echo "========================================="
echo "Building All PMS Domain Modules"
echo "========================================="

cd "$(dirname "$0")/.."

# Build parent POM first
echo ""
echo "→ Building parent POM..."
mvn clean install -N -DskipTests

# Build modules in dependency order
MODULES=(
    "pms-common-utils"
    "pms-common-core"
    "pms-common-ingestion"
    "pms-common-validation"
    "pms-common-analytics"
    "pms-common-snapshot"
    "pms-common-simulator"
    "pms-common-crossref"
    "pms-common-proto"
)

for module in "${MODULES[@]}"; do
    echo ""
    echo "→ Building $module..."
    cd "$module"
    mvn clean install -DskipTests
    cd ..
    echo "✓ $module built successfully"
done

echo ""
echo "========================================="
echo "✓ All modules built successfully!"
echo "========================================="
