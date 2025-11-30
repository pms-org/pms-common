#!/bin/bash
set -e

echo "========================================="
echo "Generating Protobuf Java Classes"
echo "========================================="

cd "$(dirname "$0")/.."

echo ""
echo "→ Generating proto classes for pms-common-proto..."
cd pms-common-proto
mvn clean compile
cd ..
echo "✓ Protobuf classes generated successfully"

echo ""
echo "========================================="
echo "✓ Proto generation complete!"
echo "========================================="
