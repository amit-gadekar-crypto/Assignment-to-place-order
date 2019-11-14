package com.shopmart.service.order.dao;

import com.shopmart.service.order.model.PaymentDetails;
import com.shopmart.service.order.repository.PaymentDetailsRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PaymentDao {

    private PaymentDetailsRepository paymentDetailsRepository;

    public PaymentDao(PaymentDetailsRepository paymentDetailsRepository) {
        this.paymentDetailsRepository = paymentDetailsRepository;
    }

    public Optional<PaymentDetails> getCardDetails(Integer cardId) {
        return paymentDetailsRepository.findById(cardId);
    }

    public PaymentDetails saveCardDetails(PaymentDetails paymentDetails) {
        return paymentDetailsRepository.save(paymentDetails);
    }

}
