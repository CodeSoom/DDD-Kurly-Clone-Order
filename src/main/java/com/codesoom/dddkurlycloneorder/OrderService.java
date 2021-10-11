package com.codesoom.dddkurlycloneorder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Long createOrder(OrderModel orderModel) {
        Order order = Order.builder()
                .productId(orderModel.getProductId()).createDateTime(LocalDateTime.now())
                .build();

        return orderRepository.save(order).getId();
    }
}
