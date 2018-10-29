package com.haresh.usersurvey.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.haresh.usersurvey.model.User;

@Controller
public class UserController {
	final static Logger logger = Logger.getLogger(UserController.class);
		
	//-------------------Retrieve All Users--------------------------------------------------------
	// @RequestMapping(value = RestURIConstants.FIND_ALL_USERS, method = RequestMethod.GET )
	@GetMapping(value = URIConstants.GET_ALL_USERS)
	public ModelAndView getAllUsers()
	{
		System.out.println("Retrieve All Users");
		logger.info("Retrieve All Users");
		
//		List<User> users = service.findAllUsers();
//		if (!users.isEmpty()) 
//		{
//			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
//		}
//		else 
//		{
//			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
//		}		
		return new ModelAndView("index.jsp", "User", new User(1,"Haresh", "Shaha", "Th Harry Show", "email", "asd123"));
	}
}
