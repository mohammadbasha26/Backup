package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.DAO.CategoryDAO;
import com.niit.model.Category;

@Controller
public class CategoryController {

	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String category(Model category) {

		category.addAttribute("category", new Category());

		return "category";
	}

	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public ModelAndView category(@ModelAttribute Category cate) {
		ModelAndView cat = new ModelAndView();
		categoryDAO.addCategory(cate);
		cat.setViewName("redirect:/categorylist");
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
		return "redirect:/categorylist?del";
	}

	@RequestMapping("/updateCategory/{categoryID}")
	public ModelAndView editView(@PathVariable("categoryID") int categoryID) {
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

		mav.setViewName("redirect:/categorylist?update");
	
		return mav;

	}
}
