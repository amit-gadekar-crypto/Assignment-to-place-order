package com.shopmart.service.order.service;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shopmart.service.order.dao.OrderDao;
import com.shopmart.service.order.handler.InvalidPaymentDetails;
import com.shopmart.service.order.handler.OrderNotFoundException;
import com.shopmart.service.order.model.Order;
import com.shopmart.service.order.model.OrderResponse;

@Service
public class OrderService {

	Logger logger =  LogManager.getLogger(OrderService.class);
	
	private PaymentService paymentService;
	private OrderDao orderDao;

	public OrderService(PaymentService paymentService, OrderDao orderDao) {
		this.paymentService = paymentService;
		this.orderDao = orderDao;
	}

	public OrderResponse processOrder(Order order) throws InvalidPaymentDetails {
		if (paymentService.validatePaymentDetails(order)) {
			order.setDate(new Date());
			Order saveOrder = orderDao.saveOrder(order);
			logger.info(" Order Placed Successfully transaction id  :: "+saveOrder.getTransId());
			return new OrderResponse("Order Placed Successfully",saveOrder.getTransId());
		}
		throw new InvalidPaymentDetails("Declined - Invalid Card Id");
	}

	public Order getOrderDetails(String transId) throws OrderNotFoundException {
		logger.info(" Fetching details of transaction id  :: "+transId);
		return orderDao.getOrder(transId);
	}
}

