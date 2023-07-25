package thanhphuc.java6.service;

import java.util.List;

import thanhphuc.java6.entity.Brand;

public interface BrandService {

	List<Brand> findBrandByIdCategory(int idCategory);
	
}
