package com.niit.DAO;

import java.util.List;

import com.niit.model.Category;

public interface CategoryDAO 
  {
	public void addCategory (Category category);
	public void deleteCategory (int categoryID) ;
	public void updateCategory (Category category);
	public Category getCategory (int categoryId);

	
	
	public List<Category>getCategories();
	}

