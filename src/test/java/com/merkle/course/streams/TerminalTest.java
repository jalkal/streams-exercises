package com.merkle.course.streams;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TerminalTest {

    /**
     * use Stream forEach to consume an Stream
     */
    @Test
    void stream_forEach(){
        class ConsumerTest implements Consumer<Integer>{
            Integer accumulator = 0;
            @Override
            public void accept(Integer value) {
                accumulator = accumulator + value;
            }

            Integer getAccumulator(){
                return this.accumulator;
            }
        }
        ConsumerTest consumerTest = new ConsumerTest();
        Stream<Integer> stream = Stream.of(5, 4, 3, 2, 1);
        stream.forEach(consumerTest);

        assertThat(consumerTest).extracting(ConsumerTest::getAccumulator).isEqualTo(15);
    }
}
