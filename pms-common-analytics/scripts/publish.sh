#!/bin/bash
set -e

echo "Publishing pms-common-analytics..."
mvn deploy
echo "✓ pms-common-analytics published successfully"
