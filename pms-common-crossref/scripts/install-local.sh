#!/bin/bash
set -e
echo "Installing pms-common-crossref locally..."
mvn clean install
echo "✓ pms-common-crossref installed to local repository"
