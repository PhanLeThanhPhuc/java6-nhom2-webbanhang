package thanhphuc.java6.service;

import java.util.List;

import thanhphuc.java6.dto.OrderDetailDTO;

public interface OrderDetailService {

	List<OrderDetailDTO> findOrderDetailDTO(int idOrder);
	
}
