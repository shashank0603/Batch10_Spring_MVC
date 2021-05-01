package com.te.empwebapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringMVCController {
	
	@GetMapping("/login1")
	public String getLoginpage() {
		return "loginPage";
	}

	@PostMapping("/login")
	public String getFormdata(HttpServletRequest request, ModelMap map) {
		String username = request.getParameter("user");
		String password = request.getParameter("pwd");
		map.addAttribute("user", username);
		map.addAttribute("pwd", password);
		return "home";
	}// getFormData

	@PostMapping("/login1")
	public String getDataFormRequestParam(@RequestParam(name = "user") String name, @RequestParam(name = "pwd") String pwd,
			ModelMap map) {
		map.addAttribute("user", name);
		map.addAttribute("pwd", pwd);
		return "home";

	}

	@PostMapping("/login2")
	public String getDataFromMethod(String user, String pwd, ModelMap map) {
		map.addAttribute("user", user);
		map.addAttribute("pwd", pwd);
		return "home";
	}

	@PostMapping("/login3")
	public String getDataFromDTO(UserBean bean, ModelMap map) {
		System.out.println(bean);
		map.addAttribute("user", bean.getUser());
		map.addAttribute("pwd", bean.getPwd());
		return "home";
	}
}

