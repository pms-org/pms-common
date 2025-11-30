#!/bin/bash
set -e

echo "Publishing pms-common-core..."
mvn deploy
echo "✓ pms-common-core published successfully"
