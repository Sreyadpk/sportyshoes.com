package com.phase3.project.Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phase3.project.Entity.Admin;
import com.phase3.project.Entity.Product;
import com.phase3.project.Entity.Productorder;
import com.phase3.project.Entity.User;
import com.phase3.project.Service.AdminService;
import com.phase3.project.Service.OrderService;
import com.phase3.project.Service.ProductService;
import com.phase3.project.Service.UserService;

@Controller
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;

	@GetMapping
	public String adminLogin(Model model)
	{
		Admin admin=new Admin();
		model.addAttribute("admin", admin);
		return "admin";
	}
	
	@PostMapping
	public String adminLoginProcess(@Valid @ModelAttribute Admin admin, BindingResult result, Model model)
	{
		if (result.hasErrors()) {
			return "admin";
		}
		Admin ad=adminService.findById(1);
		if(ad.getUsername().matches(admin.getUsername()) && ad.getPassword().matches(admin.getPassword())){
			return "admin-main";
		}
		return "admin-err";
	}
	
	@GetMapping("/ChangePassword")
	public String changePasswordView(Model model) {
		Admin admin=adminService.findById(1);
		model.addAttribute("admin", admin);
        return "changepassword";
	}
	
	@PostMapping("/ChangePassword")
	public String changePassword(@ModelAttribute Admin admin, Model model) {
		Admin ad=adminService.findById(1);
		ad.setPassword(admin.getPassword());
		adminService.save(ad);
        return "redirect:/Admin";
	}
	
	@GetMapping("/AddNewProduct")
	public String addNewProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "Addproduct";
	}

	@PostMapping("/AddNewProduct")
	public String insertProduct(@ModelAttribute Product product,Model model) {
        
		productService.save(product);
		List<Product> listProducts = productService.listAll();
		model.addAttribute("product", listProducts);
		return "view-product";
	}
	
	@GetMapping("/ListProduct")
	public String listProduct(Model model) {
        
		List<Product> listProducts = productService.listAll();
		model.addAttribute("product", listProducts);
		return "view-product";
	}
	
	@GetMapping("/GoBack")
	public String goBack(Model model)
	{
		return "admin-main";
	}
	
	@GetMapping("/editProduct/{productid}")
	public String updateProduct(@PathVariable(name = "productid") int id,Model model) {
		Product product = productService.getById(id);
	    model.addAttribute("product", product);
	    return "edit-product";
	}
	
	@PostMapping("/editProduct/{productid}")
	public String updateProcessProduct(@ModelAttribute Product product) {
		productService.update(product);
	    return "redirect:/Admin/ListProduct";
	}
	
	@GetMapping("/Signedusers")
	public String listofSignedUsers(@Param("keyword") String keyword,Model model) {
		List<User> users=userService.getByUsernameLike(keyword);
		model.addAttribute("users", users);
		model.addAttribute("keyword", keyword);
		return "listofusers";
	} 
	
	@GetMapping("/purchaseReport")
	public String purchaseReport(@Param("keyword") String keyword,Model model) throws ParseException {
		if(keyword!=null) {
			if(keyword.contains("2021")) {
				DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				Date dt=df.parse(keyword);
			    Productorder temporder=new Productorder();
			    temporder.setOrderdate(dt);
			    System.out.println("temp orderdate" + temporder.getOrderdate());
				List<Productorder> orders=orderService.getByOrderdatelike(temporder.getOrderdate());
				model.addAttribute("orders", orders);
				model.addAttribute("keyword", keyword);
				return "purchasereport";
			}else {
				List<Productorder> orders=orderService.getByProductBrandlike(keyword);
				model.addAttribute("orders", orders);
				model.addAttribute("keyword", keyword);
				return "purchasereport";
			}
			
		}
		List<Productorder> orders=orderService.getAllOrders();
		model.addAttribute("orders", orders);
		model.addAttribute("keyword", keyword);
		return "purchasereport";
	}
	
}
