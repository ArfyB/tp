package com.tp.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tp.Vo.Material;

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
	public Map<String,Object> testa(@RequestBody Map<String, List<Material>> data)
	{
		List<Material> materials = data.get("materials");
		
		System.out.println(materials.get(1).getMname());
		
		Map<String,Object> a = new HashMap<>();
		a.put("added", true);
		return a;
	}
	
}
