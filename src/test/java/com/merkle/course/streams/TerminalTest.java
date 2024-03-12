package com.merkle.course.streams;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TerminalTest {

    Stream<Employee> employeeStream = Stream.of(new Employee("Steve", 185.00), new Employee("James", 200.00), new Employee("Craig", 170.00));

    /**
     * use Stream forEach to consume a Stream
     */
    @Test
    void stream_forEach() {
        class ConsumerTest implements Consumer<Integer> {
            Integer accumulator = 0;

            @Override
            public void accept(Integer value) {
                accumulator = accumulator + value;
            }

            Integer getAccumulator() {
                return this.accumulator;
            }
        }
        ConsumerTest consumerTest = new ConsumerTest();
        Stream<Integer> stream = Stream.of(5, 4, 3, 2, 1);
        //Implement here

        assertThat(consumerTest).extracting(ConsumerTest::getAccumulator).isEqualTo(15);
    }

    /**
     * Get first employee from Stream from employeeStream
     */
    @Test
    void stream_findFirst() {

        Optional<Employee> optionalEmployee = null; //Modify this line
        assertThat(optionalEmployee).hasValueSatisfying(employee -> assertThat(employee).extracting("name").isEqualTo("Steve"));
    }

    /**
     * Get employee with the lowest salary from employeeStream
     */
    @Test
    void stream_min() {

        Optional<Employee> optionalEmployee = null; //Modify this line
        assertThat(optionalEmployee).hasValueSatisfying(employee -> assertThat(employee).extracting("name").isEqualTo("Craig"));
    }

    /**
     * Get employee with the highest salary from employeeStream
     */
    @Test
    void stream_max() {

        Optional<Employee> optionalEmployee = null; //Modify this line
        assertThat(optionalEmployee).hasValueSatisfying(employee -> assertThat(employee).extracting("name").isEqualTo("James"));
    }

    /**
     * Get sum all employee salaries from employeeStream
     */
    @Test
    void stream_sum() {

        Double totalSalaries = null; //Modify this line
        assertThat(totalSalaries).isEqualTo(555.00);
    }

    /**
     * Get average of all employee salaries from employeeStream
     */
    @Test
    void stream_average() {

        Double averageSalaries = null; //Modify this line
        assertThat(averageSalaries).isEqualTo(185.00);
    }

    /**
     * Find if any employee has a salary higher than 200.00 from employeeStream
     */
    @Test
    void stream_anyMatch(){

        Boolean anySalaryHigherThan200 = null; //Modify this line
        assertThat(anySalaryHigherThan200).isFalse();
    }

    record Employee(String name, Double salary) {
    }
}