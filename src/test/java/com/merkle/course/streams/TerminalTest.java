package com.merkle.course.streams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TerminalTest {

    Stream<Employee> employeeStream = Stream.of(new Employee("Steve", 185.00, "sales"),
            new Employee("James", 200.00, "sales"),
            new Employee("Craig", 170.00, "technology"),
            new Employee("Robert", 183.00, "technology"));

    /**
     * use Stream forEach to consume a Stream using forEach()
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
        Stream.of(5, 4, 3, 2, 1); //Modify this line

        assertThat(consumerTest).extracting(ConsumerTest::getAccumulator).isEqualTo(15);
    }

    /**
     * Get first employee from employeeStream using findFirst()
     */
    @Test
    void stream_findFirst() {

        Optional<Employee> optionalEmployee = null; //Modify this line
        assertThat(optionalEmployee).hasValueSatisfying(employee -> assertThat(employee).extracting("name").isEqualTo("Steve"));
    }

    /**
     * Get employee with the lowest salary from employeeStream using min()
     */
    @Test
    void stream_min() {

        Optional<Employee> optionalEmployee = null; //Modify this line
        assertThat(optionalEmployee).hasValueSatisfying(employee -> assertThat(employee).extracting("name").isEqualTo("Craig"));
    }

    /**
     * Get employee with the highest salary from employeeStream using max()
     */
    @Test
    void stream_max() {

        Optional<Employee> optionalEmployee = null; //Modify this line
        assertThat(optionalEmployee).hasValueSatisfying(employee -> assertThat(employee).extracting("name").isEqualTo("James"));
    }

    /**
     * Get sum all employee salaries from employeeStream using sum()
     */
    @Test
    void stream_sum() {

        Double totalSalaries = null; //Modify this line
        assertThat(totalSalaries).isEqualTo(738.00);
    }

    /**
     * Get sum all employee salaries from employeeStream using reduce()
     */
    @Test
    void stream_reduce() {

        Double totalSalaries = null; //Modify this test
        assertThat(totalSalaries).isEqualTo(738.00);
    }

    /**
     * Get average of all employee salaries from employeeStream using average()
     */
    @Test
    void stream_average() {

        Double averageSalaries = null; //Modify this line
        assertThat(averageSalaries).isEqualTo(184.50);
    }

    /**
     * Find if any employee has a salary higher than 200.00 from employeeStream using anyMatch()
     */
    @Test
    void stream_anyMatch() {

        Boolean anySalaryHigherThan200 = null; //Modify this line
        assertThat(anySalaryHigherThan200).isFalse();
    }

    /**
     * Group employees by department using collect(Collectors.groupingBy())
     */
    @Test
    void stream_groupBy() {

        Map<String, List<Employee>> employeesByDepartment = null; //Modify this line
        assertThat(employeesByDepartment).flatExtracting("sales").extracting("name").containsExactly("Steve", "James");
        assertThat(employeesByDepartment).flatExtracting("technology").extracting("name").containsExactly("Craig", "Robert");
    }

    /**
     * Get salary sum by department using groupingBy and summingDouble
     */
    @Test
    void stream_groupBy_sum(){
        Map<String, Double> sumSalaryByDepartment = null;

        assertThat(sumSalaryByDepartment).flatExtracting("sales").containsExactly(385.00);
        assertThat(sumSalaryByDepartment).flatExtracting("technology").containsExactly(353.00);
    }

    /**
     * Find max salaries for each department using groupingBy() and maxBy()
     */
    @Test
    void stream_groupBy_max() {

        Map<String, Double> maxSalaryByDepartment = null; //Modify this line
        assertThat(maxSalaryByDepartment).flatExtracting("sales").containsExactly(200.00);
        assertThat(maxSalaryByDepartment).flatExtracting("technology").containsExactly(183.00);
    }

    /**
     * Find min and max salaries of all employees using teeing() minBy() and maxBy()
     * I can be done with just one iteration
     */
    @Test
    void stream_min_max() {
        record MinMax(Double min, Double max) {
        }

        MinMax minMax = null; //Modify this line
        assertThat(minMax).extracting("min", "max").containsExactly(170.00, 200.00);
    }

    record Employee(String name, Double salary, String department) {
    }
}