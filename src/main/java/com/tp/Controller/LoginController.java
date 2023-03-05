package com.tp.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tp.Service.UserService;
import com.tp.Vo.User_info;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class LoginController 
{
	@Autowired
	UserService us;
	
	
	@RequestMapping("/login")
	public String login()
	{
		return "thymeleaf/User/Login";
	}

	@PostMapping("/login")
	@ResponseBody
	public Map<String,Object> join1(User_info ui)
	{
		Map<String,Object> map = new HashMap<>();
		if(us.dologin(ui))
		{
			map.put("added", true);
		}
		else
		{
			map.put("added", false);
		}
		return map;
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
