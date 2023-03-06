package com.tp.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tp.Service.UserService;
import com.tp.Vo.User_info;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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
	public Map<String,Object> join1(User_info ui, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Map<String,Object> map = new HashMap<>();
		if(us.dologin(ui))
		{
			session.setAttribute("uid", ui.getUser_id());
			map.put("added", true);
		}
		else
		{
			map.put("added", false);
		}
		return map;
	}
	
	@PostMapping("/join")
	@ResponseBody
	public Map<String, Object> join(User_info ui)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("added", us.UserAdd(ui));
		return map;
	}
	
	
}
