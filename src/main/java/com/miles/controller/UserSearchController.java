package com.miles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miles.entity.User;
import com.miles.service.UserSearchService;

@RestController
public class UserSearchController {
	
	@Autowired
	private UserSearchService userSearchService;

	@RequestMapping(value = "/userSearch", method = RequestMethod.GET,produces="application/json")
	public List<User> displayUserSearch(Model model) {
		return userSearchService.getUsers();
    }
	
}
