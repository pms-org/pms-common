#!/bin/bash
set -e

echo "Installing pms-common-analytics locally..."
mvn clean install
echo "✓ pms-common-analytics installed to local repository"
