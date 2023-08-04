package thanhphuc.java6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
 
	@RequestMapping("/user")
	public String viewUser()
	{
		return "layout/user_info";
	}
	
	@RequestMapping("/userOrder")
	public String viewUserOrder()
	{
		return "layout/user_order";
	}
	@RequestMapping("/userOrderDetail")
	public String viewUserOrderDetail()
	{
		return "layout/user_orderDetail";
	}
}
