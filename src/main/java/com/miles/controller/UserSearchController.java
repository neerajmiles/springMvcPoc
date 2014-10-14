package com.miles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miles.entity.User;
import com.miles.service.UserSearchService;

@Controller
public class UserSearchController {
	
	@Autowired
	private UserSearchService userSearchService;

	@RequestMapping(value = "/search", method = {RequestMethod.GET,RequestMethod.POST},produces="application/json")
	@ResponseBody
	public List<User> searchUsers(@RequestParam(value = "user", defaultValue = "") final String user) {
		return userSearchService.findUsersLike(user);		
    }
	
	@RequestMapping(value = "/userSearch", method = {RequestMethod.GET,RequestMethod.POST})
	public String displayUserSearch(@RequestParam String user) {
		return "userSearch";
    }
	
}
