package thanhphuc.java6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thanhphuc.java6.entity.Brand;
import thanhphuc.java6.service.BrandService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/brand")
public class BrandRestController {
	@Autowired
	BrandService brandService;
	
	@GetMapping
	public List<Brand> getAllBrand(){
		return brandService.findAllBrand();
	}
}
