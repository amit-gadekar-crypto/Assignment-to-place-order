package com.shopmart.service.order.repository;

import com.shopmart.service.order.model.PaymentDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailsRepository extends CrudRepository<PaymentDetails,Integer> {

}
