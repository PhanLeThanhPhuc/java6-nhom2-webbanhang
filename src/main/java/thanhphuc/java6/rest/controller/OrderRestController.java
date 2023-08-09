package thanhphuc.java6.rest.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import thanhphuc.java6.service.OrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {

	@Autowired
	OrderService orderService;

//	@Autowired
//	private VNPayService vnPayService;

	@PostMapping
	public ResponseEntity<?> purchase(@RequestBody JsonNode orderData, HttpServletRequest request,Authentication authentication) {
		HashMap<String, Object> result = new HashMap<>();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		try {
			orderService.create(orderData,userDetails.getUsername());
			result.put("Success", true);
			result.put("Message", "Success to call API saveRole");
			result.put("data", orderService.create(orderData,userDetails.getUsername()));
		} catch (Exception e) {
			result.put("Success", false);
			result.put("Message", "Fail When Call API saveRole");
			result.put("data", null);
		}
		return ResponseEntity.ok(result);
	}

}
