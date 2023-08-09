package thanhphuc.java6.service;

import java.util.List;

import thanhphuc.java6.entity.Account;


public interface AccountService {
	public List<Account> findAll() ;
	public Account findById(String username) ;
	public List<Account> getAdministrators() ;
}
