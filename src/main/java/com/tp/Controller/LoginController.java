package com.tp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class LoginController 
{
	@RequestMapping("/login")
	public String login()
	{
		return "thymeleaf/User/Login";
	}
	
	@RequestMapping("/join")
	public String join()
	{
		return "thymeleaf/User/Join";
	}
	
	@RequestMapping("/find")
	public String find()
	{
		return "thymeleaf/User/Find";
	}
}
