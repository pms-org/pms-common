#!/bin/bash
set -e
echo "Publishing pms-common-proto..."
mvn deploy
echo "✓ pms-common-proto published successfully"
