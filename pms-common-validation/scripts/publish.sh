#!/bin/bash
set -e

echo "Publishing pms-common-validation..."
mvn deploy
echo "✓ pms-common-validation published successfully"
