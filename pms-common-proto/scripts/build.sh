#!/bin/bash
set -e
echo "Building pms-common-proto..."
mvn clean compile
echo "✓ pms-common-proto built successfully"
