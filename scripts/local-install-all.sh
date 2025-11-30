#!/bin/bash
set -e

echo "========================================="
echo "Installing All PMS Domain Modules Locally"
echo "========================================="

cd "$(dirname "$0")/.."

# Install modules to local Maven repository
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
    echo "→ Installing $module..."
    cd "$module"
    mvn clean install
    cd ..
    echo "✓ $module installed to local repository"
done

echo ""
echo "========================================="
echo "✓ All modules installed to ~/.m2/repository"
echo "========================================="
