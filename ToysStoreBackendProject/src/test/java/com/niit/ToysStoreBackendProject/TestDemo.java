package com.niit.ToysStoreBackendProject;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.UserDAO;
import com.niit.model.User;


public class TestDemo {
	public static void main(String[] arg) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);

		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		
		User u=new User();
		u.setUserName("asdfg");
		u.setEmailID("asdfg@gmail.com");
		u.setGender("male");
		u.setMobileNO(36598529);
		u.setPassword("asdfgh");
		u.setUserAddress("Bangalore");
		userDAO.addUser(u);
		
		
	/*	CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

		Category category = new Category();
		category.setCategoryName("Toys");
		category.setCategoryDesc("Balls");

		categoryDAO.addCategory(category);*/

		/*ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");

		Product product = new Product();
		product.setProductName("Bat");
		product.setProductDesc("CrickettBat");
		product.setProductPrice(1200);
		product.setProductInStock(35);

		productDAO.addProduct(product);*/

		/*UserDAO userDAO = (UserDAO) context.getBean("userDAO");

		User uu=userDAO.getUser(4);

		uu.setUserName("shahrukh");
		userDAO.updateUser(uu);
		userDAO.deleteUser(4);*/

		/*SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		Supplier supplier = new Supplier();

		supplier.setSupplierName("asdfgh");
		supplier.setSupplierMobileNO(12354689);
		supplier.setSupplierAddress("Bangalore");

		supplierDAO.addSupplier(supplier);*/

	}
}
