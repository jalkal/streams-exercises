package com.merkle.course.streams;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.stream.Stream;

class TerminalTest {

    /**
     * use Stream forEach to consume an Stream
     */
    @Test
    void stream_forEach(){
        IntConsumerTest consumerTest = new IntConsumerTest();
        Stream<Integer> stream = Stream.of(5, 4, 3, 2, 1);
        stream.forEach(consumerTest);

        Assertions.assertThat(consumerTest).extracting(IntConsumerTest::getAccumulator).isEqualTo(15);
    }

    static class IntConsumerTest implements Consumer<Integer>{
        Integer accumulator = 0;
        @Override
        public void accept(Integer value) {
            accumulator = accumulator + value;
        }

        Integer getAccumulator(){
            return this.accumulator;
        }
    }
}
