#!/bin/bash
set -e
echo "Publishing pms-common-crossref..."
mvn deploy
echo "✓ pms-common-crossref published successfully"
