package thanhphuc.java6.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import thanhphuc.java6.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

//	@Query("select b from Brand b JOIN product p on p.brand.id = b.id where p.id=:idProduct and p.category.id=:idCategory")
//	List<Brand> findBrandByIdProductAndIdCategory(@Param("idProduct") String idProduct, @Param("idCategory") int idCategory);
	
	@Query("select b from Brand b JOIN Product p on p.brand.id = b.id where p.category.id=:idCategory")
	List<Brand> findBrandByIdCategory(@Param("idCategory") int idCategory);
}
