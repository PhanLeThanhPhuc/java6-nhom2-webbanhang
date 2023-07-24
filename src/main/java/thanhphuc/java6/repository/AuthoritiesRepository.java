package thanhphuc.java6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thanhphuc.java6.entity.Authorities;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, Integer> {

}
