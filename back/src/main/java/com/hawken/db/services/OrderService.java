package com.hawken.db.services;

import java.util.ArrayList;
import com.hawken.db.Order;

public interface OrderService {
	public abstract void createOrder(Order order);
	public abstract void updateOrder(Order order);
	public abstract void deleteOrder(Integer id);
	public abstract ArrayList<Order> getAllOrders();
	public abstract Order getOrderById(Integer id);
}
