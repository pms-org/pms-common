#!/bin/bash
set -e
echo "Publishing pms-common-utils..."
mvn deploy
echo "✓ pms-common-utils published successfully"
