#!/bin/bash
set -e
echo "Building pms-common-simulator..."
mvn clean install -DskipTests
echo "✓ pms-common-simulator built successfully"
