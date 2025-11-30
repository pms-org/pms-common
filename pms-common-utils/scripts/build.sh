#!/bin/bash
set -e
echo "Building pms-common-utils..."
mvn clean install -DskipTests
echo "✓ pms-common-utils built successfully"
