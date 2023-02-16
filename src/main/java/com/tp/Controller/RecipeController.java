package com.tp.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.tp.Service.RecipeService;
import com.tp.Vo.Recipe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("recipe")
@Controller
public class RecipeController 
{
	@Autowired
	public RecipeService rs; 
	
	@RequestMapping("/main")
	public String main(Model m)
	{
		Map<String,Object> a = new HashMap<>();
		m.addAttribute("1", a);
		
		return "thymeleaf/recipe/RecipeMain";
	}
	
	@GetMapping("/add")
	public String add()
	{
		return "thymeleaf/recipe/RecipeAdd";
	}
	
	@PostMapping("/add")
	@ResponseBody
	public Map<String,Boolean> add(Recipe rec)
	{
		Map<String,Boolean> map = new HashMap<>();
		map.put("added", rs.RecipeAdd(rec));
		return map;
	}
	
	@RequestMapping("/list")
	public String list(Model m)
	{
		PageHelper.startPage(1,1);
		
		
		
		m.addAttribute("recipes", rs.AllRecipe());
		return "thymeleaf/recipe/RecipeList";
	}
}
