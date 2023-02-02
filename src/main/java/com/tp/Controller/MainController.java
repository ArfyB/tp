package com.tp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menurec")
public class MainController 
{
	@RequestMapping("/main")
	public String main()
	{
		return "thymeleaf/menurec/main";
	}
}
