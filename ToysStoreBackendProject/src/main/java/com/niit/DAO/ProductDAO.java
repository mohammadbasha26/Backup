package com.niit.DAO;

import java.util.List;


import com.niit.model.Product;

public interface ProductDAO {

	public void addProduct (Product product);
	public void deleteProduct (int ProductID);	
	public void updateProduct (Product Product);	
	public Product getProduct (int ProductID);	
	
	public List<Product> getProducts();
	public List<Product> getProductsByCategory(int cid);
	public List<Product> getProductsBySupplier(int sid);

	
}
