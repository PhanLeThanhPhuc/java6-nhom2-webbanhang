package thanhphuc.java6.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thanhphuc.java6.entity.Authority;
import thanhphuc.java6.repository.AccountRepository;
import thanhphuc.java6.repository.AuthoritiesRepository;
import thanhphuc.java6.service.AuthorityService;
@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired
	AuthoritiesRepository dao;
	@Autowired
	AccountRepository accountDAO;

	public List<Authority> findAll() {
		return dao.findAll();
	}

	public Authority create(Authority auth) {
		return dao.save(auth);
	}

	public void delete(Integer id) {
		dao.deleteById(id);
	}

//	public List<Authority> findAuthoritiesOfAdministrators() {
//		List<Account> accounts = accountDAO.getAdministrators();
//		return dao.authoritiesOf(accounts);
//	}

}
