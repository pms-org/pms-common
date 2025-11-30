#!/bin/bash
set -e

echo "========================================="
echo "Validating All PMS Domain Modules"
echo "========================================="

cd "$(dirname "$0")/.."

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

FAILED_MODULES=()

for module in "${MODULES[@]}"; do
    echo ""
    echo "→ Validating $module..."
    cd "$module"
    
    if mvn clean verify -DskipTests; then
        echo "✓ $module validation passed"
    else
        echo "✗ $module validation failed"
        FAILED_MODULES+=("$module")
    fi
    
    cd ..
done

echo ""
echo "========================================="
if [ ${#FAILED_MODULES[@]} -eq 0 ]; then
    echo "✓ All modules validated successfully!"
else
    echo "✗ Validation failed for modules:"
    for module in "${FAILED_MODULES[@]}"; do
        echo "  - $module"
    done
    exit 1
fi
echo "========================================="
