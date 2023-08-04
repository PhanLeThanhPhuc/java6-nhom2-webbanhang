package thanhphuc.java6.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import thanhphuc.java6.entity.Order;
import thanhphuc.java6.entity.OrderDetail;
import thanhphuc.java6.repository.OrderDetailRepository;
import thanhphuc.java6.repository.OrderRepository;
import thanhphuc.java6.service.OrderService;

@Service
public class OderServiceImpl implements OrderService {

	@Autowired
	OrderRepository dao;

	@Autowired
	OrderDetailRepository ddao;

	@Override
	public Order create(JsonNode orderData) {
		
		ObjectMapper mapper = new ObjectMapper();

		Order order = mapper.convertValue(orderData, Order.class);
		int id = (int) (dao.selectMaxIdOrder() == null ? 1 : dao.selectMaxIdOrder());
		order.setId(id);
		dao.save(order);
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
				.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		ddao.saveAll(details);
		
		return order;


	}

	@Override
	public Order findById(int id) {
		return dao.findById(id).get();

	}

	@Override
	public List<Order> findByUsername(String username) {
		return dao.findByUsername(username);

	}

}
