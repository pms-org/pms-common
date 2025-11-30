#!/bin/bash
set -e

echo "========================================="
echo "Publishing All PMS Domain Modules"
echo "========================================="

cd "$(dirname "$0")/.."

# Publish modules to artifact repository
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
    echo "→ Publishing $module..."
    cd "$module"
    mvn deploy
    cd ..
    echo "✓ $module published successfully"
done

echo ""
echo "========================================="
echo "✓ All modules published!"
echo "========================================="
