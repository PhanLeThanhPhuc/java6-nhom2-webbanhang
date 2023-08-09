package thanhphuc.java6.controller;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//
//import thanhphuc.java6.config.VNPayService;

//@Controller
public class CheckOutController {
	
//	@Autowired
//	private VNPayService vnPayService;
	
//	@GetMapping("/payment")
//	public String payment(@RequestParam("payment") int payment, 
//			HttpServletRequest request, 
//			@RequestParam("total") int total
//			,@RequestParam("id") int idOrder) {
//		String des = "testorder";
//		String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
//		String vnpayUrl = vnPayService.createOrder(total, des, baseUrl);
//		
//		if(payment == 1) {
//			return "redirect:/order-success?idOrder="+idOrder;
//		}else {
//			System.out.println(vnpayUrl);
//			 return "redirect:" + vnpayUrl;
//		}
//	}
	
}
