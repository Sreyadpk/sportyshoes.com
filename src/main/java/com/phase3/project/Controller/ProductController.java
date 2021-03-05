package com.phase3.project.Controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phase3.project.Entity.Cartitems;
import com.phase3.project.Entity.Product;
import com.phase3.project.Entity.Productorder;
import com.phase3.project.Entity.User;
import com.phase3.project.Service.OrderService;
import com.phase3.project.Service.ProductService;
import com.phase3.project.Service.ShoppingCartService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private OrderService orderService;
	
	
	@GetMapping("/all")
	public String browseProducts(Model model)
	{
		List<Product> listProducts = productService.listAll();
		model.addAttribute("product", listProducts);
		return "product_all";
	}
	
	@GetMapping("/{productid}")
	public String browseProductById(@PathVariable(name = "productid") int id,Model model)
	{
		Cartitems cartitems=new Cartitems();
		Product product=productService.getById(id);
		model.addAttribute("product", product);
		model.addAttribute("cartitems",cartitems);
		return "view-productid";
	}
	
	@PostMapping("/{productid}")
	public String addProductToCart(@ModelAttribute Product product,@ModelAttribute Cartitems cartitems,Model model,HttpSession session)
	{
		User us=(User) session.getAttribute("user");
	    Cartitems ca=shoppingCartService.getByUserAndProduct(us, product);
	    if(ca!=null) {
	    	ca.setQuantity(ca.getQuantity() + cartitems.getQuantity());
	    	shoppingCartService.save(ca);
	    }else {
	    
	    cartitems.setProduct(product);
	    cartitems.setUser(us);
	    shoppingCartService.save(cartitems);
	    }
		return "addtocart";
	}
	
	@GetMapping("/cart")
	public String viewUserCart(HttpSession session,Model model)
	{
	    User us=(User) session.getAttribute("user");
	    List<Cartitems> cartitems=shoppingCartService.getByUser(us);
	    if(cartitems.isEmpty()){
	    	return "viewemptycart";
	    }
	    model.addAttribute("cartitems", cartitems);
		return "viewusercart";
	}
	
	
	@GetMapping("/removeFromCart/{product.productid}")
	public String removeProductFromCart(@PathVariable(name="product.productid") int productid,HttpSession session,Model model)
	{
		User us=(User) session.getAttribute("user");
		Product product=productService.getById(productid);
		Cartitems cartitems=shoppingCartService.getByUserAndProduct(us, product);
		shoppingCartService.deleteById(cartitems.getCartid());
		return "redirect:/products/cart";
	}
	
	@GetMapping("/buynow")
	public String buyNow(HttpSession session,Model model)
	{
		User us=(User) session.getAttribute("user");
		List<Cartitems> cartitems=shoppingCartService.getByUser(us);
	    model.addAttribute("cartitems", cartitems);
	    return "Buynow";
	}
	
	@GetMapping("/order")
	public String orderNow(HttpSession session,Model model)
	{
		User us=(User) session.getAttribute("user");
		
	    List<Cartitems> cartitems=shoppingCartService.getByUser(us);
	    for (Cartitems ca : cartitems) {
	    	Productorder order=new Productorder();
	    	System.out.println("cartid" + ca.getCartid());
	    	Product pd=ca.getProduct();
	        order.setUser(us);
		    order.setOrderdate(new Date());
			order.setProduct(pd);
			order.setQuantity(ca.getQuantity());
			orderService.save(order);
			shoppingCartService.deleteById(ca.getCartid());
			pd.setProductcount(pd.getProductcount() - ca.getQuantity());
			productService.save(pd);
			
		}
	    List<Productorder> prodorder=orderService.getByUser(us);
	    model.addAttribute("prodorder",prodorder);
	    return "order";
	}
}
