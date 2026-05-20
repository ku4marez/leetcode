# LeetCode Practice

Java project for algorithm practice, organized by pattern.

## Build & Test

```bash
./gradlew build    # compile + run all tests
./gradlew test     # run tests only
./gradlew test --tests "algorithm.ArrayOperationsTest.twoSum"  # run single test
```

## Project Structure

```
src/main/java/
├── algorithm/          # Solutions grouped by pattern (TwoPointer, SlidingWindow, etc.)
├── collection/         # Custom data structure implementations (Trie, LRU, AVL, etc.)
├── interview/          # Interview prep organized by day/topic
└── misc/               # Miscellaneous practice (streams, regex, file parsing)

src/test/java/          # JUnit 5 tests mirroring the source layout
src/main/resources/     # Data files for file-parsing exercises
```

## Adding a New Solution

1. Add the method to the appropriate class in `src/main/java/algorithm/`:

```java
// src/main/java/algorithm/ArrayOperations.java
public static int[] myNewSolution(int[] nums) {
    // implementation
}
```

2. Add a test in the matching test class in `src/test/java/algorithm/`:

```java
// src/test/java/algorithm/ArrayOperationsTest.java
@Test
void myNewSolution() {
    assertArrayEquals(new int[]{1, 2}, ArrayOperations.myNewSolution(new int[]{2, 1}));
}
```

3. Run: `./gradlew test`

## Adding a New Pattern/Category

1. Create `src/main/java/algorithm/MonotonicStackOperations.java`
2. Create `src/test/java/algorithm/MonotonicStackOperationsTest.java`
3. Methods are `public static` — no main methods, no executable classes.

## Dependencies

Managed via Gradle (no local jars):
- JUnit 5.10.2
- Jackson 2.17.2
