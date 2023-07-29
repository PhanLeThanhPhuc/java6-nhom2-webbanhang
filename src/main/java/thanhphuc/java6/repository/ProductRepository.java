package thanhphuc.java6.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import thanhphuc.java6.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

	@Query("select p from Product p where p.category.id=:idCategory")
	Page<Product> findProductByIdCategory(@Param("idCategory") int idCategory, Pageable pageable);
	
	@Query("select p from Product p where p.category.id=:idCategory and p.brand.id=:idBrand")
	List<Product> findProductByIdCategoryAndIdBrand(@Param("idCategory") int idCategory, @Param("idBrand") int idBrand);
}
