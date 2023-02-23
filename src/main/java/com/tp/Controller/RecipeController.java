package com.tp.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tp.Mapper.RecipeMapper;
import com.tp.Service.RecipeService;
import com.tp.Vo.Recipe;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("recipe")
@Controller
public class RecipeController 
{
	@Autowired
	public RecipeService rs; 
	
	@Autowired
	public RecipeMapper rm;
	
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
	
	@RequestMapping("/list/{page}/{row}")
	public String list(@PathVariable("page")int page, @PathVariable("row")int row, Model m)
	{
		PageHelper.startPage(page,row);
		PageInfo <Map<String,Object>> pageinfo = new PageInfo<>(rm.AllRecipe());
		
		m.addAttribute("pageinfo", pageinfo);
		m.addAttribute("pages", rs.pages(pageinfo));  // 페이지이동
		
		return "thymeleaf/recipe/RecipeList";
	}
	
	@RequestMapping("/detail/{rnum}")
	public String detail(@PathVariable("rnum") int rnum, Model m)
	{
		
		m.addAttribute("r",rs.GetRecipe(rnum));
		return "thymeleaf/recipe/RecipeDetail";
	}
	
	@PostMapping("/upload")
    @ResponseBody
      public Map<String, Object> upload(@RequestParam("files")MultipartFile[] mfiles,
                        HttpServletRequest request,				
                        Recipe rec) 
      {
       Map<String, Object> map = new HashMap<>();
       
       map.put("mfiles", mfiles);
       map.put("request", request);
       map.put("recipe", rec);
       
       Map<String, Object> added = new HashMap<>();
       added.put("added", rs.AddRec(map));
       
       return added;
      }
}
