package com.tp.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("recipe")
@Controller
public class RecipeController 
{
	@RequestMapping("/main")
	public String main(Model m)
	{
		Map<String,Object> a = new HashMap<>(); 
		m.addAttribute("1", a);
		return "thymeleaf/recipe/RecipeMain";
	}
	
	@RequestMapping("/add")
	public String add()
	{
		return "thymeleaf/recipe/RecipeAdd";
	}
	
}
