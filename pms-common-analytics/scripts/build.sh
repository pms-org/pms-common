#!/bin/bash
set -e

echo "Building pms-common-analytics..."
mvn clean install -DskipTests
echo "✓ pms-common-analytics built successfully"
