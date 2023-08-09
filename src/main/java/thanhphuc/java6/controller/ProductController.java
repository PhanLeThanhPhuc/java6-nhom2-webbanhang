package thanhphuc.java6.controller;

import java.util.Optional;

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
	public String viewProduct(Model model,@RequestParam("sortby") Optional<String> s, @RequestParam("p") Optional<Integer> p ) {
		model.addAttribute("product", productService.findAllProduct(s,p));
		model.addAttribute("s", s.isPresent() ? s.get() : "asc");
		model.addAttribute("category", categoryService.findAllCategory());
		return "layout/shop";
	}
	
	@GetMapping("/shop-details")
	public String viewProductDetails(@RequestParam("idProduct") String idProduct, Model model) {
		model.addAttribute("productDetail", productService.findByIdProduct(idProduct));
		return "layout/product_details";
	}
	

	@GetMapping("/shop-category")
	public String viewProductCategory(Model model, @RequestParam("idCategory") int idCategory, @RequestParam("p") Optional<Integer> p) {
		model.addAttribute("product", productService.findProductByIdCategory(idCategory,p));
		model.addAttribute("brand", brandService.findBrandByIdCategory(idCategory));
		model.addAttribute("idCategory", idCategory);
		return "layout/shopcategory";
	}
	
	@GetMapping("/cart")
	public String viewcart(Model model, @RequestParam("p") Optional<Integer> p) {
//		model.addAttribute("productDetail", productService.findAllProduct(p));
		return "layout/cart";
	}
	
	@GetMapping("/shop-brand")
	public String viewProductBrand(Model model, @RequestParam("idCategory") int idCategory, @RequestParam("idBrand") int idBrand) {
		model.addAttribute("product", productService.findProductByIdCategoryAndIdBrand(idCategory, idBrand));
		return "layout/shopbrand";
	}

//	@GetMapping("/admin/product")
//	public String viewProductAdmin() {
//		System.out.println("test");
//		return "redirect:/admin/index-admin.html";
//	}

	
	
}
