# GitHub Packages Deployment Setup

## Current Status

✅ **Build Status**: SUCCESS  
✅ **All modules compiled and installed to local Maven repository**  
✅ **Parent POM configured for GitHub Packages**  
✅ **Source and Javadoc JARs generated**

## Repository Configuration

**Organization**: `pms-org`  
**Repository**: `pms-common`  
**GitHub Packages URL**: `https://maven.pkg.github.com/pms-org/pms-common`

## Prerequisites

Before deploying to GitHub Packages, you need:

1. **GitHub Personal Access Token** with `write:packages` permission
2. **Maven settings configured** with GitHub authentication
3. **GitHub repository created** at `https://github.com/pms-org/pms-common`

## Step 1: Create GitHub Personal Access Token

1. Go to GitHub Settings → Developer settings → Personal access tokens → Tokens (classic)
2. Click "Generate new token (classic)"
3. Set name: `Maven Package Publishing`
4. Select scopes:
   - ✅ `write:packages` (Upload packages to GitHub Package Registry)
   - ✅ `read:packages` (Download packages from GitHub Package Registry)
   - ✅ `delete:packages` (optional - Delete packages from GitHub Package Registry)
5. Click "Generate token"
6. **Save the token securely** - you won't be able to see it again!

## Step 2: Configure Maven Settings

Create or edit `~/.m2/settings.xml`:

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                              http://maven.apache.org/xsd/settings-1.0.0.xsd">
    
    <servers>
        <server>
            <id>github</id>
            <username>YOUR_GITHUB_USERNAME</username>
            <password>YOUR_GITHUB_TOKEN</password>
        </server>
    </servers>

</settings>
```

**Important**: Replace `YOUR_GITHUB_USERNAME` and `YOUR_GITHUB_TOKEN` with your actual values.

### For Linux/Mac:
```bash
nano ~/.m2/settings.xml
```

### For Windows:
```powershell
notepad %USERPROFILE%\.m2\settings.xml
```

## Step 3: Create GitHub Repository

1. Go to `https://github.com/pms-org` (or create the organization first)
2. Click "New repository"
3. Repository name: `pms-common`
4. Description: "Shared domain modules for PMS platform microservices"
5. Set to **Public** or **Private** (your choice)
6. Click "Create repository"

## Step 4: Initialize Git and Push

```bash
cd /mnt/c/Developer/pms-common

# Initialize Git
git init

# Add all files
git add .

# Create initial commit
git commit -m "Initial commit: PMS Common library v1.0.0

- 9 domain modules with DTOs, enums, constants
- Protocol Buffers support for inter-service communication
- Complete utility library
- GitHub Packages configuration
- Professional documentation"

# Add remote (replace with your actual org URL)
git remote add origin https://github.com/pms-org/pms-common.git

# Push to GitHub
git branch -M main
git push -u origin main

# Create version tag
git tag -a v1.0.0 -m "Release version 1.0.0"
git push origin v1.0.0
```

## Step 5: Deploy to GitHub Packages

Once Git is set up and Maven settings are configured:

```bash
# Deploy all modules
mvn clean deploy -DskipTests

# Or with verbose output
mvn clean deploy -DskipTests -X
```

Expected output:
```
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for PMS Common 1.0.0:
[INFO]
[INFO] PMS Common ......................................... SUCCESS
[INFO] PMS Common Core .................................... SUCCESS
[INFO] PMS Common Ingestion ............................... SUCCESS
[INFO] PMS Common Validation .............................. SUCCESS
[INFO] PMS Common Snapshot ................................ SUCCESS
[INFO] PMS Common Analytics ............................... SUCCESS
[INFO] PMS Common Simulator ............................... SUCCESS
[INFO] PMS Common Cross-Reference ......................... SUCCESS
[INFO] PMS Common Proto ................................... SUCCESS
[INFO] PMS Common Utils ................................... SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

## Step 6: Verify Deployment

1. Go to `https://github.com/pms-org/pms-common/packages`
2. You should see all 9 modules listed as packages
3. Each package should have version `1.0.0`

## Using Published Packages

### Consumer Project Configuration

Add to your project's `pom.xml`:

```xml
<project>
    <!-- Add GitHub Packages repository -->
    <repositories>
        <repository>
            <id>github</id>
            <url>https://maven.pkg.github.com/pms-org/pms-common</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
    </repositories>

    <!-- Add dependencies -->
    <dependencies>
        <dependency>
            <groupId>com.pms</groupId>
            <artifactId>pms-common-core</artifactId>
            <version>1.0.0</version>
        </dependency>
        
        <dependency>
            <groupId>com.pms</groupId>
            <artifactId>pms-common-validation</artifactId>
            <version>1.0.0</version>
        </dependency>
        
        <!-- Add other modules as needed -->
    </dependencies>
</project>
```

### Consumer Authentication

Consumers also need to configure authentication in their `~/.m2/settings.xml`:

```xml
<settings>
    <servers>
        <server>
            <id>github</id>
            <username>CONSUMER_GITHUB_USERNAME</username>
            <password>CONSUMER_GITHUB_TOKEN</password>
        </server>
    </servers>
</settings>
```

**Note**: Consumers need a GitHub token with `read:packages` permission.

## Troubleshooting

### Error: "Unauthorized"
- Verify GitHub token has `write:packages` permission
- Check `~/.m2/settings.xml` has correct username and token
- Token `<id>` must match `<distributionManagement><repository><id>` in pom.xml

### Error: "Not Found"
- Ensure GitHub repository exists at `https://github.com/pms-org/pms-common`
- Verify repository name in pom.xml matches actual GitHub repo
- Check organization name is correct

### Error: "Failed to transfer"
- Check internet connection
- Verify GitHub is accessible
- Try with `-X` flag for debug output: `mvn deploy -X`

### Error: "Return code is: 422"
- Package with same version already exists
- Either:
  - Delete the existing package from GitHub
  - Increment version number in pom.xml

## CI/CD Integration

### GitHub Actions

Create `.github/workflows/publish.yml`:

```yaml
name: Publish to GitHub Packages

on:
  release:
    types: [created]
  push:
    branches: [main]
    paths:
      - 'pom.xml'
      - '**/pom.xml'
      - '**/*.java'

jobs:
  publish:
    runs-on: ubuntu-latest
    permissions:
      contents: read
      packages: write

    steps:
      - uses: actions/checkout@v4
      
      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'
          cache: maven
      
      - name: Build with Maven
        run: mvn -B clean verify -DskipTests
      
      - name: Publish to GitHub Packages
        run: mvn -B deploy -DskipTests
        env:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
```

### Environment Variables

For automation, you can use environment variables:

```bash
export GITHUB_TOKEN=your_token_here
mvn clean deploy -DskipTests
```

Or pass directly:

```bash
mvn clean deploy -DskipTests \
  -Dgithub.username=your_username \
  -Dgithub.password=your_token
```

## Version Management

### Release New Version

```bash
# Update version in all POMs
mvn versions:set -DnewVersion=1.1.0

# Commit the version change
mvn versions:commit

# Build and deploy
mvn clean deploy -DskipTests

# Tag the release
git add .
git commit -m "Release version 1.1.0"
git tag -a v1.1.0 -m "Release version 1.1.0"
git push origin main --tags
```

### Rollback Version Change

```bash
mvn versions:revert
```

## Security Best Practices

1. **Never commit GitHub tokens to Git**
2. **Use separate tokens for CI/CD** (GitHub Actions tokens are automatic)
3. **Rotate tokens periodically** (every 90 days recommended)
4. **Use read-only tokens** for consumers
5. **Enable 2FA** on your GitHub account
6. **Review package access** regularly

## Package Visibility

### Public Packages
- Anyone can download (with authentication)
- Good for open-source projects
- Free for public repositories

### Private Packages
- Only authorized users can access
- Requires authentication
- Check GitHub pricing for private packages

## Additional Resources

- [GitHub Packages Documentation](https://docs.github.com/en/packages)
- [Maven Deploy Plugin](https://maven.apache.org/plugins/maven-deploy-plugin/)
- [GitHub Packages Maven Registry](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry)

---

**Last Updated**: November 30, 2025  
**Status**: Ready for deployment  
**Build**: SUCCESS
