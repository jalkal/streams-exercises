package com.merkle.course.streams;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

class SourcesTest {

    /**
     * Generate list using Stream.of()
     */
    @Test
    void stream_of(){
        Stream<String> stream = null; //Modify this line

        Assertions.assertThat(stream.toList()).containsExactly("hello", "world");
    }
}