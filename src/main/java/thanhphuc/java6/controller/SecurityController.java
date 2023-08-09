package thanhphuc.java6.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import thanhphuc.java6.service.AccountService;

@Controller
public class SecurityController {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("/login-form")
	public String loginForm() {
		return "layout/login";
	}
	
	@GetMapping("/login-success")
	public String loginSuccess() {
		return "redirect:/shop";
	}
	
	@RequestMapping("/logoff-success")
	public String logoffSuccess() {
		return "layout/login";
	}
	
	@RequestMapping("/oauth2/login/success")
	public String success(OAuth2AuthenticationToken oauth2){
		accountService.loginFromOAuth2(oauth2);
		return "forward:/auth/login/success";
	}
	
	@CrossOrigin("*")
	@ResponseBody
	@RequestMapping("/rest/security/authentication")
	public Object getAuthentication(HttpSession session) {
		return session.getAttribute("authentication");
	}
	
}
