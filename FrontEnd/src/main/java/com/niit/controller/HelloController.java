/*package com.niit.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.DAO.CategoryDAO;
import com.niit.DAO.ProductDAO;
import com.niit.DAO.SupplierDAO;
import com.niit.DAO.UserDAO;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;



@Controller
public class HelloController {

	@Autowired
UserDAO userDAO;
	@Autowired
ProductDAO productDAO;
	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
CategoryDAO categoryDAO;	
	
	 
	  

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid User user, BindingResult result,
			Map model) {

		
		if (result.hasErrors()) {
			return "login";
		}
		
		
		String userName = "UserName";
		String password = "password";
		loginForm = (LoginForm) model.get("loginForm");
		if (!loginForm.getUserName().equals(userName)
				|| !loginForm.getPassword().equals(password)) {
			return "loginform";
		}
		
		boolean user = user.validateUser(user.getEmailID(),user.getPassword());
		if(user){
			model.put("login", user);
			return "home";
		}else{
			result.rejectValue("EmailID","Password");
			return "login";
		}

	
	  
	  @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login", new User());
	    return mav;
	  }
	  
	  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("login") User login) {
	    ModelAndView mav = null;
	    Boolean user = userDAO.validateUser(login.getEmailID(), login.getPassword());
	    if (user==true) {
	    mav = new ModelAndView("home");
	    HttpSession hs=request.getSession();
	    hs.setAttribute("user", login.getEmailID());
	    } else {
	    mav = new ModelAndView("login");
	    mav.addObject("message", "Username or Password is wrong!!");
	    }
	    return mav;
	 
	  }
	   
	   
	  @RequestMapping(value = "/logout", method = RequestMethod.GET)
	   public String logout(HttpServletRequest request) {
		 HttpSession hs=request.getSession();
		 hs.removeAttribute("user");
		 hs.invalidate();
		 
	      return "home";
	   }
	    
	  
	  
	 
	   @RequestMapping(value = "/home", method = RequestMethod.GET)
	   public String printHello2() {
	      return "home";
	   }
	    
	   
	   @RequestMapping(value = "/register", method = RequestMethod.GET)
	   public String register(Model m) {
		   m.addAttribute("u", new User());
		   
	      return "register";

	}
	   
	   
	  @RequestMapping( value = "/saveRegister",method = RequestMethod.POST)
	   public ModelAndView register(@ModelAttribute User cmd){
	       ModelAndView mav=new ModelAndView();
	       userDAO.addUser(cmd);
	       mav.setViewName("home");
	   return mav;

	   } 
	       
	   
	   
	   @RequestMapping(value = "/about", method = RequestMethod.GET)
	   public String about() {
	      return "about";

	}
	   
	   
	   
	   @RequestMapping(value = "/product", method = RequestMethod.GET)
	   public String product(Model product) {
		   product.addAttribute("product", new Product());
		   
	      return "product";
	   }
		  @RequestMapping( value = "/saveProduct",method = RequestMethod.POST)
		   public ModelAndView product(@ModelAttribute Product cm){
		       ModelAndView ma=new ModelAndView();
		       productDAO.addProduct(cm);
		       ma.setViewName("redirect:/productlist");
		   return ma;

		   } 
		  @RequestMapping("/productlist")
			public ModelAndView productList() {
				ModelAndView ma = new ModelAndView();
				// User user = (User) session.getAttribute("user");
				 List<Product> plist=productDAO.getProducts();
				 
				 for (Product product : plist) {
					 System.out.println(product.getProductName()+"--------------------------------------------------------------------------");
					
				}
				 
				 ma.setViewName("productList");
				ma.addObject("productList",plist);
				return ma;
			}
		  
		  
		  
		  @RequestMapping("/deleteProduct/{ProductID}")
			public String delete(@PathVariable("ProductID") int ProductID) {
				// contactDAO.delete(contactId);
				productDAO.deleteProduct(ProductID);
				return "redirect:/productlist?del";
		  }
		  
		  
		  
		       
		  @RequestMapping(value = "/supplier", method = RequestMethod.GET)
		   public String supplier(Model supplier) {
			  
				   supplier.addAttribute("supplier", new Supplier());
				   
			   
		      return "supplier";
		   }
			  @RequestMapping( value = "/saveSupplier",method = RequestMethod.POST)
			   public ModelAndView supplier(@ModelAttribute Supplier sup){
			       ModelAndView su=new ModelAndView();
			       supplierDAO.addSupplier(sup);
			       su.setViewName("redirect:/supplierlist");
			   return su;

			   } 
			  
			  @RequestMapping("/supplierlist")
				public ModelAndView supplierList() {
					ModelAndView su = new ModelAndView();
					// User user = (User) session.getAttribute("user");
					 List<Supplier> slist=supplierDAO.getSuppliers();
					 
					 for (Supplier supplier : slist) {
						 System.out.println(supplier.getSupplierName()+"--------------------------------------------------------------------------");
						
					}
					 
					 su.setViewName("supplierList");
					su.addObject("supplierList",slist);
					return su;
				}
			  
			  @RequestMapping("/deleteSupplier/{SupplierID}")
				public String deleteSupplier(@PathVariable("SupplierID") int SupplierID) {
					// contactDAO.delete(contactId);
					supplierDAO.deleteSupplier(SupplierID);
					return "redirect:/supplierlist?del";
			  }
			 
			  

				 
				 
				 

		
				  
	}
	   


*/