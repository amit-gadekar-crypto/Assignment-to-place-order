package com.shopmart.service.order.handler;

public class InvalidPaymentDetails extends Exception {
    public InvalidPaymentDetails(String message) {
        super(message);
    }
}
