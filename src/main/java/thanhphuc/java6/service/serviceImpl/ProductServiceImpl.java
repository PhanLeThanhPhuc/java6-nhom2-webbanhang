package thanhphuc.java6.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thanhphuc.java6.entity.Product;
import thanhphuc.java6.repository.ProductRepository;
import thanhphuc.java6.service.ProductService;

@Service
public class ProductServiceImpl  implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> findAllProduct(){
		return productRepository.findAll();
	}

	@Override
	public Product findByIdProduct(String idProduct) {
		return productRepository.findById(idProduct).get();
	}
	
}
