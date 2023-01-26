package com.tp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/main")
@Controller
public class MainController 
{
	@RequestMapping("/")
	public String main()
	{
		return "thymeleaf/main";
	}
}
