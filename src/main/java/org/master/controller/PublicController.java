package org.master.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.master.user.IUserService;
import org.master.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kaenry on 2016/5/22. PublicController
 */
@Controller
public class PublicController {
	private static final Logger logger = LoggerFactory.getLogger(PublicController.class);
	
	@Autowired
	private IUserService userService;

	@RequestMapping("/")
	public ModelAndView index(ModelAndView model, HttpServletRequest request) {
		List<User> users = userService.findAll();
		request.getSession().setAttribute("users", users);
		model.setViewName("index");
		System.out.println(users);
		return model;
	}
	@RequestMapping("/test")
	public ModelAndView test(ModelAndView model, HttpServletRequest request) {
		logger.info("test page...");
		List<User> users = userService.findAll();
		request.getSession().setAttribute("users", users);
		model.setViewName("test");
		return model;
	}
	
	
	@RequestMapping(value ="/input", method = RequestMethod.GET)
	public ModelAndView addUser(ModelAndView model, HttpServletRequest request) {
		logger.info("2 input...");
		model.setViewName("input");
		User user = new User();
		user.setId(-1L);
		user.setPassword("");
		user.setUsername("");
		request.getSession().setAttribute("user", user);
		return model;
	}
	@RequestMapping(value ="/inputUser", method = RequestMethod.POST)
	public ModelAndView inputUser(@ModelAttribute User user, ModelAndView model, HttpServletRequest request) {
		logger.info("添加的用户为：{} ", user.toString());
		
		List<User> users = userService.findAll();
		request.getSession().setAttribute("users", users);
		model.setViewName("test");
		return model;
	}
	
	
	@ResponseBody
	@RequestMapping("/jsonData")
	public List<String> jsonData() {
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		return list;
	}
}
