package com.merkle.course.streams;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SourcesTest {

    /**
     * Create Stream using Stream.of()
     */
    @Test
    void stream_of(){
        Stream<String> stream = Stream.of("hello", "world");

        assertThat(stream).containsExactly("hello", "world");
    }

    /**
     * Create Stream using Stream.generate()
     */
    @Test
    void stream_generate(){
        Condition<String> isHello = new Condition<>(s -> s.equals("hello"), "is hello");

        Stream<String> stream = Stream.generate(()-> "hello").limit(10);

        assertThat(stream).areExactly(10, isHello);
    }

    /**
     * Create Stream using Stream.iterate()
     */
    @Test
    void stream_iterate(){
        Stream<Integer> stream = Stream.iterate(0, i-> i <= 10,  i-> i + 1);

        assertThat(stream).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    /**
     * Create Stream using IntStream.range()
     */
    @Test
    void stream_range(){
        Stream<Integer> stream = IntStream.range(0, 11).boxed();

        assertThat(stream).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }
}