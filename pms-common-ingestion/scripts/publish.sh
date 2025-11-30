#!/bin/bash
set -e

echo "Publishing pms-common-ingestion..."
mvn deploy
echo "✓ pms-common-ingestion published successfully"
