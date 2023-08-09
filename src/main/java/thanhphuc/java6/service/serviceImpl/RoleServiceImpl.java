package thanhphuc.java6.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thanhphuc.java6.entity.Role;
import thanhphuc.java6.repository.RoleRepository;
import thanhphuc.java6.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleRepository dao;
	@Override
	public List<Role> findAll() {
		return dao.findAll();
	}

}
