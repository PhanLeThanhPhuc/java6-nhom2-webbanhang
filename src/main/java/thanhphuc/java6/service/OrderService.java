package thanhphuc.java6.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import thanhphuc.java6.entity.Order;

public interface OrderService {
	
	public Order create(JsonNode orderData, String userName);

	public Order findById(int id);

	public List<Order> findByUsername(String username);

	List<Order> findOrderByUserId(String username);
	
}
