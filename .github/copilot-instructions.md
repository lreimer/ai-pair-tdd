# AI Pair Programming Instructions

## Project Type & Architecture

This is a **Java 21 library project** designed for AI-paired Test-Driven Development (TDD) kata exercises. The codebase consists of classic programming kata implementations (FizzBuzz, Bowling Game) following strict TDD principles.

**Key Architecture Principle**: This is a `java-library` project using Gradle's API/implementation dependency separation:
- `api` dependencies (Apache Commons Math3) are transitive - exposed to library consumers
- `implementation` dependencies (Guava) are internal - hidden from consumers
- All production code lives in `lib/src/main/java/org/example/`
- All tests use JUnit Jupiter 5 in `lib/src/test/java/org/example/`

## Critical Development Workflows

### Build & Test Commands (Always use Gradle Wrapper)
```bash
./gradlew build              # Full build with tests
./gradlew test               # Run all tests
./gradlew test --continuous  # Watch mode for TDD
./gradlew test --tests org.example.BowlingGameTest.testPerfectGame  # Specific test
```

**Important**: Configuration cache is enabled (`gradle.properties`). If you encounter cache issues, run `./gradlew --stop` to reset the daemon.

### TDD Workflow Pattern (Critical!)
This project follows **strict Red-Green-Refactor TDD**:
1. Write a failing test first (see `FizzBuzzTest` and `BowlingGameTest` for examples)
2. Run `./gradlew test` to verify it fails
3. Implement minimal code to make it pass
4. Refactor while keeping tests green
5. Use `./gradlew test --continuous` for rapid feedback loops

## Project-Specific Conventions

### Test Structure (Observed Pattern)
- Each test class uses `@BeforeEach` to initialize a fresh instance (see both test files)
- **Test naming convention**: Use `should` prefix (e.g., `shouldReturn1ForInput1`, `shouldReturnFizzForInput3`)
- Tests are organized from simple cases to complex: start with boundary cases, then edge cases, then comprehensive scenarios
- Use JUnit Jupiter's `assertEquals(expected, actual)` with expected value first

### Code Examples from Codebase

**FizzBuzz Pattern** (`FizzBuzz.java`):
- Builds result strings incrementally (`result += "Fizz"`)
- Returns numeric string as fallback: `result.isEmpty() ? String.valueOf(number) : result`
- Public API provides both single conversion and range generation methods

**Bowling Game Pattern** (`BowlingGame.java`):
- Uses array-based roll tracking: `private int[] rolls = new int[21]`
- Scoring logic extracts private helper methods: `isStrike()`, `isSpare()`, `strikeScore()`, etc.
- Frame-based iteration with conditional rollIndex advancement based on strike/spare detection

## Testing Strategy

All kata implementations have comprehensive test suites covering:
1. **Simple cases**: `testGutterGame` (all zeros), `shouldReturn1ForInput1`
2. **Edge cases**: `testOneSpare`, `testOneStrike` 
3. **Complex scenarios**: `testPerfectGame` (all strikes), range generation tests
4. **Boundary conditions**: Single element ranges, transition points (15 = FizzBuzz)

When adding new kata exercises, follow this progression in your test suite.

## Dependencies & Tooling

- **Java 21** via Gradle toolchain (auto-downloads if missing via foojay-resolver)
- **JUnit Jupiter 5.11.1** for all testing
- **Gradle version catalog** in `gradle/libs.versions.toml` - always reference dependencies via catalog aliases (e.g., `libs.junit.jupiter`)
- VSCode configured for automatic Java compilation and null analysis (`.vscode/settings.json`)

## When Creating New Kata Exercises

1. Create both implementation and test files in `org.example` package
2. Start with the test file - write failing tests first
3. Use `@BeforeEach` to initialize instances
4. Follow the observed test progression: simple → edge → complex → boundary
5. Extract private helper methods for complex logic (like `BowlingGame`)
6. Add both unit operations and aggregate operations (like `convert()` + `generate()` in FizzBuzz)

### Refactoring Guidelines

Apply these patterns when refactoring during the TDD cycle:

**Extract Method** when:
- A method exceeds 10-15 lines
- Logic can be described with a clear verb phrase (like `isStrike()`, `spareScore()`)
- Conditional branches need naming (replace `if (x % 3 == 0)` with `if (isDivisibleBy3(x))`)
- Duplication appears (DRY principle)

**Extract Variable** when:
- Complex expressions reduce readability
- Same calculation appears multiple times
- Magic numbers need semantic names

**Guard Clauses** for:
- Validation and edge cases (handle early returns first)
- Reduce nesting depth (prefer early returns over deep if-else)

**Complexity Limits**:
- Keep cyclomatic complexity under 5 per method
- Limit nesting depth to 2 levels
- Methods should do one thing (Single Responsibility)

**Code Smells to Refactor**:
- Long parameter lists (>3 parameters) → consider object parameter
- Primitive obsession → create value objects for domain concepts
- Feature envy → move method to the class it uses most

## Common Pitfalls to Avoid

- Don't skip the "red" phase - always verify tests fail first
- Don't use `implementation` for dependencies that appear in public API signatures (use `api`)
- Don't run `gradle` directly - always use `./gradlew` wrapper
- Don't forget the bowling game requires 21 array slots (12 rolls possible in 10th frame)
