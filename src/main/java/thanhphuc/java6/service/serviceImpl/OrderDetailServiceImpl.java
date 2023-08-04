package thanhphuc.java6.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thanhphuc.java6.dto.OrderDetailDTO;
import thanhphuc.java6.repository.OrderDetailRepository;
import thanhphuc.java6.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Override
	public List<OrderDetailDTO> findOrderDetailDTO(int idOrder) {
		
		System.out.println(orderDetailRepository.findOrderDetailDTO(idOrder));
		
		return orderDetailRepository.findOrderDetailDTO(idOrder);
	}

}
