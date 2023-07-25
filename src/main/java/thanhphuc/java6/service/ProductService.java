package thanhphuc.java6.service;

import java.util.List;

import thanhphuc.java6.entity.Product;

public interface ProductService {

	List<Product> findAllProduct();
	
	Product findByIdProduct(String idProduct);
	
	List<Product> findProductByIdCategory(int idCategory);
}
