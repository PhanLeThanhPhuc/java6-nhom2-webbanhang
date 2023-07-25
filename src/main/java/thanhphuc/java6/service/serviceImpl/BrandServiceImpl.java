package thanhphuc.java6.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thanhphuc.java6.entity.Brand;
import thanhphuc.java6.repository.BrandRepository;
import thanhphuc.java6.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	BrandRepository brandRepository;

	@Override
	public List<Brand> findBrandByIdCategory(int idCategory) {
		return brandRepository.findBrandByIdCategory(idCategory);
	}
	
}
