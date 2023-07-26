package thanhphuc.java6.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import thanhphuc.java6.entity.Product;
import thanhphuc.java6.repository.ProductRepository;
import thanhphuc.java6.service.ProductService;

@Service
public class ProductServiceImpl  implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	public Page<Product> findAllProduct(Optional<Integer> p){
		Pageable pageable = PageRequest.of(p.orElse(0),8);
		return productRepository.findAll(pageable);
	}

	@Override
	public Product findByIdProduct(String idProduct) {
		return productRepository.findById(idProduct).get();
	}

	@Override
	public Page<Product> findProductByIdCategory(int idCategory, Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0),8);
		return productRepository.findProductByIdCategory(idCategory,pageable);
	}
	
}
