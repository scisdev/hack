package com.hawken.db.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hawken.db.repos.OrderRepository;
import com.hawken.db.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void createOrder(Order order) {
		orderRepository.save(order);
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Order> getAllOrders() {
		ArrayList<Order> res = new ArrayList<>();
		for (Order o : orderRepository.findAll()) {
			res.add(o);
		}
		return res;
	}
	
	@Override
	public Order getOrderById(Integer id) {
		Optional<Order> u = orderRepository.findById(id);
		if (u.isPresent()) return u.get();
		else return null;
	}
}
