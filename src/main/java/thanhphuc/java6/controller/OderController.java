package thanhphuc.java6.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import thanhphuc.java6.service.OrderService;

@Controller
public class OderController {
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/checkout")
	public String checkout() {
		return "layout/checkout";
	}

	@RequestMapping("/order/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("order", orderService.findById(id));
		return "order/detail";
	}
	
	@RequestMapping("/order/list")
	public String detail(Model model, HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("orders", orderService.findByUsername(username));
		return "order/list";
	}

	
}
