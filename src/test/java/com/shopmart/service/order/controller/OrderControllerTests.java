package com.shopmart.service.order.controller;

import com.shopmart.service.order.AbstractTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.shopmart.service.order.model.OrderResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class OrderControllerTests extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    public static String transId="";

    @Test
    public void createOrder() throws Exception {
        String uri = "/order";

        String inputJson = "{\n" +
                "          \"cardId\": 1001,\n" +
                "          \"amount\": 300,\n" +
                "          \"products\": [\n" +
                "            {\n" +
                "              \"name\": \"Product1\",\n" +
                "              \"price\": 10\n" +
                "            },\n" +
                "            {\n" +
                "              \"name\": \"Product2\",\n" +
                "              \"price\": 90\n" +
                "            }\n" +
                "          ],\n" +
                "          \"address\": {\n" +
                "            \"city\": \"pune\",\n" +
                "            \"emailid\": \"amit@gmail.com\",\n" +
                "            \"mobilenumber\": 9145457980,\n" +
                "            \"name\": \"Amit Gadekar\",\n" +
                "            \"zip\": \"411035\"\n" +
                "          }\n" +
                "        }";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();

        String response = "{\"message\":\"Order Placed Successfully\",\"transactionId\":\"20191100011\"}";
        assertTrue(content.contains("Order Placed Successfully"));

        if (content.contains("Order Placed Successfully")) {
            OrderResponse orderResponse = mapFromJson(content, OrderResponse.class);
            transId = orderResponse.getTransactionId();
        }
    }

    @Test
    public void createInvalidOrder() throws Exception {
        String uri = "/order";

        String inputJson = "{\n" +
                "          \"cardId\": 100,\n" +
                "          \"amount\": 300,\n" +
                "          \"products\": [\n" +
                "            {\n" +
                "              \"name\": \"Product1\",\n" +
                "              \"price\": 10\n" +
                "            },\n" +
                "            {\n" +
                "              \"name\": \"Product2\",\n" +
                "              \"price\": 90\n" +
                "            }\n" +
                "          ],\n" +
                "          \"address\": {\n" +
                "            \"city\": \"pune\",\n" +
                "            \"emailid\": \"amit@gmail.com\",\n" +
                "            \"mobilenumber\": 9145457980,\n" +
                "            \"name\": \"Amit Gadekar\",\n" +
                "            \"zip\": \"411035\"\n" +
                "          }\n" +
                "        }";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
        String content = mvcResult.getResponse().getContentAsString();

    }

    @Test
    public void getOrderStatus() throws Exception {
        String uri = "/order/"+transId;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
    }

    @Test
    public void getInvalidOrderStatus() throws Exception {
        String uri = "/order/123";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
        String content = mvcResult.getResponse().getContentAsString();
    }
}
