package com.shopmart.service.order.model;

public class OrderResponse {
    private String message;
    private String transactionId;

    public OrderResponse() { }

    public OrderResponse(String message, String transactionId) {
        this.message = message;
        this.transactionId = transactionId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "message='" + message + '\'' +
                ", transactionId=" + transactionId +
                '}';
    }
}
