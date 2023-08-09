
package thanhphuc.java6.service;

import java.util.List;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import thanhphuc.java6.entity.Account;

public interface AccountService {

	public List<Account> getAdministrators();

	void loginFromOAuth2(OAuth2AuthenticationToken oauth2);

	public List<Account> findAll();

	public Account findById(String username);

}
