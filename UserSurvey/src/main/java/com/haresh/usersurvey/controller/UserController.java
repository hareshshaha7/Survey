package com.haresh.usersurvey.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.haresh.usersurvey.model.User;
import com.haresh.usersurvey.service.UserService;

@Controller
public class UserController {
	
	final static Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	UserService service;
	
	//-------------------Retrieve All Users--------------------------------------------------------
	@RequestMapping(value = URIConstants.GET_ALL_USERS, method = RequestMethod.GET )
	public ModelAndView getAllUsers() {
		System.out.println("Retrieve All Users");
		logger.info("Retrieve All Users");
		
		List<User> users = service.getAllUsers();
		System.out.println(users);
//		if (!users.isEmpty()) 
//		{
//			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
//		}
//		else 
//		{
//			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
//		}	
		
//		return new ModelAndView("index.jsp", "command", new User(1,"Haresh", "Shaha", "Th Harry Show", "email", "asd123"));
		
		//return back to index.jsp
		ModelAndView model = new ModelAndView("index");
		model.addObject("msg", "Haresh");

		return model;

	}
}
