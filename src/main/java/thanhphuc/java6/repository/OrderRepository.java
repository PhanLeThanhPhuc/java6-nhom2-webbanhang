package thanhphuc.java6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import thanhphuc.java6.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	@Query("SELECT o FROM Order o WHERE o.account.username=?1")
	List<Order> findByUsername(String username);
	
	@Query("select MAX(o.id) +1 from Order o")
	Long selectMaxIdOrder();
}
