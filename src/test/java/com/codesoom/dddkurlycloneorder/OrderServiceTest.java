package com.codesoom.dddkurlycloneorder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderServiceTest {

    private static final String PRODUCT_ID = "1";
    private static final Long ORDER_ID = 1L;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Test
    void createOrderTest() {
        OrderModel orderModel = OrderModel.builder()
                .productId(PRODUCT_ID)
                .build();
        Long orderId = orderService.createOrder(orderModel);
        assertEquals(ORDER_ID, orderId);
    }

}
