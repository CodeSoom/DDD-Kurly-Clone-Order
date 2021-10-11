package com.codesoom.dddkurlycloneorder;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {

    private static final String PRODUCT_ID = "1";

    @Test
    public void createOrder() {
        Order order = Order.builder()
                .productId(PRODUCT_ID).createDateTime(LocalDateTime.now())
                .build();

        assertThat(order.getProductId()).isEqualTo(PRODUCT_ID);
    }
}
