package thanhphuc.java6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import thanhphuc.java6.entity.Product;
import thanhphuc.java6.service.ProductService;

@CrossOrigin("*")
@RestController
public class ProductRestController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/rest/products/{id}")
	public Product getOne(@PathVariable("id") String id) {
		return productService.findByIdProduct(id);
	}
	
}
