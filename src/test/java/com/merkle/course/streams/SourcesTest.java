package com.merkle.course.streams;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SourcesTest {

    /**
     * Generate list using Stream.of()
     */
    @Test
    void stream_of(){
        List<String> list = null; //Modify this line

        Assertions.assertThat(list).containsExactly("hello", "world");
    }
}