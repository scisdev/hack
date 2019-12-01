package com.hawken.dbcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hawken.db.Order;
import com.hawken.db.Product;
import com.hawken.db.User;
import com.hawken.db.services.OrderServiceImpl;
import com.hawken.db.services.ProductServiceImpl;
import com.hawken.db.services.UserServiceImpl;

@RestController
public class DBController {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private OrderServiceImpl orderService;
	
	@Autowired
	private ProductServiceImpl productService;
	
	
	@GetMapping("/api/db/users/get/{id}")
	public User getUser(@PathVariable Integer id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("/api/db/users/add")
	public String saveUser(
			@RequestParam String fn,
			@RequestParam String ln,
			@RequestParam String un,
			@RequestParam String email
		) {
		User user = new User();
		user.setFirstName(fn);
		user.setLastName(ln);
		user.setUserName(un);
		user.setEmail(email);
		userService.saveUser(user);
		return "Saved";
	}
	
	@GetMapping("/api/db/orders/get/{id}")
	public Order getOrder(@PathVariable Integer id) {
		return orderService.getOrderById(id);
	}
	
	@PostMapping("/api/db/orders/add")
	public String createOrder(@RequestParam Integer withUser) {
		Order order = new Order();
		order.setUser(userService.getUserById(withUser));
		orderService.createOrder(order);
		return "Success";
	}
	
	@PostMapping("/api/db/prods/add")
	public String createProd(@RequestParam String name,
							@RequestParam Integer withOrder) {
		Product prod = new Product();
		prod.setName(name);
		Order order = orderService.getOrderById(withOrder);
		order.getProducts().add(prod);
		orderService.createOrder(order);
		prod.getOrders().add(order);
		productService.createProduct(prod);
		return "Success";
	}
	
	
	@GetMapping("/api/db/prods/get/{id}")
	public Product getProd(@PathVariable Integer id) {
		return productService.findProdById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
