package com.merkle.course.streams;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

class IntermediateTest {

    /**
     * Convert Stream with map()
     */
    @Test
    void stream_map(){
        Stream<String> stream = Stream.of(1, 2, 3, 4);

        Assertions.assertThat(stream).containsExactly("1", "2", "3", "4");
    }
}
