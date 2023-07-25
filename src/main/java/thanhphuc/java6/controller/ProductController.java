package thanhphuc.java6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thanhphuc.java6.service.BrandService;
import thanhphuc.java6.service.CategoryService;
import thanhphuc.java6.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	BrandService brandService;
	
	
	@GetMapping("/shop")
	public String viewProduct(Model model) {
		model.addAttribute("product", productService.findAllProduct());
		model.addAttribute("category", categoryService.findAllCategory());
		return "layout/shop";
	}
	
	@GetMapping("/shop-details")
	public String viewProductDetails(@RequestParam("idProduct") String idProduct, Model model) {
		model.addAttribute("productDetail", productService.findByIdProduct(idProduct));
		return "layout/product_details";
	}
	
	@GetMapping("/shop-category")
	public String viewProductCategory(Model model, @RequestParam("idCategory") int idCategory) {
		model.addAttribute("product", productService.findProductByIdCategory(idCategory));
		model.addAttribute("brand", brandService.findBrandByIdCategory(idCategory));
		return "layout/shopcategory";
	}
	
}
