package com.shopmart.service.order.service;

import com.shopmart.service.order.dao.PaymentDao;
import com.shopmart.service.order.model.PaymentDetails;
import com.shopmart.service.order.model.Order;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    private PaymentDao paymentDao;

    public PaymentService(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    public Boolean validatePaymentDetails(Order order) {
        Optional<PaymentDetails> cardDetails = paymentDao.getCardDetails(order.getCardId());
        if (cardDetails.isPresent())
            return true;
        else
            return false;
    }
}
