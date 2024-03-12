package com.merkle.course.streams;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

class SourcesTest {

    /**
     * Create Stream using Stream.of()
     */
    @Test
    void stream_of(){
        Stream<String> stream = null; //Modify this line

        Assertions.assertThat(stream.toList()).containsExactly("hello", "world");
    }

    /**
     * Create Stream using Stream.generate()
     */
    @Test
    void stream_generate(){
        Condition<String> isHello = new Condition<>(s -> s.equals("hello"), "Are hello");

        Stream<String> stream = null; //Modify this line

        Assertions.assertThat(stream).areExactly(10, isHello);
    }
}