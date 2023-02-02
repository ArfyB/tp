package com.tp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/menurec")
@Controller
public class MainController 
{
	@RequestMapping("/main")
	public String main()
	{
		return "thymeleaf/menurec/main";
	}
}
