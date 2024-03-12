package com.merkle.course.streams;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

class SourcesTest {

    /**
     * Generate list using Stream.of()
     */
    @Test
    void stream_of(){
        List<String> list = Stream.of("hello", "world").toList();

        Assertions.assertThat(list).containsExactly("hello", "world");
    }
}