package com.tp.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@PostMapping("/join")
	@ResponseBody
	public Map<String,Object> join1()
	{
		Map<String,Object> map = new HashMap<>();
		map.put("added", true);
		return map;
	}
	
}
