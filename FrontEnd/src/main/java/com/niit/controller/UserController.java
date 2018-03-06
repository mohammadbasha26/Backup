package com.niit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.DAO.UserDAO;
import com.niit.model.User;


@Controller

public class UserController {
	@Autowired
	UserDAO userDAO;
	
	
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

}
