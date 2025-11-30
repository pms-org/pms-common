#!/bin/bash
set -e
echo "Publishing pms-common-snapshot..."
mvn deploy
echo "✓ pms-common-snapshot published successfully"
