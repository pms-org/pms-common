#!/bin/bash
set -e
echo "Installing pms-common-snapshot locally..."
mvn clean install
echo "✓ pms-common-snapshot installed to local repository"
