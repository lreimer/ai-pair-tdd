# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Java library project built with Gradle, designed for AI-paired Test-Driven Development (TDD) workflows. The project uses Java 21 with JUnit Jupiter for testing.

## Build System

- **Build Tool**: Gradle with Gradle Wrapper
- **Java Version**: Java 21 (configured via toolchain)
- **Module Structure**: Single-module project with `lib` subproject
- **Dependency Management**: Uses Gradle version catalog (`gradle/libs.versions.toml`)

## Essential Commands

### Building and Testing
```bash
# Build the entire project
./gradlew build

# Run all tests
./gradlew test

# Run a specific test class
./gradlew test --tests org.example.LibraryTest

# Run a specific test method
./gradlew test --tests org.example.LibraryTest.someLibraryMethodReturnsTrue

# Clean build artifacts
./gradlew clean

# Build without running tests
./gradlew build -x test
```

### Development Workflow
```bash
# Compile main sources
./gradlew compileJava

# Compile test sources
./gradlew compileTestJava

# Continuous testing (re-run tests on changes)
./gradlew test --continuous
```

## Project Structure

```
ai-pair-tdd/
├── lib/                          # Main library module
│   ├── src/
│   │   ├── main/java/org/example/    # Production code
│   │   └── test/java/org/example/    # JUnit Jupiter tests
│   └── build.gradle              # Module-specific build configuration
├── gradle/
│   └── libs.versions.toml        # Centralized dependency versions
├── settings.gradle               # Project settings and module declarations
└── gradle.properties             # Gradle configuration (configuration-cache enabled)
```

## Key Dependencies

- **JUnit Jupiter** (5.11.1): Testing framework
- **Guava** (33.3.1-jre): Internal utility library (implementation scope)
- **Apache Commons Math3** (3.6.1): Exported API dependency

## Architecture Notes

- The project uses a `java-library` plugin which separates API (`api`) and implementation (`implementation`) dependencies
- Dependencies declared with `api` are transitive and exposed to consumers
- Dependencies declared with `implementation` are internal and not exposed to consumers
- JUnit Platform Launcher is included at test runtime for executing tests

## Development Configuration

- **Configuration Cache**: Enabled for faster builds (see `gradle.properties`)
- **IDE Integration**: VSCode configured with automatic Java compilation and null analysis
- The project uses the foojay-resolver convention plugin for automatic JDK downloads
