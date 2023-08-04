package thanhphuc.java6.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thanhphuc.java6.config.VNPayService;
import thanhphuc.java6.service.OrderDetailService;
import thanhphuc.java6.service.OrderService;

@Controller
public class OderController {
	
	@Autowired
	private VNPayService vnPayService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderDetailService orderDetailService;
	
	int idOrder = 0;
	
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

	 @GetMapping("/vnpay-payment")
	    public String GetMapping(HttpServletRequest request, Model model){
	        int paymentStatus =vnPayService.orderReturn(request);
//	        return paymentStatus == 1 ? "ordersuccess" : "orderfail";
	        return "redirect:/order-success?idOrder="+idOrder;
	    }
	 
	 @GetMapping("/order-success")
	 public String viewOrderSuccess(@RequestParam("idOrder") int idOrder, Model model) {
		 model.addAttribute("order", orderService.findById(idOrder));
		 model.addAttribute("orderDetail", orderDetailService.findOrderDetailDTO(idOrder));
		 return "/layout/ordersucess";
	 }
	 
		
		@GetMapping("/payment")
		public String payment(@RequestParam("payment") int payment, 
				HttpServletRequest request, 
				@RequestParam("total") int total
				,@RequestParam("id") int idOrder) {
			this.idOrder = idOrder;
			String des = "testorder";
			String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
			String vnpayUrl = vnPayService.createOrder(total, des, baseUrl);
			
			if(payment == 1) {
				return "redirect:/order-success?idOrder="+idOrder;
			}else {
				System.out.println(vnpayUrl);
				 return "redirect:" + vnpayUrl;
			}
		}
	
}
