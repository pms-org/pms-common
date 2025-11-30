#!/bin/bash
set -e
echo "Building pms-common-snapshot..."
mvn clean install -DskipTests
echo "✓ pms-common-snapshot built successfully"
