#!/bin/bash
set -e

echo "Installing pms-common-core locally..."
mvn clean install
echo "✓ pms-common-core installed to local repository"
