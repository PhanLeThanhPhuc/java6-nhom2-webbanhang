package thanhphuc.java6.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import thanhphuc.java6.entity.Product;
import thanhphuc.java6.repository.ProductRepository;
import thanhphuc.java6.service.ProductService;

@Service
public class ProductServiceImpl  implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	public Page<Product> findAllProduct( Optional<String> s,Optional<Integer> p){
		if(s.isPresent() && s.get().equals("desc")) {
			Sort sort = Sort.by(Direction.DESC,"price");
			Pageable pageable = PageRequest.of(p.orElse(0),8, sort);
			return productRepository.findAll(pageable);
		}else {
			Sort sort = Sort.by(Direction.ASC,"price");
			Pageable pageable = PageRequest.of(p.orElse(0),8, sort);
			return productRepository.findAll(pageable);
		}
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

	@Override
	public List<Product> findProductByIdCategoryAndIdBrand(int idCategory, int idBrand) {
		return productRepository.findProductByIdCategoryAndIdBrand(idCategory, idBrand);
	}
	
}
