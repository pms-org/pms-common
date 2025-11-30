#!/bin/bash
set -e

echo "Installing pms-common-validation locally..."
mvn clean install
echo "✓ pms-common-validation installed to local repository"
