#!/bin/bash
set -e

echo "Building pms-common-ingestion..."
mvn clean install -DskipTests
echo "✓ pms-common-ingestion built successfully"
