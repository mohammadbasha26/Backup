package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.DAO.CategoryDAO;
import com.niit.DAO.ProductDAO;
import com.niit.DAO.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
@RequestMapping("/admin")

public class AdminController {
	
	
	@Autowired
	ProductDAO productDAO;	
		
	
	
	 
	  @Autowired
		CategoryDAO categoryDAO;
	  
		@Autowired
		SupplierDAO supplierDAO;


	   @RequestMapping(value = "/product", method = RequestMethod.GET)
	   public String product(Model m) {
		 //  m.addAttribute("product", new Product());
		   m.addAttribute("clist", categoryDAO.getCategories());
		   m.addAttribute("slist", supplierDAO.getSuppliers());
		   
		   
	      return "p";
	   }
	   
	   
	   
		  @RequestMapping( value = "/saveProduct",method = RequestMethod.POST)
		   public ModelAndView product(HttpServletRequest request, @RequestParam("file") MultipartFile file){
			 Product p=new Product();
			 p.setProductName(request.getParameter("ProductName"));
			 
			 int price=Integer.parseInt(request.getParameter("ProductPrice"));
			 p.setProductPrice(price);
			 p.setProductDesc(request.getParameter("ProductDesc"));
			 int stock=Integer.parseInt(request.getParameter("ProductInStock"));
			 p.setProductInStock(stock);
			  
			  
			 Supplier s=supplierDAO.getSupplier(Integer.parseInt(request.getParameter("supplier")));
					 
					 
			  Category c=categoryDAO.getCategory(Integer.parseInt(request.getParameter("category")));
			  
			  p.setCategory(c);
			  p.setSupplier(s);
			  //cm.setCategory(c);
			  //cm.setSupplier(s);
			  //System.out.println("cccccccccccccc"+s.getSupplierName()+" "+s.getSupplierName());
		       ModelAndView ma=new ModelAndView();
		       
		       
		       String filepath = request.getSession().getServletContext().getRealPath("/");
				

				String filname = file.getOriginalFilename();
				p.setImgName(filname);
		       productDAO.addProduct(p);
		       
		       
		       System.out.println("File path File" + filepath + " " + filname);

				try {
					// byte imagebyte[] = product.getPimage().getBytes();
					byte imagebyte[] = file.getBytes();
					BufferedOutputStream fos = new BufferedOutputStream(
							new FileOutputStream(filepath + "/resources/images/" + filname));
					fos.write(imagebyte);
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
		       ma.setViewName("redirect:/admin/productlist");
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
				return "redirect:/admin/productlist?del";
		  }
		  
		  
		  
		  @RequestMapping("/updateProduct/{ProductID}")
		  
		  
			public ModelAndView editView2(@PathVariable("ProductID") int ProductID) {
				ModelAndView ma = new ModelAndView();

				Product p = productDAO.getProduct(ProductID);
				// ModelAndView mav = new ModelAndView("category");
				// mav.addObject("supplier", new Supplier());
				ma.addObject("uproduct", p);// Domain as Command
		System.out.println("--------------------"+p);
				ma.setViewName("updateproduct");
				return ma;
			}
		  
		  
		 /* 
		  @RequestMapping(value = "/saveUProduct", method = RequestMethod.POST)
			public ModelAndView updateProduct(@ModelAttribute("uproduct") Product uproduct) {
				
				System.out.println(uproduct.getProductID()+"--------------"+uproduct.getProductName()+"------------"+uproduct.getProductDesc());
				
				System.out.println("called");
				ModelAndView ma = new ModelAndView();
				productDAO.updateProduct(uproduct);

				ma.setViewName("redirect:/admin/productlist?update");
			
				return ma;

			}*/
		  
		  	  
		  @RequestMapping(value = "/saveUProduct", method = RequestMethod.POST)
			public ModelAndView updateProduct(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
				System.out.println("called");
				ModelAndView mav = new ModelAndView();

				String ProductID = request.getParameter("productID");
				String ProductName = request.getParameter("productName");
				// System.out.println(n);
				
				String p = request.getParameter("ProductPrice");
			 Product product = new Product();
				product.setProductID(Integer.parseInt(ProductID));
				product.setProductName(ProductName);
				 
			 
				product.setCategory(categoryDAO.getCategory(Integer.parseInt(request.getParameter("category"))));
				product.setSupplier(supplierDAO.getSupplier(Integer.parseInt(request.getParameter("supplier"))));
			
				 int price=Integer.parseInt(request.getParameter("productPrice"));
				 product.setProductPrice(price);
				
				product.setProductDesc(request.getParameter("productDesc"));
				product.setProductInStock(Integer.parseInt(request.getParameter("productInStock")));

				String filepath = request.getSession().getServletContext().getRealPath("/");
			
				String filname = file.getOriginalFilename();
				product.setImgName(filname);
				productDAO.updateProduct(product);
				System.out.println("File path File" + filepath + " " + filname);

				try {
					// byte imagebyte[] = product.getPimage().getBytes();
					byte imagebyte[] = file.getBytes();
					BufferedOutputStream fos = new BufferedOutputStream(
							new FileOutputStream(filepath + "/resources/images/" + filname));
					fos.write(imagebyte);
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

				mav.setViewName("redirect:/admin/productlist?update");
				return mav;

			}
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  

			@ModelAttribute
			public void addAttributes(Model model) {
				
				List<Category> clist= categoryDAO.getCategories();
				
				
				List<Supplier> slist=supplierDAO.getSuppliers();
			   model.addAttribute("clist",clist);
			   model.addAttribute("slist",slist);
			   model.addAttribute("catList",clist);


			} 
		  
		
		 
			@RequestMapping(value = "/category", method = RequestMethod.GET)
			public String category(Model category) {

				category.addAttribute("category", new Category());

				return "category";
			}

			@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
			public ModelAndView category(@ModelAttribute Category cate) {
				ModelAndView cat = new ModelAndView();
				categoryDAO.addCategory(cate);
				cat.setViewName("redirect:/admin/categorylist");
				return cat;

			}

			@RequestMapping("/categorylist")
			public ModelAndView contactList() {
				ModelAndView cat = new ModelAndView();

				List<Category> clist = categoryDAO.getCategories();

				for (Category category : clist) {
					// System.out.println(category.getCategoryName()+"--------------------------------------------------------------------------");

				}

				cat.setViewName("categoryList");
				cat.addObject("categoryList", clist);
				return cat;
			}

			@RequestMapping("/deleteCategory/{categoryID}")
			public String deleteCategory(@PathVariable("categoryID") int categoryID) {
				// contactDAO.delete(contactId);
				categoryDAO.deleteCategory(categoryID);
				return "redirect:/admin/categorylist?del";
			}

			@RequestMapping("/updateCategory/{categoryID}")
			public ModelAndView editView3(@PathVariable("categoryID") int categoryID) {
				ModelAndView mav = new ModelAndView();

				Category cat1 = categoryDAO.getCategory(categoryID);

				//cat.addObject("categorylist", categoryDAO.getCategories());

				mav.addObject("ucat", cat1);
				mav.setViewName("updatecategory");
				return mav;
			}

			@RequestMapping(value = "/updateSCategory", method = RequestMethod.POST)
			public ModelAndView updateCategory(@ModelAttribute("ucat") Category ucat) {
				
				System.out.println(ucat.getCategoryID()+"--------------"+ucat.getCategoryDesc()+"------------"+ucat.getCategoryName());
				
				System.out.println("called");
				ModelAndView mav = new ModelAndView();
				categoryDAO.updateCategory(ucat);

				mav.setViewName("redirect:/admin/categorylist?update");
			
				return mav;

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
				       su.setViewName("redirect:/admin/supplierlist");
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
						return "redirect:/admin/supplierlist?del";
				  }
				 
				  
				  
				  
				  @RequestMapping("/updateSupplier/{SupplierID}")
					public ModelAndView editView(@PathVariable("SupplierID") int SupplierID) {
						ModelAndView su = new ModelAndView();

						Supplier s = supplierDAO.getSupplier(SupplierID);
						// ModelAndView mav = new ModelAndView("category");
						// mav.addObject("supplier", new Supplier());
						su.addObject("usupplier", s);// Domain as Command
				
						su.setViewName("updatesupplier");
						return su;
					}
				  
				  
				  
				  @RequestMapping(value = "/saveUSupplier", method = RequestMethod.POST)
						public ModelAndView updateSupplier(@ModelAttribute("usupplier") Supplier usupplier) {
							
							System.out.println(usupplier.getSupplierID()+"--------------"+usupplier.getSupplierName()+"------------"+usupplier.getSupplierAddress());
							
							System.out.println("called");
							ModelAndView su = new ModelAndView();
							supplierDAO.updateSupplier(usupplier);

							su.setViewName("redirect:/admin/supplierlist?update");
						
							return su;

						}


}
