package com.tp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("recipe")
@Controller
public class RecipeController 
{
	@RequestMapping("/main")
	public String main()
	{
		return "thymeleaf/recipe/RecipeMain";
	}
}
