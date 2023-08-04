package thanhphuc.java6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@GetMapping("/admin/product")
	public String viewProductAdmin() {
		System.out.println("test");
		return "redirect:/admin/index-admin.html";
	}
}
