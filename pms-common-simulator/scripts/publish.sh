#!/bin/bash
set -e
echo "Publishing pms-common-simulator..."
mvn deploy
echo "✓ pms-common-simulator published successfully"
