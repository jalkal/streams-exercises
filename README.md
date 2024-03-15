![Merkle](merkle-logo.png "Merkle")

# Exercises with Streams

### 1 - Sources operations, open SourcesTest and make the tests pass
- Create Stream using `Stream.of()`
- Create Stream using `Stream.generate()`
- Create Stream using `Stream.iterate()`
- Create Stream using `IntStream.range()`
- Create Stream using `IntStream.rangeClosed()`
- Create Stream using `Stream.ofNullable()`

### 2 - Intermediate operations, open IntermediateTest and make the tests pass
- Convert Stream items with `map()`
- Convert Stream items with `flatMap()`
- Filter Stream items with `filter()`
- Limit Stream items with `limit()`
- Skip Stream items with `skip()`
- Combine `skip()` and `limit()`
- Remove duplicates Stream items with `distinct()`

### 3 - Terminal operations, open TerminalTest and make the test pass
- Use a stream forEach
- Get first element from stream
- Get element with the lowest value from stream
- Get element with the highest value from stream
- Sum all elements of a stream
- Average of all elements of a stream
- Identify if a condition is meet in any stream item
- Group by a field
- Multiple collectors

### 4 - Extra bonus, open ExtraBonusTest and make the test pass
- Implement your own Collector 