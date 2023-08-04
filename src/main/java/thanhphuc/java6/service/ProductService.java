package thanhphuc.java6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import thanhphuc.java6.entity.Product;

public interface ProductService {

	Page<Product> findAllProduct( Optional<String> sort, Optional<Integer> p);
	
	Product findByIdProduct(String idProduct);
	
	Page<Product> findProductByIdCategory(int idCategory, Optional<Integer> p);
	
	List<Product> findProductByIdCategoryAndIdBrand(int idCategory,int idBrand);
	
	List<Product> findAll();
	
	public Product create(Product product) ;

	public Product update(Product product) ;

	public void delete(String id) ;
}
