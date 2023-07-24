package thanhphuc.java6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import thanhphuc.java6.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

	
	
}
