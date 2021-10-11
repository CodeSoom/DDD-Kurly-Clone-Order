package com.codesoom.dddkurlycloneorder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(OrderController.class)
public class OrderControllerTest {
    private static final String PRODUCT_ID = "1";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("주문 생성")
    public void createOrderTest() throws Exception {
        OrderModel orderModel = OrderModel.builder()
                .productId(PRODUCT_ID)
                .build();

        mockMvc.perform(
                post("/orders").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orderModel)))
                .andExpect(status().isCreated())
        ;
    }
}
