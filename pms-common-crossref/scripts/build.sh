#!/bin/bash
set -e
echo "Building pms-common-crossref..."
mvn clean install -DskipTests
echo "✓ pms-common-crossref built successfully"
