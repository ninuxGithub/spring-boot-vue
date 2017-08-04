package org.master.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.master.user.IUserService;
import org.master.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kaenry on 2016/5/22. PublicController
 */
@Controller
public class PublicController {
	@Autowired
	private IUserService userService;

	@RequestMapping("/")
	public ModelAndView index(ModelAndView model, HttpServletRequest request) {
		List<User> users = userService.findAll();
//		model.addObject("users", users);
		request.getSession().setAttribute("users", users);
		model.setViewName("index");
		System.out.println(users);
		return model;
	}
}
