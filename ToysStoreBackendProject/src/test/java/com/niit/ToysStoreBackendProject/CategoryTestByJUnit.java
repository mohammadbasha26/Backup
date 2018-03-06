package com.niit.ToysStoreBackendProject;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.CategoryDAO;
import com.niit.model.Category;

public class CategoryTestByJUnit {

/*	@Autowired
	static AnnotationConfigApplicationContext context;

	static CategoryDAO categoryDAO;

	// The above objects need to initialize
	*//**
	 * This method is going execute before calling any one of test case and will
	 * execute only once
	 *//*
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		// get the userDAO from context
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

		// get the user from context

	}

	@Test
	public void updateUserTestCase() {

		Category category = new Category();
		category.setCategoryName("abcd");
		category.setCategoryDesc("new cat");
		categoryDAO.addCategory(category);
		assertEquals(category.getCategoryName(), category.getCategoryName());

	}
*/
}
