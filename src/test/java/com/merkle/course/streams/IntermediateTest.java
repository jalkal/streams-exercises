package com.merkle.course.streams;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IntermediateTest {

    /**
     * Convert Stream with map()
     */
    @Test
    void stream_map(){
        //Todo uncomment this line
        Stream<String> stream = null; //Stream.of(1, 2, 3, 4); //Modify this line

        assertThat(stream).containsExactly("1", "2", "3", "4");
    }

    /**
     * Filter Stream items with filter()
     */
    @Test
    void stream_filter(){
        Stream<String> stream = Stream.of("hello", "", "world");

        assertThat(stream).containsExactly("hello", "world");
    }
}
