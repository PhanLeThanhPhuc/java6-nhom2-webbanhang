package thanhphuc.java6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import thanhphuc.java6.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>{

	@Query("SELECT DISTINCT ar.account FROM Authorities ar WHERE ar.role.id IN ('DIRE', 'STAF')")
	List<Account> getAdministrators();
	
}
