package com.merkle.course.streams;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ExtraBonusTest {

    record Product(String name, Double price){}
    record OrderLine(String productName, Integer quantity, Double amount){}
    record Order(List<OrderLine> orderLines, Integer totalQuantity, Double totalAmount){}

    /**
     * Implement your own stream collector, which collect all products and build an Order object with
     * OrderLines ordered by product name.
     * It should work with parallel Stream
     */
    @Test
    void implement_collector() throws IOException {
        List<Product> productList = new ObjectMapper().readValue(this.getClass().getClassLoader().getResource("products.json"), new TypeReference<>() {});

        Collector<Product, Map<String, OrderLine>, Order> myProductCollector = new Collector<>() {
            @Override
            public Supplier<Map<String, OrderLine>> supplier() {
                //Implement me
                return null;
            }

            @Override
            public BiConsumer<Map<String,OrderLine>, Product> accumulator() {
                //Implement me
                return null;
            }

            @Override
            public BinaryOperator<Map<String, OrderLine>> combiner() {
                //Implement me
                return null;
            }

            @Override
            public Function<Map<String, OrderLine>, Order> finisher() {
                //Implement me
                return null;
            }

            @Override
            public Set<Characteristics> characteristics() {
                //DD NOT change that
                return Set.of(Characteristics.CONCURRENT);
            }
        };

        Order order = productList.parallelStream().collect(myProductCollector);

        assertThat(order.totalQuantity()).isEqualTo(44);
        assertThat(order.totalAmount()).isEqualTo(629.06);
        assertThat(order.orderLines()).hasSize(13);
        assertThat(order.orderLines()).containsExactly(
                new OrderLine("Artisanal Sourdough Bread", 2, 11.98),
                new OrderLine("Bamboo Cutting Board", 1, 12.99),
                new OrderLine("Essential Oil Diffuser", 2, 39.98),
                new OrderLine("Fair Trade Coffee Beans", 4, 37.96),
                new OrderLine("Handcrafted Ceramic Mug", 4, 35.96),
                new OrderLine("Handcrafted Soap Bar", 4, 31.96),
                new OrderLine("Handwoven Throw Pillow", 6, 149.94),
                new OrderLine("Organic Avocado", 2, 7.98),
                new OrderLine("Organic Cotton T-Shirt", 8, 143.92),
                new OrderLine("Organic Kale", 4, 11.96),
                new OrderLine("Recycled Glass Vase", 4, 59.96),
                new OrderLine("Sustainable Bamboo Toothbrush", 1, 4.49),
                new OrderLine("Vintage Leather Wallet", 2, 79.98)
        );
    }
}
