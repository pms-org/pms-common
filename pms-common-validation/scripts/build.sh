#!/bin/bash
set -e

echo "Building pms-common-validation..."
mvn clean install -DskipTests
echo "✓ pms-common-validation built successfully"
