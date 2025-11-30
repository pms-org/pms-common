#!/bin/bash
set -e

echo "Installing pms-common-ingestion locally..."
mvn clean install
echo "✓ pms-common-ingestion installed to local repository"
