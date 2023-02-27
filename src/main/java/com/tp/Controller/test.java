package com.tp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("test")
@Controller
public class test 
{
	@GetMapping("/test")
	public String add()
	{
		return "thymeleaf/testing/testing";
	}
	
	@PostMapping("/test")
	@ResponseBody
	public String test()
	{
		return "thymeleaf/test/test";
	}
}
