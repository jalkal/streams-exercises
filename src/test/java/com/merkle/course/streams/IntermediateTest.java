package com.merkle.course.streams;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IntermediateTest {

    /**
     * Convert Stream items with map()
     */
    @Test
    void stream_map(){
        Stream<String> stream = Stream.of(1, 2, 3, 4).map(Objects::toString);

        assertThat(stream).containsExactly("1", "2", "3", "4");
    }

    /**
     * Convert Stream items with flatMap()
     */
    @Test
    void stream_flatMap(){
        Stream<String> stream = Stream.of("hello", "world").flatMap(item -> item.chars().mapToObj(Character::toString));

        assertThat(stream).containsExactly("h", "e", "l", "l", "o", "w", "o", "r", "l", "d");
    }

    /**
     * Filter Stream items with filter()
     */
    @Test
    void stream_filter(){
        Stream<String> stream = Stream.of("hello", "", "world").filter(Predicate.not(String::isEmpty));

        assertThat(stream).containsExactly("hello", "world");
    }

    /**
     * Limit Stream items with limit()
     */
    @Test
    void stream_limit(){
        Stream<String> stream = Stream.of("hello", "world", "this", "hello", "world").limit(2);

        assertThat(stream).containsExactly("hello", "world");
    }

    /**
     * Skip Stream items with skip()
     */
    @Test
    void stream_skip(){
        Stream<String> stream = Stream.of("hello", "world", "this", "hello", "world").skip(2); //Modify this line

        assertThat(stream).containsExactly("this", "hello", "world");
    }

    /**
     * Combine skip() and limit()
     */
    @Test
    void stream_skip_limit(){
        Stream<String> stream = Stream.of("hello", "world", "this", "hello", "world").skip(2).limit(1);

        assertThat(stream).containsExactly("this");
    }
}
