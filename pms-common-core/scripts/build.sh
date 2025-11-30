#!/bin/bash
set -e

echo "Building pms-common-core..."
mvn clean install -DskipTests
echo "✓ pms-common-core built successfully"
