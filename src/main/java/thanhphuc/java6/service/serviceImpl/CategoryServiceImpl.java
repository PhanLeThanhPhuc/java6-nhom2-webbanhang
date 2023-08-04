package thanhphuc.java6.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thanhphuc.java6.entity.Category;
import thanhphuc.java6.repository.CategoryRepository;
import thanhphuc.java6.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAllCategory() {
		return categoryRepository.findAll();
	}
	
	

}
