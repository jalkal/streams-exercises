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
     */
    @Test
    void implement_collector() throws IOException {
        List<Product> productList = new ObjectMapper().readValue(this.getClass().getClassLoader().getResource("products.json"), new TypeReference<>() {});

        Collector<Product, Map<String, OrderLine>, Order> myProductCollector = new Collector<>() {
            @Override
            public Supplier<Map<String, OrderLine>> supplier() {
                return HashMap::new;
            }

            @Override
            public BiConsumer<Map<String,OrderLine>, Product> accumulator() {
                return (orderLines, product)-> {
                    orderLines.computeIfPresent(product.name(), (k, ol)-> new OrderLine(k, ol.quantity() + 1, ol.amount() + product.price()));
                    orderLines.computeIfAbsent(product.name(), (k)-> new OrderLine(product.name(), 1, product.price()));
                };
            }

            @Override
            public BinaryOperator<Map<String, OrderLine>> combiner() {
                return (map1, map2) -> {
                    map1.forEach((key, orderLine) -> map2.merge(key, orderLine,
                            (orderLine1, orderLine2) -> new OrderLine(key, orderLine1.quantity() + orderLine2.quantity(), orderLine1.amount() + orderLine2.amount())));
                    return map1;
                };
            }

            @Override
            public Function<Map<String, OrderLine>, Order> finisher() {
                return (orderLine) -> orderLine.values().stream().collect(
                        Collectors.teeing(Collectors.summingInt(OrderLine::quantity),
                                Collectors.summingDouble(OrderLine::amount),
                                (quantity, amount) -> new Order(orderLine.values().stream().sorted(Comparator.comparing(OrderLine::productName)).toList(), quantity, amount)));
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Set.of(Characteristics.UNORDERED);
            }
        };

        Order order = productList.stream().collect(myProductCollector);

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
